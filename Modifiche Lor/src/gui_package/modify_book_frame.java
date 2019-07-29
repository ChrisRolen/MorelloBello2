/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_package;

import data_package.Libri;
import java.sql.SQLException;
import javax.swing.JFrame;

/**
 *
 * @author matteo
 */
public class modify_book_frame extends JFrame{
    public modify_book_frame(Libri libro) throws SQLException{
        
        modify_book modifica=new modify_book(libro,this);
        add(modifica);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(900,900);
    }
}
