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
public class PlayerScore extends javax.swing.JFrame {

    /**
     * Creates new form PlayerScore
     */
    private int score_player; 
    public PlayerScore(int score) {
        initComponents();
        setSize(600,400);
        setLocation(300,200);
        setResizable(false);
        
        score_player = score;
        setScoreText();
    }
    
    public PlayerScore() {
        initComponents();
        setSize(600,400);
        setLocation(300,200);
        setResizable(false);
        
        score_player = 0;
        setScoreText();
    }
    
    private void setScoreText()
    {
        Score.setText(Integer.toString(score_player));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        End = new javax.swing.JButton();
        userscoreTitle = new javax.swing.JLabel();
        Score = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Player Score");
        getContentPane().setLayout(null);

        End.setFont(new java.awt.Font("Stencil", 1, 28)); // NOI18N
        End.setText("End");
        End.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EndActionPerformed(evt);
            }
        });
        getContentPane().add(End);
        End.setBounds(51, 316, 103, 37);

        userscoreTitle.setFont(new java.awt.Font("Stencil", 1, 30)); // NOI18N
        userscoreTitle.setForeground(new java.awt.Color(255, 255, 255));
        userscoreTitle.setText("Your Score");
        getContentPane().add(userscoreTitle);
        userscoreTitle.setBounds(197, 64, 189, 46);

        Score.setFont(new java.awt.Font("Snap ITC", 1, 38)); // NOI18N
        Score.setForeground(new java.awt.Color(255, 255, 255));
        Score.setText("100");
        getContentPane().add(Score);
        Score.setBounds(250, 120, 100, 80);

        Background.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team_penguin/cs2450_project1/credit and score.jpg"))); // NOI18N
        Background.setText("100");
        getContentPane().add(Background);
        Background.setBounds(0, 0, 600, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EndActionPerformed
        // TODO add your handling code here:
        MenuScreen menuScreen = new MenuScreen();
         menuScreen.setVisible(true);
         dispose();
    }//GEN-LAST:event_EndActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(PlayerScore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(PlayerScore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(PlayerScore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(PlayerScore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new PlayerScore().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton End;
    private javax.swing.JLabel Score;
    private javax.swing.JLabel userscoreTitle;
    // End of variables declaration//GEN-END:variables
}
