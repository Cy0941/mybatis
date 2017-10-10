package cn.cxy.mybatis.dao.old;

import cn.cxy.mybatis.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Function: SqlSession 线程不安全 - 在方法中定义为局部变量使用
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/9/28 7:58 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class UserDaoImpl implements UserDao {

    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    public User findById(Integer id) throws Exception {
        SqlSession sqlSession = factory.openSession();
        User user = sqlSession.selectOne("test.findUserById", id);
        sqlSession.close();
        return user;
    }

    public List<User> findByNameLike(String name) throws Exception {
        SqlSession sqlSession = factory.openSession();
        List<User> userList = sqlSession.selectList("test.findUserByName", name);
        sqlSession.close();
        return userList;
    }

    public void delete(Integer id) throws Exception {
        SqlSession sqlSession = factory.openSession();
        sqlSession.delete("test.deleteById", id);
        sqlSession.commit();
        sqlSession.close();
    }

    public void addUser(User user) throws Exception {
        SqlSession sqlSession = factory.openSession();
        sqlSession.delete("test.addUser", user);
        sqlSession.commit();
        sqlSession.close();
    }
}
