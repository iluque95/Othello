/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epsevg.eu.Othello.GUI;

import epsevg.eu.Othello.Base.Options;
import static epsevg.eu.Othello.Constants.Constants.LOGO;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author marti
 */
public class Pick extends javax.swing.JDialog {
    
    private int prof1,prof2;
    private String user1,user2;
    private boolean poda1,poda2;
       
    Thread pare;
    
    
    public static BufferedImage resize(BufferedImage img, int newW, int newH) { 
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return dimg;
    }  
    
    

    /**
     * Creates new form Pick
     */
    public Pick(GUI parent, boolean modal, Thread pare, Options exjugadors) throws IOException {
        super(parent, modal);
        initComponents();
        
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
                
            }
        });
        
        this.pare = pare;
        
        if (exjugadors != null){
            System.out.println("PLAYED BEFORE");
            
            user1 = exjugadors.getFirstPlayer();
            user2 = exjugadors.getSecondPlayer();
            
            prof1 = exjugadors.getP1Prof();
            prof2 = exjugadors.getP2Prof();
            
            poda1 = exjugadors.getP1Poda();
            poda2 = exjugadors.getP2Poda();
            
            if (user1 != "Manual" && user1 != "Random")
            {
                PCombo.setSelectedItem(String.valueOf(prof1));
                jCheckBox1.setSelected(poda1);                
            }
                
            if (user2 != "Manual" && user2 != "Random")
            {
                PCombo2.setSelectedItem(String.valueOf(prof2));
                jCheckBox2.setSelected(poda2);
                
            }
            
            
            Rulet.setSelectedItem(user1);
            Rulet2.setSelectedItem(user2);
                
            
           // System.out.println("ExPlayer 1 : " + user1+" PROF = " + prof1+" PODA = " + poda1);
           // System.out.println("ExPlayer 2 : " + user2+" PROF = " + prof2+" PODA = " + poda2);
            
            
        }
        
        
        else{
            System.out.println("First Game");
            prof1=prof2=0;
            poda1=poda2=false;
            user1=Rulet.getItemAt(Rulet.getSelectedIndex());
            user2=Rulet2.getItemAt(Rulet2.getSelectedIndex());
            
        }
        
        this.setTitle("Othello - Reversi");
        this.getRootPane().setDefaultButton(BGo);
        
 
        pare.interrupt();
        
        
    }
    
    
    
    public Pair<String[],String[]> getChoice()
    {
        String[] aux1 = new String[3];
        String[] aux2 = new String[3];
        
        aux1[0] = user1;
        aux1[1] = String.valueOf(prof1);
        aux1[2] = String.valueOf(poda1);
        
        aux2[0] = user2;
        aux2[1] = String.valueOf(prof2);
        aux2[2] = String.valueOf(poda2);
        
        return new Pair(aux1,aux2);
        
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Rulet2 = new javax.swing.JComboBox<>();
        Rulet = new javax.swing.JComboBox<>();
        BGo = new javax.swing.JButton();
        PCombo = new javax.swing.JComboBox<>();
        PCombo2 = new javax.swing.JComboBox<>();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 0, 0));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("PICK YOUR PLAYERS");

        jLabel2.setText("P1 : ");

        jLabel3.setText("P2 : ");

        Rulet2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manual", "Random", "LloydC" }));
        Rulet2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rulet2ActionPerformed(evt);
            }
        });

        Rulet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manual", "Random", "LloydC" }));
        Rulet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RuletActionPerformed(evt);
            }
        });

        BGo.setText("GO");
        BGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BGoActionPerformed(evt);
            }
        });

        PCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
        PCombo.setEnabled(false);
        PCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PComboActionPerformed(evt);
            }
        });

        PCombo2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
        PCombo2.setEnabled(false);
        PCombo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCombo2ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("PODA");
        jCheckBox1.setEnabled(false);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("PODA");
        jCheckBox2.setEnabled(false);
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Rulet2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Rulet, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox1))
                        .addContainerGap(95, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BGo)
                        .addGap(40, 40, 40))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Rulet, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Rulet2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(BGo)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BGoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGoActionPerformed
        // TODO add your handling code here:
        pare.interrupt();
        try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {
            Logger.getLogger(Pick.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_BGoActionPerformed

    private void RuletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RuletActionPerformed
        // TODO add your handling code here:
        if (Rulet.getItemAt(Rulet.getSelectedIndex()) == "LloydC"){
            PCombo.setEnabled(true);
            jCheckBox1.setEnabled(true);
        }
        else{
            prof1 = 0;
            poda1 = false;
            PCombo.setSelectedItem(String.valueOf(prof1));
            jCheckBox1.setSelected(poda1);
            PCombo.setEnabled(false);
            jCheckBox1.setEnabled(false);
        }
        user1 = Rulet.getItemAt(Rulet.getSelectedIndex());
    }//GEN-LAST:event_RuletActionPerformed

    private void PCombo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCombo2ActionPerformed
        // TODO add your handling code here:
        prof2=Integer.parseInt(PCombo2.getItemAt(PCombo2.getSelectedIndex()));
       
    }//GEN-LAST:event_PCombo2ActionPerformed

    private void Rulet2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rulet2ActionPerformed
        // TODO add your handling code here:
         if (Rulet2.getItemAt(Rulet2.getSelectedIndex()) == "LloydC"){
            PCombo2.setEnabled(true);
            jCheckBox2.setEnabled(true);
        }
         else{
             prof2 = 0;
             poda2 = false;
             PCombo2.setSelectedItem(String.valueOf(prof2));
             jCheckBox2.setSelected(poda2);
             
             PCombo2.setEnabled(false);
             jCheckBox2.setEnabled(false);
         }
        user2 = Rulet2.getItemAt(Rulet2.getSelectedIndex());
    }//GEN-LAST:event_Rulet2ActionPerformed

    private void PComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PComboActionPerformed
        // TODO add your handling code here:
        prof1= Integer.parseInt(PCombo.getItemAt(PCombo.getSelectedIndex()));
    }//GEN-LAST:event_PComboActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()) poda1=true;
        else poda1 = false;
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
         if (jCheckBox2.isSelected()) poda2=true;
        else poda2 = false;
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BGo;
    private javax.swing.JComboBox<String> PCombo;
    private javax.swing.JComboBox<String> PCombo2;
    private javax.swing.JComboBox<String> Rulet;
    private javax.swing.JComboBox<String> Rulet2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}