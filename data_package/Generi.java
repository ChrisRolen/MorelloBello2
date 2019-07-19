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
public class generi {
    public static void new_genre(String nome) throws SQLException{
        Connection conn=database.connection();
        PreparedStatement pstmt;
        String query="insert into generi(nome) values(?)";
        pstmt=conn.prepareStatement(query);
        pstmt.setString(1, nome);
        pstmt.execute();
    }
}
