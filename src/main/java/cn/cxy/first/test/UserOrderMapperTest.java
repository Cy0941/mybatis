package cn.cxy.first.test;

import cn.cxy.first.dao.mapper.UserOrderMapper;
import cn.cxy.first.vo.UserOrderVo;
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
 * Date: 2017/10/9 22:07 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class UserOrderMapperTest extends TestCase {

    private SqlSessionFactory factory;

    public void setUp() throws Exception {
        String resource = "sqlMapConfig_1.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        factory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public void testFindUserOrder() throws Exception {

        SqlSession sqlSession = factory.openSession();
        UserOrderMapper mapper = sqlSession.getMapper(UserOrderMapper.class);
        List<UserOrderVo> orderVoList = mapper.findUserOrder();
        System.err.println(orderVoList);
        sqlSession.close();
    }

}