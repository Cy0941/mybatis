package cn.cxy.mybatis.vo;

import cn.cxy.mybatis.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Function: 自定义查询实体
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/9/28 23:48 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */

@Setter
@Getter
public class UserQueryVo {

    private User user;

    private List<Integer> ids;

    private List<String> names;

    //TODO 其他必要的查询参数

}
