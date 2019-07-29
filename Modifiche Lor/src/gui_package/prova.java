/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_package;

import data_package.Libri;
import static data_package.Libri.carrello;
import data_package.Utenti;
import java.sql.SQLException;
import javax.swing.JFrame;

/**
 *
 * @author matteo
 */
public class prova extends JFrame{
    public prova() throws SQLException{
        Libri libro=new Libri("1849388482938444");
        Libri.carrello.add(libro);
        Carrello modifica=new Carrello();
        add(modifica);
    }
    public static void main(String[] args) throws SQLException {
        Utenti utente=new Utenti("matteo.gennari98@gmail.com","warmatteo98");
        visualizza_utente_frame prova2=new visualizza_utente_frame(utente);
        prova2.setVisible(true);
       
    }
}