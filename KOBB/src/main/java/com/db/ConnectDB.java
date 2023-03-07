package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDB {
    private static ConnectDB instance = new ConnectDB();

    public static ConnectDB getInstance() {
        return instance;
    }
    public ConnectDB() {  }

    // oracle 계정
    String jdbcUrl = "jdbc:oracle:thin:@project-db-stu3.ddns.net:1525:xe";
    String id = "tmdwn";
    String pw = "tmdwntmdwn";
    

    Connection conn = null;
    PreparedStatement pstmt;
    PreparedStatement pstmt2;
    ResultSet rs = null;

    String sql = "";
    String sql2 = "";
    String returns = "a";

    public String connectionDB(String user_id , String user_pw , String user_phone , String user_shop_name ) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(jdbcUrl,id,pw);

            sql = "SELECT * FROM user_tb WHERE user_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user_id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                returns = "이미 존재하는 아이디 입니다.";
            } else {
                sql2 = "INSERT INTO user_tb(user_id, user_pw, user_phone, user_shop_name, user_joindate) VALUES(?,?,?,?,sysdate)";
                pstmt2 = conn.prepareStatement(sql2);
                pstmt2.setString(1, user_id);	
                pstmt2.setString(2, user_pw);
                pstmt2.setString(3, user_phone);
                pstmt2.setString(4, user_shop_name);
                pstmt2.executeUpdate();
                returns = "회원 가입 성공 !";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pstmt2 != null)try {pstmt2.close();    } catch (SQLException ex) {}
            if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {}
            if (conn != null)try {conn.close();    } catch (SQLException ex) {    }
        }
        return returns;
    }
}
