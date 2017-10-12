package cn.cxy.mybatis.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/10/9 21:45 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
@Setter
@Getter
@ToString
public class OrderDetails {

    private Integer id;
    private Integer orderId;
    private Integer itemId;
    private String itemNum;

    //一对一产品
    private Items items;

}
