package cn.cxy.mybatis.dao.mapper;

import cn.cxy.mybatis.model.User;
import cn.cxy.mybatis.model.UserCustomer;
import cn.cxy.mybatis.vo.UserQueryVo;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/10/10 20:39 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class UserMapperTest extends TestCase {

    private SqlSessionFactory factory;
    private SqlSession sqlSession;

    public void setUp() throws Exception {
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        factory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public void testFindUserList() throws Exception {
        sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserQueryVo vo = new UserQueryVo();
        UserCustomer customer = new UserCustomer();
        customer.setSex(1);
        customer.setUsername("测试");
        vo.setUser(customer);
        List<Integer> ids = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
            add(7);
            add(8);
        }};
        vo.setIds(ids);
        List<String> names = new ArrayList<String>() {{
            add("李二蛋");
            add("张三丰");
            add("测试2");
            add("茅台");
            add("李明慧");
        }};
        vo.setNames(names);
        List<UserCustomer> userList = mapper.findUserList(vo);
        int count = mapper.findUserCount(vo);
        System.err.println(count + " : " + userList);
    }

    public void testFindUserResultMap() throws Exception {
        sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserQueryVo vo = new UserQueryVo();
        UserCustomer customer = new UserCustomer();
        customer.setSex(1);
        customer.setUsername("测试");
        vo.setUser(customer);
        List<User> userList = mapper.findUserResultMap(vo);
        System.err.println(userList);
    }

    /**
     * 动态 sql 测试
     *
     * @throws Exception
     */
    public void testFindConditionsUserList() throws Exception {
        sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserQueryVo vo = new UserQueryVo();
        UserCustomer customer = new UserCustomer();
        customer.setSex(1);
        customer.setUsername("测试");
        vo.setUser(customer);
        List<User> userList = mapper.findConditionsUserList(null);
        System.err.println(userList);
    }

    public void testFindUserById() throws Exception {
        sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUserById(1);
        System.out.println(user);
    }

    /**
     * 一级缓存：sqlSession 级别缓存 - myBatis 默认开启一级缓存；当 sqlSession 执行 commit（create | update | delete） 操作会清空一级缓存
     *
     * @throws Exception
     */
    public void testCacheLevelOne() throws Exception {
        sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = mapper.findUserById(1);

        //sqlSession 执行commit操作会清空一级缓存
        user1.setAddress("四川自贡");
        mapper.updateUser(user1);
        sqlSession.commit();

        User user2 = mapper.findUserById(1);
        System.out.println(user1.getId() + " : " + user2.getId());
    }

    /**
     * 二级缓存：mapper | mapper.xml 中 namespace 级别缓存 - myBatis 默认在 mybatisConfig.xml 中开启二级缓存；当 sqlSession 执行 commit（create | update | delete） 操作会清空二级缓存
     *  需要同时在 mapper.xml 中进行分别开启；可同时在 select 中使用 useCache 进行更细粒度的控制
     *
     * @throws Exception
     */
    public void testCacheLevelTwo() throws Exception {
        SqlSession sqlSession1 = factory.openSession();
        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        User user1 = mapper1.findUserById(1);
        sqlSession1.commit();
        sqlSession1.close();

        //sqlSession 执行 commit 操作会清空缓存
        /*SqlSession sqlSession2 = factory.openSession();
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = mapper2.findUserById(1);
        sqlSession1.close();
        user2.setAddress("四川成都");
        mapper2.updateUser(user2);
        sqlSession2.commit();
        sqlSession2.close();*/

        SqlSession sqlSession3 = factory.openSession();
        UserMapper mapper3 = sqlSession3.getMapper(UserMapper.class);
        User user3 = mapper3.findUserById(1);
        sqlSession3.commit();
        sqlSession3.close();
        System.out.println(user1.getId() + " : " + user3.getId());
    }

    public void testFindUserByName() throws Exception {
        //TODO
    }

    public void testDeleteById() throws Exception {
        //TODO
    }

    public void testAddUser() throws Exception {
        //TODO
    }

    @Override
    public void tearDown() throws Exception {
        sqlSession.close();
    }

}