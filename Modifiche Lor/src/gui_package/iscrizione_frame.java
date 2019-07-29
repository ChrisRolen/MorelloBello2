/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_package;

import java.sql.SQLException;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author matteo
 */
public class iscrizione_frame extends JFrame{
    public iscrizione_frame() throws SQLException{
        
        
        iscrizione modifica=new iscrizione(this);
        add(modifica);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(900,900);
    }
}
