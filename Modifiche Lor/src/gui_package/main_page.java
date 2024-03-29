/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_package;

import data_package.Libri;
import gui_package.Lista_ordini_frame;
import data_package.Utenti;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import data_package.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultListModel;

/**
 *
 * @author matteo
 */
public class main_page extends javax.swing.JFrame{    /**
     * Creates new form main_page
     */
    public main_page() throws SQLException {
        initComponents();
        Connection conn = database.connection();
        PreparedStatement pstmt;
	Statement stmt=conn.createStatement();
        ResultSet rs;
        ArrayList<Libri> classi = new ArrayList<Libri>();
        ArrayList<String> generi = new ArrayList<String>();
        ArrayList<Libri> prova = new ArrayList<Libri>();
        rs = stmt.executeQuery("SELECT * from generi, genere_libro WHERE generi.id = genere_libro.genere");
        
        while(rs.next()){
            generi.add(rs.getString("nomi"));
        }
        
        DefaultListModel model = new DefaultListModel();
        
        for(String a:generi){
            rs = stmt.executeQuery("SELECT ISBN from generi,genere_libro WHERE nome='" + a + "' AND (generi.id = genere_libro.genere)");
            
            while(rs.next()){
               prova.add(new Libri(rs.getString("ISBN")));
            }
            
            classi = Libri.classify(a, prova);
            
            prova.removeAll(prova);
        }
        
        int i = 1;
        for(Libri a:classi){
            model.addElement("Libro: "+ a.getTitle() + " di " + a.getAuthor().toString() + ""
                    + " posizione: " + i);
            i++;
            if(i>5){
                i=1;
            }
        }
        
        Classifica.setModel(model);
        
        
         

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cerca = new javax.swing.JButton();
        barra_cerca = new javax.swing.JTextField();
        login = new javax.swing.JButton();
        iscrizione = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Classifica = new javax.swing.JList<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        PaginaPrincipale = new javax.swing.JMenu();
        PaginaProfilo = new javax.swing.JMenu();
        PaginaOrdini = new javax.swing.JMenu();
        Carrello = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cerca.setText("cerca");

        login.setText("login");
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginMouseClicked(evt);
            }
        });

        iscrizione.setText("iscriviti");

        Classifica.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(Classifica);

        PaginaPrincipale.setText("Pagina Principale");
        PaginaPrincipale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaginaPrincipaleActionPerformed(evt);
            }
        });
        jMenuBar1.add(PaginaPrincipale);

        PaginaProfilo.setText("Utente");
        PaginaProfilo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaginaProfiloActionPerformed(evt);
            }
        });
        jMenuBar1.add(PaginaProfilo);

        PaginaOrdini.setText("Ordini");
        PaginaOrdini.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaginaOrdiniActionPerformed(evt);
            }
        });
        jMenuBar1.add(PaginaOrdini);

        Carrello.setText("Carrello");
        jMenuBar1.add(Carrello);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(barra_cerca, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(cerca)
                        .addGap(51, 51, 51))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 192, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)))
                .addComponent(login)
                .addGap(33, 33, 33)
                .addComponent(iscrizione)
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login)
                    .addComponent(barra_cerca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cerca)
                    .addComponent(iscrizione))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        login_frame login=new login_frame();
    }//GEN-LAST:event_loginMouseClicked

    private void PaginaPrincipaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaginaPrincipaleActionPerformed
        // TODO add your handling code here:
        main_page pagina = null;
        try {
            pagina = new main_page();
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
        pagina.setVisible(true);
        pagina.setSize(900, 900);
    }//GEN-LAST:event_PaginaPrincipaleActionPerformed

    private void PaginaProfiloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaginaProfiloActionPerformed
        // TODO add your handling code here:
        visualizza_utente_frame pagina = new visualizza_utente_frame(Utenti.utente);
        this.setVisible(false);
        pagina.setVisible(true);
        pagina.setSize(900, 900);
    }//GEN-LAST:event_PaginaProfiloActionPerformed

    private void PaginaOrdiniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaginaOrdiniActionPerformed
        // TODO add your handling code here:
        
        Lista_ordini_frame pagina = null;
        try {
            pagina = new Lista_ordini_frame(Utenti.utente);
        } catch (SQLException ex) {
            Logger.getLogger(main_page.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
        pagina.setVisible(true);
        pagina.setSize(900, 900);
    }//GEN-LAST:event_PaginaOrdiniActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new main_page().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(main_page.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Carrello;
    private javax.swing.JList<String> Classifica;
    private javax.swing.JMenu PaginaOrdini;
    private javax.swing.JMenu PaginaPrincipale;
    private javax.swing.JMenu PaginaProfilo;
    private javax.swing.JTextField barra_cerca;
    private javax.swing.JButton cerca;
    private javax.swing.JButton iscrizione;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton login;
    // End of variables declaration//GEN-END:variables
    private ArrayList<String> generi=new ArrayList<String>();
}
