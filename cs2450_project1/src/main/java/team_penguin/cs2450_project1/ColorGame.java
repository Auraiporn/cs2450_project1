/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team_penguin.cs2450_project1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.Timer;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import java.io.File;
import java.io.FileNotFoundException; 
import java.io.FileWriter;
import java.util.Scanner; 
import java.io.IOException;

/**
 *
 * @author amirc
 */
public class ColorGame extends javax.swing.JFrame {
    // For random word
    private static String [] colors = new String[] {"Red", "Yellow", "Green", "Blue", "Purple"}; 
    // For random color
    private static Color [] colors2 = new Color[] {Color.RED,Color.YELLOW,Color.GREEN,Color.BLUE,new Color(255,0,255)};  
    
    private ArrayList<Integer> position_x;
    private ArrayList<Integer> position_y;
    
    private int prevLayout;
    private int numOfLayout;
    
    private int word;
    private int rand_color;
    private int player_Score;
    private int numberOfGuesses; 
    private final int MAX_ROUNDS = 5;
    
    private ArrayList<javax.swing.JButton> color_button_group;
    
    /**
     * Creates new form ColorGame
     */
    public ColorGame() {
        initComponents();
        setSize(600,400);
        setLocation(300,200);
        setResizable(false);
        
        // Initialized Layout
        position_x = new ArrayList<Integer>();
        position_y = new ArrayList<Integer>();
       
        this.numberOfGuesses = 0;
        this.player_Score = 0;
        this.prevLayout = 0;
        this.numOfLayout = 3;
        
        //Display Round
        Round.setText("Round: " + (numberOfGuesses+1));
                
        //Add action listener to all button
        this.color_button_group = new ArrayList<javax.swing.JButton>();
        
        this.color_button_group.add(Red);
        this.color_button_group.add(Yellow);
        this.color_button_group.add(Green);
        this.color_button_group.add(Blue);
        this.color_button_group.add(Purple);
        
        for(int i = 0; i < color_button_group.size(); i++)
        {
            color_button_group.get(i).addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    
                    buttonPerformed(evt);
                }
            });
        }
        
        displayWord();
        //date and time
        showDate();
        showTime();
    }
    public ColorGame(int score)
    {
        this();
        this.player_Score = score;
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
    public void displayWord (){
     //display word
        Random rand = new Random();
        this.word = rand.nextInt(colors.length);
        Title.setText(colors[word]);
        // display color  
        this.rand_color = rand.nextInt(colors.length);
        Title.setForeground(colors2[rand_color]);
        // Update round
        Round.setText("Round: " + (numberOfGuesses+1));
        
        //Set position layout
        //Only 3 layout currently
        this.setRandomLayout(rand.nextInt(numOfLayout));
    }
    public void setRandomLayout(int layout)
    {
        // Randomizer
        Random rand = new Random();
        //Make sure does not repeat previous
        while(layout == this.prevLayout)
        {
            layout = rand.nextInt(numOfLayout);
        }
        this.prevLayout = layout;
             
        //Variables to access the correct row
        layout *= 2;
        int curr = 0;
        
        //Load the file to obtain the coordinates
        try{
            File myFile = new File("./src/main/java/team_penguin/cs2450_project1/positions.txt");
            Scanner read = new Scanner(myFile);
            while(read.hasNextLine())
            {
                if(curr >= layout)
                {
                    for (String s : read.nextLine().split(","))
                    {
                        position_x.add(Integer.parseInt(s));
                    }
                    for (String s : read.nextLine().split(","))
                    {
                        position_y.add(Integer.parseInt(s));
                    }
                    break;
                }
                read.nextLine();
                curr++;
            }
            read.close();
        }
        catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "File not found!");
        }
        //Create a copy of color_group
        ArrayList<javax.swing.JButton> color_group_copy = new ArrayList<javax.swing.JButton>();
        for(javax.swing.JButton button: color_button_group)
        {
            color_group_copy.add(button);
        }
        // Randomizing position for the color buttons
        curr = 0;
        while(!color_group_copy.isEmpty())
        {
            int random_index = rand.nextInt(color_group_copy.size());
            color_group_copy.get(random_index).setLocation(position_x.get(curr), position_y.get(curr));
            color_group_copy.remove(random_index);
            curr++;
        }
        // reset the position array
        position_x.clear();
        position_y.clear();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private int checkColorWithText(String color_name)
    {
        for(int i = 0; i < colors.length; i++)
        {
            if(colors[i]== color_name)
            {
                return i;
            }
        }
        return -1;
    }
    private void buttonPerformed(java.awt.event.ActionEvent evt)
    {
        javax.swing.JButton button = (javax.swing.JButton) evt.getSource();
        javax.swing.Icon picture = button.getIcon();
        
        if(picture == Yellow.getIcon())
        {
            if(rand_color == checkColorWithText("Yellow"))
            {
                JOptionPane.showMessageDialog(null, "Guess correctly" );
                player_Score += 100;
            }
            else{
                JOptionPane.showMessageDialog(null, "Wrong!" );
            }
        }
        else if(picture == Blue.getIcon())
        {
            if(rand_color == checkColorWithText("Blue"))
            {
                JOptionPane.showMessageDialog(null, "Guess correctly" );
                player_Score += 100;
            }
            else{
                JOptionPane.showMessageDialog(null, "Wrong!" );
            }
        }
        else if(picture == Red.getIcon())
        {
            if(rand_color == checkColorWithText("Red"))
            {
                JOptionPane.showMessageDialog(null, "Guess correctly" );
                player_Score += 100;
            }
            else{
                JOptionPane.showMessageDialog(null, "Wrong!" );
            }
        }
        else if(picture == Purple.getIcon())
        {
            if(rand_color == checkColorWithText("Purple"))
            {
                JOptionPane.showMessageDialog(null, "Guess correctly" );
                player_Score += 100;
            }
            else{
                JOptionPane.showMessageDialog(null, "Wrong!" );
            }
        }
        else if(picture == Green.getIcon())
        {
            if(rand_color == checkColorWithText("Green"))
            {
                JOptionPane.showMessageDialog(null, "Guess correctly" );
                player_Score += 100;
            }
            else{
                JOptionPane.showMessageDialog(null, "Wrong!" );
            }
        }
        numberOfGuesses++;
        if(numberOfGuesses >= MAX_ROUNDS){
            PlayerScore ms = new PlayerScore(player_Score);
            ms.setVisible(true);
            dispose();
        }
        displayWord();
        
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JLabel();
        Yellow = new javax.swing.JButton();
        Blue = new javax.swing.JButton();
        Red = new javax.swing.JButton();
        Purple = new javax.swing.JButton();
        Green = new javax.swing.JButton();
        Time = new javax.swing.JLabel();
        Round = new javax.swing.JLabel();
        Date = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Color Game");
        getContentPane().setLayout(null);

        Title.setFont(new java.awt.Font("Stencil", 1, 18)); // NOI18N
        Title.setText("Color_Title");
        getContentPane().add(Title);
        Title.setBounds(220, 110, 150, 50);

        Yellow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team_penguin/cs2450_project1/hangman_pic/yellow.png"))); // NOI18N
        Yellow.setBorderPainted(false);
        Yellow.setContentAreaFilled(false);
        Yellow.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/team_penguin/cs2450_project1/hangman_pic/yellow_hover.png"))); // NOI18N
        getContentPane().add(Yellow);
        Yellow.setBounds(400, 40, 140, 120);

        Blue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team_penguin/cs2450_project1/hangman_pic/blue.png"))); // NOI18N
        Blue.setBorderPainted(false);
        Blue.setContentAreaFilled(false);
        Blue.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/team_penguin/cs2450_project1/hangman_pic/blue_hover.png"))); // NOI18N
        getContentPane().add(Blue);
        Blue.setBounds(10, 60, 141, 117);

        Red.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team_penguin/cs2450_project1/hangman_pic/red.png"))); // NOI18N
        Red.setBorderPainted(false);
        Red.setContentAreaFilled(false);
        Red.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/team_penguin/cs2450_project1/hangman_pic/red_hover.png"))); // NOI18N
        getContentPane().add(Red);
        Red.setBounds(110, 180, 160, 120);

        Purple.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team_penguin/cs2450_project1/hangman_pic/purple.png"))); // NOI18N
        Purple.setBorderPainted(false);
        Purple.setContentAreaFilled(false);
        Purple.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/team_penguin/cs2450_project1/hangman_pic/purple_hover.png"))); // NOI18N
        getContentPane().add(Purple);
        Purple.setBounds(430, 160, 141, 117);

        Green.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team_penguin/cs2450_project1/hangman_pic/green.png"))); // NOI18N
        Green.setBorderPainted(false);
        Green.setContentAreaFilled(false);
        Green.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/team_penguin/cs2450_project1/hangman_pic/green_hover.png"))); // NOI18N
        getContentPane().add(Green);
        Green.setBounds(290, 190, 140, 120);

        Time.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        Time.setText("Time");
        getContentPane().add(Time);
        Time.setBounds(470, 0, 120, 30);

        Round.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        Round.setText("Round: ");
        getContentPane().add(Round);
        Round.setBounds(30, 10, 170, 30);

        Date.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        Date.setText("Date");
        getContentPane().add(Date);
        Date.setBounds(280, 0, 170, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
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
    private javax.swing.JLabel Date;
    private javax.swing.JButton Green;
    private javax.swing.JButton Purple;
    private javax.swing.JButton Red;
    private javax.swing.JLabel Round;
    private javax.swing.JLabel Time;
    private javax.swing.JLabel Title;
    private javax.swing.JButton Yellow;
    // End of variables declaration//GEN-END:variables

}