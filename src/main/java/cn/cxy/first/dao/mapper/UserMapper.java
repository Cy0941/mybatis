package cn.cxy.first.dao.mapper;

import cn.cxy.first.model.User;

import java.util.List;

/**
 * Function: 采用 mapper 代理开发DAO
 * 开发规范：
 *      1、对应 mapper.xml 中的 namespace 为当前 java 的全类名
 *      2、方法名与对应 mapper.xml 文件中 sql 的 id ；参数类型及返回值必须意义对应
 *      3、mapper 接口中只能允许一个参数  -  需要多参数时可以采用包装类型解决（java.util.Map 等）  --  不利于业务扩展
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/9/28 7:57 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public interface UserMapper {

    User findUserById(int id) throws Exception;

    List<User> findUserByName(String name) throws Exception;

    void deleteById(Integer id) throws Exception;

    void addUser(User user) throws Exception;

}
