package cn.cxy.mybatis.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/10/9 21:40 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */

@Setter
@Getter
@ToString
public class Orders {

    private Integer id;
    private String number;
    private Integer userId;
    private Date createTime;
    private String note;

    //使用resultMap实现一对一查询结果封装 TODO resultMap 可以实现延迟加载
    private User user;

}
