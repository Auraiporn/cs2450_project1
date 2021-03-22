/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team_penguin.cs2450_project1;

/**
 *
 * @author acer
 */

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.Graphics;
import javax.swing.*; 
import java.awt.*;
import javax.swing.KeyStroke;

class Line extends JPanel{
    public Line(){
        
    }
    public void paintComponent(Graphics g)
    {
        g.drawLine(0, 0, 50, 0);
    }
}
public class Hangman extends javax.swing.JFrame {

    /**
     * Creates new form Hangman
     */
    private Integer[] guess;
    private String word;
    private ArrayList<javax.swing.JLabel> labelGroup;
    private ArrayList<javax.swing.JButton> buttonGroup;
    private int playerScore;
    public static String hangmanWord()
    {
        //Random number generator
        Random rand = new Random();
        // List of possible hangman words
        String[] words = {"abstract", "cemetery", "nurse", "pharmacy", "climbing"};
        // random select a position 
        return words[rand.nextInt(words.length)];
    }
    public static <T> void printAry(T[] ary)
    {
        for(int i = 0; i < ary.length; i++)
        {
            System.out.print(ary[i] + ", ");
        }
        System.out.print("\n");
    }
    public void init(Integer[] ary)
    {
        for(int i = 0; i < ary.length; i++)
        {
            ary[i] = 0;
        }
    }
    public boolean mark(ArrayList<Integer> position)
    {
        boolean flag = false;
        for(int i = 0; i < position.size(); i++)
        {
            guess[position.get(i)]=1;
            flag = true;
        }
        return flag;
        
    }
    public ArrayList<Integer> search(String word, String alphabet)
    {
        ArrayList<Integer> positions = new ArrayList<Integer>();
        for(int i = 0; i < word.length(); i++)
        {
            if(Character.toString(word.charAt(i)).equals(alphabet))
            {
                positions.add(i);
            }
        }
        return positions;
    }
    private void disableButton(String button_name)
    {
        for(int i = 0; i < buttonGroup.size(); i++)
        {
            if(buttonGroup.get(i).getText() == button_name)
            {
                buttonGroup.get(i).setVisible(false);
            }
        }
    }
    private boolean checkComplete()
    {
        for(int i = 0; i < guess.length; i++)
        {
            if(guess[i]==0)
            {
                return false;
            }
        }
        return true;
    }
    private boolean checkFail(){
        if(this.playerScore <= 40)
        {
            return true;
        }
        return false;
    }
    private void updateScore(int offset)
    {
        if(this.playerScore <= 0)
        {
            return;
        }
        this.playerScore += offset;
        score_label.setText(Integer.toString(this.playerScore));
    }
    private void updateImage(int score)
    {
        switch(score){
            case 90:
                hangman_visual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team_penguin/cs2450_project1/hangman_pic/step 5.png")));
                return;
            case 80:
                hangman_visual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team_penguin/cs2450_project1/hangman_pic/step 6.png")));
                return;
            case 70:
                hangman_visual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team_penguin/cs2450_project1/hangman_pic/step 7.png")));
                return;
            case 60:
                hangman_visual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team_penguin/cs2450_project1/hangman_pic/step 8.png")));
                return;
            case 50:
                hangman_visual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team_penguin/cs2450_project1/hangman_pic/step 9.png")));
                return;
            case 40:
                hangman_visual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team_penguin/cs2450_project1/hangman_pic/step 10.png")));
                return;
                
                
        }
    }
    
    public Hangman() {
        
        initComponents();
        
        //Set the height and width of window screen and do not let user to change the size
        setSize(600,400);
        setLocationRelativeTo(null);
        setResizable(false);
        
        //Initialize word
        this.word = hangmanWord();
        
        //Initialize score
        this.playerScore = 100;
        this.updateScore(0);
        
         //Initialized Guess array
        this.guess = new Integer[word.length()];
        //Initialize to 0
        init(guess);
        
        this.buttonGroup = generateAlphabetButton();
        this.labelGroup = generateSolutionLabel();
        
        //date and time
        showDate();
        showTime();
        keybindings();
        
    }
    // Methods to show Time and Date
    void showDate(){
        Date d = new Date();
        SimpleDateFormat f = new SimpleDateFormat("MMMM dd, yyyy");
        Date.setText(f.format(d));
    }
    
    void showTime(){
        new Timer(0, new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e) {
               Date d = new Date();
               SimpleDateFormat f = new SimpleDateFormat("hh:mm:ss a");
               Time.setText(f.format(d));
            }
        }).start();
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

        skipButton = new javax.swing.JButton();
        Date = new javax.swing.JLabel();
        Time = new javax.swing.JLabel();
        score_title = new javax.swing.JLabel();
        score_label = new javax.swing.JLabel();
        hangman_visual = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hang Man Game");
        getContentPane().setLayout(null);

        skipButton.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        skipButton.setText("Skip");
        skipButton.setToolTipText("Skip this game");
        skipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipButtonActionPerformed(evt);
            }
        });
        getContentPane().add(skipButton);
        skipButton.setBounds(470, 10, 100, 40);

        Date.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        Date.setText("Date");
        getContentPane().add(Date);
        Date.setBounds(140, 10, 190, 40);

        Time.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        Time.setText("Time");
        getContentPane().add(Time);
        Time.setBounds(330, 10, 120, 40);

        score_title.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        score_title.setText("Score");
        getContentPane().add(score_title);
        score_title.setBounds(50, 60, 70, 20);

        score_label.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        score_label.setText("100");
        score_label.setToolTipText("current score");
        getContentPane().add(score_label);
        score_label.setBounds(60, 80, 40, 30);

        hangman_visual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team_penguin/cs2450_project1/hangman_pic/step 4.png"))); // NOI18N
        getContentPane().add(hangman_visual);
        hangman_visual.setBounds(210, 110, 170, 100);

        pack();
    }// </editor-fold>//GEN-END:initComponents

//x, y,length, width,
// 30,300,40,40
    
    public ArrayList<javax.swing.JLabel> generateSolutionLabel()
    {
        
        ArrayList<javax.swing.JLabel> solutionLabelGroup = new ArrayList<javax.swing.JLabel>();
        int [] original = {170,250,40,40};
        
        int location_x = 170;
        int location_y = 200;
        int length = 40;
        int width = 40;
        
        int space_between = 30;
        
        int count = this.word.length();
        
        for(int i = 0; i < count; i++)
        {
            //Create the label
            javax.swing.JLabel label = new javax.swing.JLabel();
            label.setText("");
            getContentPane().add(label);
            label.setBounds(location_x, location_y, length, width);
            
            //Add line
            javax.swing.JPanel line_panel = new Line();
            getContentPane().add(line_panel);
            line_panel.setBounds(location_x - 5, location_y + 30, 15, 15);
            
            //Add it to arrayList
            solutionLabelGroup.add(label);
            
            location_x += space_between;
        }
        
        return solutionLabelGroup;
    }
        
    public ArrayList<javax.swing.JButton> generateAlphabetButton()
    {
        ArrayList<javax.swing.JButton> alphabetButtonGroup = new ArrayList<javax.swing.JButton>();
        int [] original = {30,250,40,40};
        
        int location_x = 30;
        int location_y = 250;
        int length = 40;
        int width = 40;
        
        int space_between = 40;
        
        int count = 1;
        int middle = 13;
        
        for(char alphabet = 'a'; alphabet <='z'; alphabet++)
        {
            javax.swing.JButton button = new javax.swing.JButton();
            button.setText("" + alphabet);
            button.setOpaque(true);
            button.setBounds(location_x, location_y, length, width);
            button.setToolTipText("Click to try this character!");
            
            getContentPane().add(button);
            
            //ActionListeners
            button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AllButtonActionPerformed(evt);
            }
            });
            
            //Add it to arrayList
            alphabetButtonGroup.add(button);
            
            location_x += space_between;
            if(count == 13)
            {
                location_x = original[0];
                location_y += 50;
            }
            count++;
            
        }
        return alphabetButtonGroup;
    }
    private void skipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipButtonActionPerformed
        // TODO add your handling code here:
        ColorGame ms = new ColorGame();
        ms.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_skipButtonActionPerformed

    private void AllButtonActionPerformed(java.awt.event.ActionEvent evt) {
        
        // For local testing purpose
        //System.out.println("The word is " + this.word);
        //JOptionPane.showMessageDialog(null, "You've pressed the " + evt.getActionCommand() + " button!");
        if(mark(search(this.word, evt.getActionCommand())))
        {
            JOptionPane.showMessageDialog(null, "You've found one letter!");
            for(int i = 0; i < guess.length; i++)
            {
                if(guess[i] == 1)
                {
                    this.labelGroup.get(i).setText(Character.toString(this.word.charAt(i)));
                    this.disableButton(evt.getActionCommand());
                }
            }
            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Wrong!");
            int penalty = -10;
            this.updateScore(penalty);
            this.updateImage(this.playerScore);
            this.disableButton(evt.getActionCommand());
        }
        
        if(checkComplete())
        {
            ColorGame ms = new ColorGame(this.playerScore);
            ms.setVisible(true);
            dispose();
        }
        if(checkFail())
        {
            JOptionPane.showMessageDialog(null, "Lose!");
            ColorGame ms = new ColorGame(this.playerScore);
            ms.setVisible(true);
            dispose();
        }
        
    } 
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
//            java.util.logging.Logger.getLogger(Hangman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Hangman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Hangman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Hangman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Hangman().setVisible(true);
//                
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Date;
    private javax.swing.JLabel Time;
    private javax.swing.JLabel hangman_visual;
    private javax.swing.JLabel score_label;
    private javax.swing.JLabel score_title;
    private javax.swing.JButton skipButton;
    // End of variables declaration//GEN-END:variables

}
