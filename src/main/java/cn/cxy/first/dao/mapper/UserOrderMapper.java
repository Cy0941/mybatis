package cn.cxy.first.dao.mapper;

import cn.cxy.first.vo.UserOrderVo;

import java.util.List;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/10/9 22:04 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public interface UserOrderMapper {

    List<UserOrderVo> findUserOrder() throws Exception;

}
