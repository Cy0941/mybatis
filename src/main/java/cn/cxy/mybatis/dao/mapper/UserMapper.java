package cn.cxy.mybatis.dao.mapper;

import cn.cxy.mybatis.model.User;
import cn.cxy.mybatis.model.UserCustomer;
import cn.cxy.mybatis.vo.UserQueryVo;

import java.util.List;

/**
 * Function: 采用 mapper 代理开发DAO
 * 开发规范：
 *      1、对应 mapper.xml 中的 namespace 为当前 java 的全类名
 *      2、方法名与对应 mapper.xml 文件中 sql 的 id ；参数类型及返回值必须一一对应
 *      3、mapper 接口中只能允许一个参数  -  需要多参数时可以采用包装类型解决（java.util.Map 等）  --  不利于业务扩展
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/9/28 7:57 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public interface UserMapper {

    List<User> findConditionsUserList(UserQueryVo vo) throws Exception;

    List<User> findUserResultMap(UserQueryVo vo) throws Exception;

    List<UserCustomer> findUserList(UserQueryVo vo) throws Exception;

    int findUserCount(UserQueryVo vo) throws Exception;

    User findUserById(int id) throws Exception;

    void updateUser(User user) throws Exception;

    List<User> findUserByName(String name) throws Exception;

    void deleteById(Integer id) throws Exception;

    void addUser(User user) throws Exception;

}
