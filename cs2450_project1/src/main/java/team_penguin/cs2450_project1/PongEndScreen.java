package team_penguin.cs2450_project1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author acer
 */
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
public class PongEndScreen extends javax.swing.JFrame {

    /**
     * Creates new form CreditScreen
     */
    public PongEndScreen(String name) {
        initComponents();
        setSize(600,400);
        setLocationRelativeTo(null);
        setResizable(false);
        this.playerName.setText(name);
        keybindings();
    }
        public void keybindings(){
        Action exit = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                System.exit(0);
            }
        };
            String WindowClose = "exit";
            getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"), WindowClose); 
            getRootPane().getActionMap().put(WindowClose, exit);
        Action dm = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                    ProjectInfo dm = new ProjectInfo();
                    dm.setVisible(true);
                    dispose();
                }
            };
            String PopMenu = "dm";
            getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F1"),PopMenu); 
            getRootPane().getActionMap().put(PopMenu,dm); 
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        playerName = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pong Game");
        setResizable(false);
        getContentPane().setLayout(null);

        title.setFont(new java.awt.Font("Stencil", 1, 30)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Victory!");
        title.setToolTipText("victory message");
        getContentPane().add(title);
        title.setBounds(230, 60, 160, 60);

        backButton.setFont(new java.awt.Font("Stencil", 1, 28)); // NOI18N
        backButton.setText("Quit");
        backButton.setToolTipText("Go back to menu");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(230, 270, 120, 40);

        playerName.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        playerName.setForeground(new java.awt.Color(255, 255, 255));
        playerName.setText("Player!");
        playerName.setToolTipText("Pong Game winner");
        getContentPane().add(playerName);
        playerName.setBounds(240, 170, 240, 30);

        background.setBackground(new java.awt.Color(0, 51, 51));
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team_penguin/cs2450_project1/credit and score.jpg"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(-1, 2, 600, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
         MenuScreen menuScreen = new MenuScreen();
         menuScreen.setVisible(true);
         dispose();
    }//GEN-LAST:event_backButtonActionPerformed

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
//            java.util.logging.Logger.getLogger(CreditScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(CreditScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(CreditScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(CreditScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new CreditScreen().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel background;
    private javax.swing.JLabel playerName;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}