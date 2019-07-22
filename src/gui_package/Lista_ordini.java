/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_package;

import data_package.Utenti;
import data_package.Ordine;
import java.awt.Rectangle;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
         for (int i = 0; i < utente.listoforders(utente.getEmail()).size(); i++) {
                model.addElement("Ordine n." + i);
          }
         //model.addElement(utente.listoforders(utente.getEmail()).size());
          
       NumberofOrders.setModel(model);
       
         DefaultListModel model_status = new DefaultListModel();
         model.ensureCapacity(utente.listoforders(utente.getEmail()).size());
         String status[] = null;
         int j = 0;
          for(Ordine a:utente.listoforders(utente.getEmail())){
                    
                    if(a.isStatus()){
                        status[j] = "Consegnato";
                    }else{
                        status[j] = "In consegna";
                    }
                    
                    status[j] = "Status ordine: " + status[j];
                    model.addElement(status[j]);
                    j++;
                }
          
         Status_Ordine.setModel(model_status);
         
         
         JButton buttons_codice[] = new JButton[utente.listoforders(utente.getEmail()).size()];
         
         String names[] = new String[utente.listoforders(utente.getEmail()).size()];
         
         int i = 0;
         for(Ordine a: utente.listoforders(utente.getEmail())){
             names[i] = Integer.toString(a.getCodice());
             i++;
         }
         
         /*   Bottone_Codice.setText(names[0]);
            Rectangle bottonedin = Bottone_Codice.getBounds();
            bottonedin.y += 0.5;
            for (i = 1; i < buttons_codice.length; ++i)
            {
                JButton btn = new JButton(names[i]);
                btn.addActionListener(null);
                add(btn);
                buttons_codice[i] = btn;
                btn.setBounds(bottonedin);
                bottonedin.y += 0.5;
            }
            */
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
        jScrollBar1 = new javax.swing.JScrollBar();
        jScrollPane2 = new javax.swing.JScrollPane();
        Status_Ordine = new javax.swing.JList<>();
        Bottone_Codice = new javax.swing.JButton();
        Modifica_Status = new javax.swing.JButton();
        Nome_Utente = new javax.swing.JLabel();

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

        Bottone_Codice.setText("jButton1");

        Modifica_Status.setText("jButton1");

        Nome_Utente.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Bottone_Codice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Modifica_Status)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Nome_Utente)))
                .addContainerGap(267, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Nome_Utente))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1)
                        .addComponent(jScrollPane2))
                    .addComponent(Bottone_Codice)
                    .addComponent(Modifica_Status))
                .addContainerGap(268, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bottone_Codice;
    private javax.swing.JButton Modifica_Status;
    private javax.swing.JLabel Nome_Utente;
    private javax.swing.JList<String> NumberofOrders;
    private javax.swing.JList<String> Status_Ordine;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
