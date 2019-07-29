/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_package;

import data_package.Utenti;
import data_package.Ordine;
import data_package.database;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

/**
 *
 * @author Lorenzo
 */
public class Lista_ordini extends javax.swing.JPanel {
    
    /**
     * Creates new form Lista_ordini
     */
    public Lista_ordini(Utenti utente) throws SQLException {
        initComponents();
        Nome_Utente.setText(utente.getName());
        
       DefaultListModel model = new DefaultListModel();
         model.ensureCapacity(utente.listoforders(utente.getEmail()).size());
         ArrayList<Ordine> lista = utente.listoforders(utente.getEmail());
         for (int i = 0; i < utente.listoforders(utente.getEmail()).size(); i++) {
                model.addElement("Ordine n." + i + " - Codice: " + lista.get(i).getCodice());
          }
         //model.addElement(utente.listoforders(utente.getEmail()).size());
          
       NumberofOrders.setModel(model);
       
         DefaultListModel model_status = new DefaultListModel();
         model_status.ensureCapacity(utente.listoforders(utente.getEmail()).size());
         int j = 0;
          for(Ordine a:utente.listoforders(utente.getEmail())){
                    
                    if(a.isStatus()){
                        model_status.addElement("Status ordine: Consegnato");
                    }else{
                        model_status.addElement("Status ordine: In consegna");
                    }
                    
                    j++;
                }
          
        Status_Ordine.setModel(model_status);
        
        
        String array[] = new String[utente.listoforders(utente.getEmail()).size()] ;
        for (int i = 0; i < utente.listoforders(utente.getEmail()).size(); i++) {
                array[i] = Integer.toString(lista.get(i).getCodice());
          }
        DefaultComboBoxModel model_combo = new DefaultComboBoxModel( array);
        Lista_Ordini_Selezione.setModel( model_combo );
        
         
        Bottone_Codice.setText("Visualizza un ordine");
        Bottone_Codice.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        Visualizza_Ordine ord = new Visualizza_Ordine((String)Lista_Ordini_Selezione.getSelectedItem());
                    } catch (SQLException ex) {
                        Logger.getLogger(Lista_ordini.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                }
        );
        Modifica_Status.setVisible(false);
        if(utente.isAdmin()){
            Modifica_Status.setVisible(true);
            Modifica_Status.setText("Modifica lo status dell'ordine");
        }
        
        Descrizione.setEditable(false);
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        NumberofOrders = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        Status_Ordine = new javax.swing.JList<>();
        Bottone_Codice = new javax.swing.JButton();
        Modifica_Status = new javax.swing.JButton();
        Nome_Utente = new javax.swing.JLabel();
        Lista_Ordini_Selezione = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        Descrizione = new javax.swing.JTextArea();

        jLabel1.setText("Lista degli Ordini dell'utente");

        NumberofOrders.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(NumberofOrders);

        Status_Ordine.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(Status_Ordine);

        Bottone_Codice.setText("visualizza_ordine");
        Bottone_Codice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Bottone_CodiceMouseClicked(evt);
            }
        });

        Modifica_Status.setText("cambia status");
        Modifica_Status.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Modifica_StatusMouseClicked(evt);
            }
        });

        Nome_Utente.setText("jLabel2");

        Lista_Ordini_Selezione.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Descrizione.setColumns(20);
        Descrizione.setRows(5);
        Descrizione.setText("Vuoi verificare la \nstruttura di uno dei\ntuoi ordini?\nSelezionalo qui di \nfianco!");
        jScrollPane5.setViewportView(Descrizione);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Nome_Utente))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Lista_Ordini_Selezione, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bottone_Codice)
                    .addComponent(Modifica_Status))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Nome_Utente)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Lista_Ordini_Selezione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(Bottone_Codice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Modifica_Status)))
                .addContainerGap(136, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Bottone_CodiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bottone_CodiceMouseClicked
        try {
            // TODO add your handling code here:
            Visualizza_Ordine ordine=new Visualizza_Ordine((String)Lista_Ordini_Selezione.getSelectedItem());
        } catch (SQLException ex) {
            Logger.getLogger(Lista_ordini.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Bottone_CodiceMouseClicked

    private void Modifica_StatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Modifica_StatusMouseClicked
        // TODO add your handling code here:
        String query="update ordine set stato=true where codice="+Lista_Ordini_Selezione.getSelectedItem();
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn=database.connection();
        } catch (SQLException ex) {
            Logger.getLogger(Lista_ordini.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pstmt=conn.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(Lista_ordini.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pstmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Lista_ordini.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Modifica_StatusMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bottone_Codice;
    private javax.swing.JTextArea Descrizione;
    private javax.swing.JComboBox<String> Lista_Ordini_Selezione;
    private javax.swing.JButton Modifica_Status;
    private javax.swing.JLabel Nome_Utente;
    private javax.swing.JList<String> NumberofOrders;
    private javax.swing.JList<String> Status_Ordine;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
}