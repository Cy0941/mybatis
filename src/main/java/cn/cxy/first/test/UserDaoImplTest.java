package cn.cxy.first.test;

import cn.cxy.first.dao.UserDao;
import cn.cxy.first.dao.UserDaoImpl;
import cn.cxy.first.model.User;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.Calendar;
import java.util.List;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/9/28 8:08 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class UserDaoImplTest extends TestCase {

    private SqlSessionFactory factory;

    public void setUp() throws Exception {
        String resource = "sqlMapConfig_1.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        factory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public void testFinById() throws Exception {
        UserDao dao = new UserDaoImpl(factory);
        User user = dao.findById(1);
        System.out.println(user);
    }

    public void testFindByNameLike() throws Exception {
        UserDao dao = new UserDaoImpl(factory);
        List<User> userList = dao.findByNameLike("测试");
        System.out.println(userList);
    }

    public void testDelete() throws Exception {
        UserDao dao = new UserDaoImpl(factory);
        dao.delete(10);
    }

    public void testAddUser() throws Exception {
        UserDao dao = new UserDaoImpl(factory);
        User user = new User();
        user.setUsername("柳青");
        user.setSex(User.SEX_GIRL);
        user.setBirthday(Calendar.getInstance().getTime());
        user.setAddress("北京");
        dao.addUser(user);
    }

}