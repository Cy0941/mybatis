package cn.cxy.mybatis.vo;

import cn.cxy.mybatis.model.Orders;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Function: 使用resultType实现一对一关联查询  --  继承自结果中字段较多的实体类，在相应引入对应属性
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/10/9 22:02 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
@Getter
@Setter
@ToString
public class UserOrderVo extends Orders {

    private String username;
    private Integer sex;
    private Integer user_id;

}
