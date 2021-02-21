/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team_penguin.cs2450_project1;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author amirc
 */
public class ColorGame extends javax.swing.JFrame {
    // For random word
    private static String [] colors = new String[] {"Red", "Yellow", "Green", "Blue", "Purple"}; 
    // For random color
    private static Color [] colors2 = new Color[] {Color.RED,Color.YELLOW,Color.GREEN,Color.BLUE,new Color(255,0,255)};
    
     
    
  

    
   

    /**
     * Creates new form ColorGame
     */
    public ColorGame() {
        initComponents();
        setSize(600,400);
        setLocation(300,200);
        setResizable(false);
        //display word
      Random rand = new Random();
      int word = rand.nextInt(colors.length);
       Title.setText(colors[word]);
       // display color  
      int rand_color = rand.nextInt(colors.length);
        Title.setForeground(colors2[rand_color]);
    
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JLabel();
        Yellow = new javax.swing.JButton();
        Blue = new javax.swing.JButton();
        Red = new javax.swing.JButton();
        Purple = new javax.swing.JButton();
        Green = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        Title.setFont(new java.awt.Font("Stencil", 1, 18)); // NOI18N
        Title.setText("Color_Title");
        getContentPane().add(Title);
        Title.setBounds(190, 70, 160, 50);

        Yellow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team_penguin/cs2450_project1/hangman_pic/yellow.png"))); // NOI18N
        Yellow.setBorderPainted(false);
        Yellow.setContentAreaFilled(false);
        Yellow.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/team_penguin/cs2450_project1/hangman_pic/yellow_hover.png"))); // NOI18N
        Yellow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YellowActionPerformed(evt);
            }
        });
        getContentPane().add(Yellow);
        Yellow.setBounds(210, 200, 140, 120);

        Blue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team_penguin/cs2450_project1/hangman_pic/blue.png"))); // NOI18N
        Blue.setBorderPainted(false);
        Blue.setContentAreaFilled(false);
        Blue.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/team_penguin/cs2450_project1/hangman_pic/blue_hover.png"))); // NOI18N
        Blue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BlueActionPerformed(evt);
            }
        });
        getContentPane().add(Blue);
        Blue.setBounds(380, 30, 141, 117);

        Red.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team_penguin/cs2450_project1/hangman_pic/red.png"))); // NOI18N
        Red.setBorderPainted(false);
        Red.setContentAreaFilled(false);
        Red.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/team_penguin/cs2450_project1/hangman_pic/red_hover.png"))); // NOI18N
        getContentPane().add(Red);
        Red.setBounds(20, 200, 160, 120);

        Purple.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team_penguin/cs2450_project1/hangman_pic/purple.png"))); // NOI18N
        Purple.setBorderPainted(false);
        Purple.setContentAreaFilled(false);
        Purple.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/team_penguin/cs2450_project1/hangman_pic/purple_hover.png"))); // NOI18N
        getContentPane().add(Purple);
        Purple.setBounds(400, 230, 141, 117);

        Green.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team_penguin/cs2450_project1/hangman_pic/green.png"))); // NOI18N
        Green.setBorderPainted(false);
        Green.setContentAreaFilled(false);
        Green.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/team_penguin/cs2450_project1/hangman_pic/green_hover.png"))); // NOI18N
        Green.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GreenActionPerformed(evt);
            }
        });
        getContentPane().add(Green);
        Green.setBounds(40, 30, 140, 120);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team_penguin/cs2450_project1/hangman_pic/plain-white-background.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 600, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void YellowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YellowActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_YellowActionPerformed

    private void BlueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BlueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BlueActionPerformed

    private void GreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GreenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GreenActionPerformed

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
            java.util.logging.Logger.getLogger(ColorGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ColorGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ColorGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ColorGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
         
        
        /* Create and display the form */
      
      
      
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ColorGame().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Blue;
    private javax.swing.JButton Green;
    private javax.swing.JButton Purple;
    private javax.swing.JButton Red;
    private javax.swing.JLabel Title;
    private javax.swing.JButton Yellow;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}