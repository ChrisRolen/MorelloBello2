/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_package;

import data_package.Libri;
import data_package.Utenti;
import java.sql.SQLException;
import javax.swing.JFrame;

/**
 *
 * @author matteo
 */
public class visualizza_utente_frame extends JFrame{
        public visualizza_utente_frame(Utenti utente) {
        visualizza_utente modifica=new visualizza_utente(utente,this);
        add(modifica);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(900,900);
    }
}
