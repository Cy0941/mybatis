package cn.cxy.first;

import cn.cxy.first.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/9/27 21:53 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class Main {

    @Test
    public void findUserById() throws IOException {
        User user = sqlSession.selectOne("test.findUserById",1);
        System.err.println(user);
    }

    @Test
    public void findUserByName() throws IOException {
        List<User> userList = sqlSession.selectList("test.findUserByName","测试");
        System.err.println(userList);
    }

    @Test
    public void addUser() throws IOException {
        User user = new User();
        user.setAddress("四川广安");
        user.setBirthday(new Date());
        user.setSex(User.SEX_GIRL);
        user.setUsername("黄丽晔");
        sqlSession.insert("test.addUser",user);
        //TODO 插入数据库需要进行手动提交（默认情况下autoCommit=false）
        sqlSession.commit();
    }

    /**
     * 自增主键返回
     * @throws IOException
     */
    @Test
    public void autoIncrementId() throws IOException {
        User user = new User();
        user.setAddress("四川色达");
        user.setBirthday(new Date());
        user.setSex(User.SEX_BOY);
        user.setUsername("张麻子");
        sqlSession.insert("test.autoIncrementId",user);
        //TODO 插入数据库需要进行手动提交（默认情况下autoCommit=false）
        sqlSession.commit();
        System.err.println(user.getId());
    }

    /**
     * 非自增主键返回：需要将id属性设置为字符串类型且长度为35
     * @throws IOException
     */
    @Test
    public void handleIncrementId() throws IOException {
        User user = new User();
        user.setAddress("四川宜宾");
        user.setBirthday(new Date());
        user.setSex(User.SEX_BOY);
        user.setUsername("泸州老窖");
        sqlSession.insert("test.handleIncrementId",user);
        //TODO 插入数据库需要进行手动提交（默认情况下autoCommit=false）
        sqlSession.commit();
        System.err.println(user.getId());
    }

    @Test
    public void deleteById(){
        sqlSession.delete("test.deleteById",11);
        sqlSession.commit();
    }

    @Test
    public void updateUser(){
        User user = new User();
        user.setId(10);
        user.setAddress("贵州");
        user.setBirthday(new Date());
        user.setSex(User.SEX_BOY);
        user.setUsername("茅台");
        sqlSession.insert("test.updateUser",user);
        //TODO 插入数据库需要进行手动提交（默认情况下autoCommit=false）
        sqlSession.commit();
        System.err.println(user.getId());
    }

    @Before
    public void setUp() throws Exception {
        String resource = "sqlMapConfig_1.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory =  new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = factory.openSession();
    }

    @After
    public void tearDown() throws Exception {
        sqlSession.close();
    }

    private SqlSession sqlSession;
}
