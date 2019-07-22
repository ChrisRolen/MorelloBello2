/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MorelloBello2.src.gui_package;

import MorelloBello2.src.data_package.Libri;
import java.sql.SQLException;
import javax.swing.JFrame;

/**
 *
 * @author matteo
 */
public class prova extends JFrame{
    public prova() throws SQLException{
        Libri libro=new Libri("1849388482938444");
        modify_book modifica=new modify_book(libro);
        add(modifica);
    }
    public static void main(String[] args) throws SQLException {
        prova prova2=new prova();
        prova2.setVisible(true);
    }
}
