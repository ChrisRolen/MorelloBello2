/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_package;

import data_package.Utenti;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lorenzo
 */
public class Profilo_Utente extends javax.swing.JFrame {
    public Utenti user;
    /**
     * Creates new form Profilo_Utente
     */
    public Profilo_Utente() {
        initComponents();
        Libro.setVisible(false);
        Classifica.setVisible(false);
        user = Utenti.utente;
        Saluto.setText("Benvenuto, "+ user.getName() + "!");
        Card_Saldo.setText("Il saldo punti della tua carta " + user.getLibroCard() + " e' di " + user.getNumberofpoints() + " punti.");
        
        if(user.isAdmin()){
            Libro.setVisible(true);
            Classifica.setVisible(true);
        }
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Saluto = new javax.swing.JLabel();
        Card_Saldo = new javax.swing.JLabel();
        Credenziali = new javax.swing.JButton();
        Lista = new javax.swing.JButton();
        VCarrello = new javax.swing.JToggleButton();
        Libro = new javax.swing.JButton();
        Classifica = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        PaginaPrincipale = new javax.swing.JMenu();
        PaginaProfilo = new javax.swing.JMenu();
        PaginaOrdini = new javax.swing.JMenu();
        Carrello = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Saluto.setText("jLabel1");

        Card_Saldo.setText("jLabel2");

        Credenziali.setText("Modifica Credenziali Utente");
        Credenziali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CredenzialiActionPerformed(evt);
            }
        });

        Lista.setText("Visualizza Lista Ordini");
        Lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaActionPerformed(evt);
            }
        });

        VCarrello.setText("Visualizza Carrello");
        VCarrello.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VCarrelloActionPerformed(evt);
            }
        });

        Libro.setText("Aggiungi Libro");
        Libro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LibroActionPerformed(evt);
            }
        });

        Classifica.setText("Modifica Classifica");

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Saluto)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Credenziali)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(Card_Saldo)
                        .addGap(133, 133, 133))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Lista)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(VCarrello)
                        .addGap(62, 62, 62))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Libro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Classifica)
                        .addGap(60, 60, 60))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(Saluto)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Card_Saldo)
                    .addComponent(Credenziali))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lista)
                    .addComponent(VCarrello))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Libro)
                    .addComponent(Classifica))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            Logger.getLogger(Carrello.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
        pagina.setVisible(true);
        pagina.setSize(900, 900);
    }//GEN-LAST:event_PaginaOrdiniActionPerformed

    private void ListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaActionPerformed
        // TODO add your handling code here:
        Lista_ordini_frame pagina = null;
        try {
            pagina = new Lista_ordini_frame(user);
        } catch (SQLException ex) {
            Logger.getLogger(Profilo_Utente.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
        pagina.setVisible(true);
        pagina.setSize(900, 900);
    }//GEN-LAST:event_ListaActionPerformed

    private void CredenzialiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CredenzialiActionPerformed
        // TODO add your handling code here:
        modifica_utente_frame pagina = null;
        try {
            pagina = new modifica_utente_frame(user);
        } catch (SQLException ex) {
            Logger.getLogger(Profilo_Utente.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
        pagina.setVisible(true);
        pagina.setSize(900, 900);
    }//GEN-LAST:event_CredenzialiActionPerformed

    private void VCarrelloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VCarrelloActionPerformed
        // TODO add your handling code here:
        Carrello pagina = null;
        pagina = new Carrello();
        this.setVisible(false);
        pagina.setVisible(true);
        pagina.setSize(900, 900);
    }//GEN-LAST:event_VCarrelloActionPerformed

    private void LibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LibroActionPerformed
        // TODO add your handling code here:
        insert_book_frame pagina = null;
        try {
            pagina = new insert_book_frame(user);
        } catch (SQLException ex) {
            Logger.getLogger(Profilo_Utente.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
        pagina.setVisible(true);
        pagina.setSize(900,900);
    }//GEN-LAST:event_LibroActionPerformed

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
            java.util.logging.Logger.getLogger(Profilo_Utente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profilo_Utente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profilo_Utente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profilo_Utente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profilo_Utente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Card_Saldo;
    private javax.swing.JMenu Carrello;
    private javax.swing.JButton Classifica;
    private javax.swing.JButton Credenziali;
    private javax.swing.JButton Libro;
    private javax.swing.JButton Lista;
    private javax.swing.JMenu PaginaOrdini;
    private javax.swing.JMenu PaginaPrincipale;
    private javax.swing.JMenu PaginaProfilo;
    private javax.swing.JLabel Saluto;
    private javax.swing.JToggleButton VCarrello;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
