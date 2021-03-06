package cn.cxy.mybatis.dao.mapper;

import cn.cxy.mybatis.model.Orders;
import cn.cxy.mybatis.model.User;
import cn.cxy.mybatis.vo.UserOrderVo;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/10/10 20:43 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class UserOrderMapperTest extends TestCase {

    public void testFindUserOrdersLazyLoading() throws Exception {
        sqlSession = factory.openSession();
        UserOrderMapper mapper = sqlSession.getMapper(UserOrderMapper.class);
        List<Orders> ordersList = mapper.findUserOrdersLazyLoading();
        for (Orders orders : ordersList) {
            /*cxy 默认会使用一级缓存（sqlSession级别缓存）*/
            User user = orders.getUser();
            System.out.println(user);
        }
        sqlSession.close();
    }

    public void testFindUserItemsResultMap() throws Exception{
        sqlSession = factory.openSession();
        UserOrderMapper mapper = sqlSession.getMapper(UserOrderMapper.class);
        List<User> userList = mapper.findUserItemsResultMap();
        System.err.println(userList);
        sqlSession.close();
    }

    public void testFindUserOrder() throws Exception {
        sqlSession = factory.openSession();
        UserOrderMapper mapper = sqlSession.getMapper(UserOrderMapper.class);
        List<UserOrderVo> orderVoList = mapper.findUserOrder();
        System.err.println(orderVoList);
        sqlSession.close();
    }

    public void testFindUserOrderResultMap() throws Exception {
        sqlSession = factory.openSession();
        UserOrderMapper mapper = sqlSession.getMapper(UserOrderMapper.class);
        List<Orders> ordersList = mapper.findUserOrderResultMap();
        System.err.println(ordersList);
        sqlSession.close();
    }

    public void testFindOrderAndOrderDetailResultMap() throws Exception {
        sqlSession = factory.openSession();
        UserOrderMapper mapper = sqlSession.getMapper(UserOrderMapper.class);
        List<Orders> ordersList = mapper.findOrderAndOrderDetailResultMap();
        System.err.println(ordersList);
        sqlSession.close();
    }

    public void setUp() throws Exception {
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        factory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Override
    public void tearDown() throws Exception {
        sqlSession.close();
    }

    private SqlSessionFactory factory;
    private SqlSession sqlSession;
}