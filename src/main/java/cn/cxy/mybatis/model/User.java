package cn.cxy.mybatis.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * Function: User实体：作为 mapper.xml 映射结果其字段必须与数据库中字段一一对应
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/9/27 21:20 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */

@Setter
@Getter
@ToString
public class User {

    public static final int SEX_BOY = 1;
    public static final int SEX_GIRL = 0;

    private Integer id;
    private String username;
    private Date birthday;
    private Integer sex;
    private String address;

}
