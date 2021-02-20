/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team_penguin.cs2450_project1;

import java.io.File;
import java.io.FileNotFoundException; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; 
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author acer
 */
public class ScoreScreen extends javax.swing.JFrame {

    /**
     * Creates new form ScoreScreen
     */
    private javax.swing.JLabel score_label_group[] = new javax.swing.JLabel[5];
    private ArrayList<String> score_array;
    private int playerScore;
    
    public ScoreScreen() {
        initComponents();
        setSize(600,400);
        setLocation(300,200);
        setResizable(false);
        playerScore = 0;
        score_array = new ArrayList<String>();
        
        score_label_group[0] = score_top1;
        score_label_group[1] = score_top2;
        score_label_group[2] = score_top3;
        score_label_group[3] = score_top4;
        score_label_group[4] = score_top5;
        loadScores();
    }
    public ScoreScreen(int score){
        this();
        this.playerScore = score;
        
    }
    
    private void loadScores()
    {
        try{
            //JOptionPane.showMessageDialog(null,System.getProperty("user.dir"));
            File myFile = new File("./src/main/java/team_penguin/cs2450_project1/score.txt");
            Scanner read = new Scanner(myFile);
            while(read.hasNextLine()){
                enqueue(read.nextLine());
            }
            clearExtra();
            for(int i = 0; i < score_array.size(); i++)
            {
                score_label_group[i].setText(score_array.get(i));
            }
        }
        catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "File not found: score.txt");
        }
        export();
    }
    private Integer firstNumber(String s)
    {
        int i = 0;
        while(i < s.length() && !Character.isDigit(s.charAt(i))){
            i++;
        }
        int j = i;
        while(j < s.length() && Character.isDigit(s.charAt(j)))
        {
            j++;
        }
        return Integer.parseInt(s.substring(i,j));
    }
    
    private void enqueue(String s)
    {
        boolean addFlag = false;
        if(score_array.isEmpty())
        {
            score_array.add(s);
            return;
        }
        int size = score_array.size();
        for(int i = 0; i < size; i++)
        {
            if(firstNumber(score_array.get(i)) <= firstNumber((s)))
            {
                score_array.add(score_array.get(i));
                score_array.set(i, s);
                addFlag = true;
                break;
            }
        }
        if(addFlag == false)
        {
            score_array.add(s);
        }
    }
    private void dequeue()
    {
       score_array.remove(score_array.size()-1);
    }
    private void clearExtra()
    {
        while(score_array.size()> 5)
        {
            dequeue();
        }
    }
    private void export(){
        try{
            FileWriter fileWriter = new FileWriter("./src/main/java/team_penguin/cs2450_project1/score.txt");
            for(String s:score_array)
            {
                fileWriter.write(s + "\n");
            }
            fileWriter.close();
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Fail to write: score.txt");
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

        title = new javax.swing.JLabel();
        score_top1 = new javax.swing.JLabel();
        score_top2 = new javax.swing.JLabel();
        score_top3 = new javax.swing.JLabel();
        score_top4 = new javax.swing.JLabel();
        score_top5 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("High Scores");
        setResizable(false);
        getContentPane().setLayout(null);

        title.setFont(new java.awt.Font("Stencil", 1, 30)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("High Scores");
        getContentPane().add(title);
        title.setBounds(190, 50, 230, 52);

        score_top1.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        score_top1.setForeground(new java.awt.Color(255, 255, 255));
        score_top1.setText("top1");
        score_top1.setPreferredSize(new java.awt.Dimension(250, 30));
        getContentPane().add(score_top1);
        score_top1.setBounds(190, 120, 250, 30);

        score_top2.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        score_top2.setForeground(new java.awt.Color(255, 255, 255));
        score_top2.setText("Top2");
        score_top2.setPreferredSize(new java.awt.Dimension(250, 30));
        getContentPane().add(score_top2);
        score_top2.setBounds(190, 160, 250, 30);

        score_top3.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        score_top3.setForeground(new java.awt.Color(255, 255, 255));
        score_top3.setText("Top3");
        score_top3.setPreferredSize(new java.awt.Dimension(250, 30));
        getContentPane().add(score_top3);
        score_top3.setBounds(190, 200, 250, 30);

        score_top4.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        score_top4.setForeground(new java.awt.Color(255, 255, 255));
        score_top4.setText("Top4");
        score_top4.setPreferredSize(new java.awt.Dimension(250, 30));
        getContentPane().add(score_top4);
        score_top4.setBounds(190, 240, 250, 30);

        score_top5.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        score_top5.setForeground(new java.awt.Color(255, 255, 255));
        score_top5.setText("Top5");
        score_top5.setPreferredSize(new java.awt.Dimension(250, 30));
        getContentPane().add(score_top5);
        score_top5.setBounds(190, 280, 250, 30);

        backButton.setFont(new java.awt.Font("Stencil", 1, 28)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(20, 310, 120, 40);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team_penguin/cs2450_project1/credit and score.jpg"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(1, -4, 600, 400);

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
            java.util.logging.Logger.getLogger(ScoreScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScoreScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScoreScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScoreScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScoreScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel background;
    private javax.swing.JLabel score_top1;
    private javax.swing.JLabel score_top2;
    private javax.swing.JLabel score_top3;
    private javax.swing.JLabel score_top4;
    private javax.swing.JLabel score_top5;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
