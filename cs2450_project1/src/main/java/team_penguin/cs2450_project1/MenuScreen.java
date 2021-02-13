/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team_penguin.cs2450_project1;

/**
 *
 * @author amirc
 */
public class MenuScreen extends javax.swing.JFrame {

    /**
     * Creates new form Picture
     */
    public MenuScreen() {
        initComponents();
        setSize(600,400);
        setLocation(300,200);
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PenguinPicture = new javax.swing.JLabel();
        PlayButton = new javax.swing.JButton();
        HighScore = new javax.swing.JButton();
        CreditsButton = new javax.swing.JButton();
        BackgroundPicture = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(null);

        PenguinPicture.setBackground(new java.awt.Color(204, 255, 255));
        PenguinPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team_penguin/cs2450_project1/penguin.jpg"))); // NOI18N
        getContentPane().add(PenguinPicture);
        PenguinPicture.setBounds(50, 140, 180, 170);

        PlayButton.setFont(new java.awt.Font("Stencil", 1, 26)); // NOI18N
        PlayButton.setText("Play");
        PlayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayButtonActionPerformed(evt);
            }
        });
        getContentPane().add(PlayButton);
        PlayButton.setBounds(370, 200, 210, 40);

        HighScore.setFont(new java.awt.Font("Stencil", 1, 25)); // NOI18N
        HighScore.setText("High Scores");
        HighScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HighScoreActionPerformed(evt);
            }
        });
        getContentPane().add(HighScore);
        HighScore.setBounds(370, 250, 210, 40);

        CreditsButton.setFont(new java.awt.Font("Stencil", 1, 26)); // NOI18N
        CreditsButton.setText("Credits");
        CreditsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreditsButtonActionPerformed(evt);
            }
        });
        getContentPane().add(CreditsButton);
        CreditsButton.setBounds(370, 300, 210, 40);

        BackgroundPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team_penguin/cs2450_project1/cartoon-arctic-ice-landscape-outdoor-scene-vector-26665194.jpg"))); // NOI18N
        getContentPane().add(BackgroundPicture);
        BackgroundPicture.setBounds(0, 0, 600, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PlayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayButtonActionPerformed
        // TODO add your handling code here:
         Hangman h = new Hangman();
         h.setVisible(true);
         dispose();
    }//GEN-LAST:event_PlayButtonActionPerformed

    private void HighScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HighScoreActionPerformed
        // TODO add your handling code here:
        ScoreScreen ss = new ScoreScreen();
        ss.setVisible(true);
        dispose();
    }//GEN-LAST:event_HighScoreActionPerformed

    private void CreditsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreditsButtonActionPerformed
        // TODO add your handling code here:
        CreditScreen cs = new CreditScreen();
        cs.setVisible(true);
        dispose();
    }//GEN-LAST:event_CreditsButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MenuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        MenuScreen menuScreen = new MenuScreen();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroundPicture;
    private javax.swing.JButton CreditsButton;
    private javax.swing.JButton HighScore;
    private javax.swing.JLabel PenguinPicture;
    private javax.swing.JButton PlayButton;
    // End of variables declaration//GEN-END:variables
}
