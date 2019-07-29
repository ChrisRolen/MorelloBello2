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
public class visualizza_libro_frame extends JFrame{
    public visualizza_libro_frame(Utenti utente,Libri libro) throws SQLException{
        
        
        Visualizza_libro modifica=new Visualizza_libro(utente,libro,this);
        add(modifica);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(900,900);
    }
}
