/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_package;

import data_package.Libri;
import data_package.Utenti;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author matteo
 */
public class Visualizza_libro extends javax.swing.JPanel {

    /**
     * Creates new form Visualizza_libro
     */
    Libri libro;
    JFrame frame;
    public Visualizza_libro(Utenti utente,Libri libro,JFrame frame) {
        this.frame=frame;
        this.libro=libro;
        initComponents();
        modifica.setVisible(false);
        
        String autori="";
        String generi="";
        if(utente.isAdmin()){
            modifica.setVisible(true);
        }
        titolo.setText(libro.getTitle());
        
        casa_produttrice.setText(libro.getEditor());
        descrizione.setText(libro.getDescription());
        prezzo.setText(Float.toString(libro.getPrice()));
        punti.setText(Integer.toString(libro.getNumberofpoints()));
        
        for(int i=0;i<libro.getAuthor().size();i++){
            autori=autori+libro.getAuthor().get(i)+",";
        }
        autore.setText(autori);
        
        for(int i=0;i<libro.getGenre().size();i++){
            generi=generi+libro.getGenre().get(i)+",";
        }
        genere.setText(generi);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titolo = new javax.swing.JLabel();
        autore = new javax.swing.JLabel();
        casa_produttrice = new javax.swing.JLabel();
        genere = new javax.swing.JLabel();
        prezzo = new javax.swing.JLabel();
        punti = new javax.swing.JLabel();
        descrizione = new javax.swing.JLabel();
        foto = new javax.swing.JLabel();
        ordina = new javax.swing.JButton();
        modifica = new javax.swing.JButton();
        quantita = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        titolo.setText("jLabel1");

        autore.setText("jLabel2");

        casa_produttrice.setText("jLabel3");

        genere.setText("jLabel4");

        prezzo.setText("jLabel5");

        punti.setText("jLabel6");

        descrizione.setText("jLabel7");

        foto.setText("jLabel8");

        ordina.setText("ordina");
        ordina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ordinaMouseClicked(evt);
            }
        });

        modifica.setText("modifica");
        modifica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modificaMouseClicked(evt);
            }
        });

        quantita.setText("1");

        jLabel1.setText("quanti libri ordinare");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(descrizione)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(foto)
                .addGap(177, 177, 177)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(prezzo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(punti))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(casa_produttrice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(genere))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titolo)
                        .addGap(92, 92, 92)
                        .addComponent(autore)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(modifica)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(quantita, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ordina, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(123, 123, 123))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(quantita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titolo)
                    .addComponent(autore)
                    .addComponent(foto)
                    .addComponent(ordina))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(casa_produttrice)
                    .addComponent(genere)
                    .addComponent(modifica))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prezzo)
                    .addComponent(punti))
                .addGap(105, 105, 105)
                .addComponent(descrizione)
                .addContainerGap(169, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ordinaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ordinaMouseClicked
        // TODO add your handling code here:
        Libri.carrello.add(libro);
        Libri.numerodicopie.add(Integer.parseInt(quantita.getText()));
        Carrello carrello=new Carrello();
    }//GEN-LAST:event_ordinaMouseClicked

    private void modificaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificaMouseClicked
        // TODO add your handling code here:
        frame.setVisible(false);
        try {
            modify_book_frame modifica_libro=new modify_book_frame(libro);
        } catch (SQLException ex) {
            Logger.getLogger(Visualizza_libro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_modificaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel autore;
    private javax.swing.JLabel casa_produttrice;
    private javax.swing.JLabel descrizione;
    private javax.swing.JLabel foto;
    private javax.swing.JLabel genere;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton modifica;
    private javax.swing.JButton ordina;
    private javax.swing.JLabel prezzo;
    private javax.swing.JLabel punti;
    private javax.swing.JTextField quantita;
    private javax.swing.JLabel titolo;
    // End of variables declaration//GEN-END:variables
}