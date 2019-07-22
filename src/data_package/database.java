/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MorelloBello2.src.data_package;
import java.sql.*;
/**
 *
 * @author matteo
 */
public  class database {
    public static Connection conn;
    //Statement stmt;
    //ResultSet rs;
    //PreparedStatement pstmt;
    public static Connection  connection() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost/database_progetto?" + "user=root&password=cibermatteo98");
        return conn;
    }
}
