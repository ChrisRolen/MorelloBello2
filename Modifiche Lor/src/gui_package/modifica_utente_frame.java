/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_package;

import data_package.Utenti;
import java.sql.SQLException;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author matteo
 */
public class modifica_utente_frame extends JFrame{
    public modifica_utente_frame(Utenti utente) throws SQLException{
        modifica_utente modifica=new modifica_utente(utente,this);
        add(modifica);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(900,900);
}
}