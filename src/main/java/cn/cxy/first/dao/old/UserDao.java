package cn.cxy.first.dao.old;

import cn.cxy.first.model.User;

import java.util.List;

/**
 * Function: 原始DAO开发
 *      1、实现类中存在大量模板方法
 *      2、调用 statement 方法时将 statement 的 id 硬编码了
 *      3、由于 sqlsession 调用方法采用 object 接收 - 无法在编译阶段发现参数错误
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/9/28 7:57 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public interface UserDao {

    User findById(Integer id) throws Exception;

    List<User> findByNameLike(String name) throws Exception;

    void delete(Integer id) throws Exception;

    void addUser(User user) throws Exception;

}
