/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author matteo
 */
public class Autori {
    public static void new_author(String nome,Connection conn) throws SQLException{
        String query="insert into autori (nome) values (?)";
        PreparedStatement pstmt=conn.prepareStatement(query);
        pstmt.setString(1, nome);
        pstmt.execute();
    }
}
