package cn.cxy.first.dao;

import cn.cxy.first.model.User;

import java.util.List;

/**
 * Function: TODO
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
