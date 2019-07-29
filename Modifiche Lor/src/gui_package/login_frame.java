/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_package;

import java.sql.SQLException;
import javax.swing.JFrame;

/**
 *
 * @author matteo
 */
public class login_frame extends JFrame{
    public login_frame(){
        login modifica=new login(this);
        add(modifica);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(900,900);
    }
}
