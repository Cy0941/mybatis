package cn.cxy.first.model;

import lombok.Getter;
import lombok.Setter;

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
public class OrderDetails {

    private Integer id;
    private Integer orderId;
    private Integer itemId;
    private String itemNum;

}
