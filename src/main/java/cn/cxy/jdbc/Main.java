package cn.cxy.jdbc;

import java.sql.*;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/9/26 22:54 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class Main {

    public static final String driverClass = "com.mysql.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/mybatis?charset=utf8";
    public static final String username = "mybatis";
    public static final String password = "mybatis";
    static Connection conn = null;
    static PreparedStatement psts = null;
    static ResultSet rs = null;

    public static void main(String[] args) {
        try {
            Class.forName(driverClass);
            conn = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM user WHERE username = ?";
            psts = conn.prepareStatement(sql);
            psts.setString(1, "刘二狗");
            rs = psts.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("id") + " : " + rs.getString("username"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != rs) {
                    rs.close();
                }
                if (null != psts) {
                    psts.close();
                }
                if (null != conn) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
