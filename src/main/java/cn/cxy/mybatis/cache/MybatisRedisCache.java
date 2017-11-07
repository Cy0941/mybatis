package cn.cxy.mybatis.cache;

import cn.cxy.util.SerializeUtil;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.cache.CacheException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/11/7 23:10 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class MybatisRedisCache implements Cache {

    private static Logger logger = LoggerFactory.getLogger(MybatisRedisCache.class);
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Jedis redisClient = createRedis();
    private String id;

    public MybatisRedisCache(final String id) {
        if (null == id) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>MybatisRedisCache:id=" + id);
        this.id = id;
    }

    private Jedis createRedis() {
        JedisPool pool = new JedisPool("127.0.0.1", 6379);
        return pool.getResource();
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        try {
            redisClient.set(SerializeUtil.serialize(key.toString()), SerializeUtil.serialize(value.toString()));
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    @Override
    public Object getObject(Object key) {
        try {
            Object value = SerializeUtil.unserialize(redisClient.get(SerializeUtil.serialize(key.toString())));
            return value;
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    @Override
    public Object removeObject(Object key) {
        return redisClient.expire(SerializeUtil.serialize(key.toString()), 0);
    }

    @Override
    public void clear() {
        redisClient.flushDB();
    }

    @Override
    public int getSize() {
        try {
            return Integer.valueOf(redisClient.dbSize().toString());
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }
}
