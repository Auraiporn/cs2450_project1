/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team_penguin.cs2450_project1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author amirc
 */
public class SudokuTest extends javax.swing.JFrame {
    
    /**
     * Creates new form Sudoku
     */
    private javax.swing.JTextField [][] sudoku_board;
    private int [][] solution_matrix;
    private final int SUDOKU_SIZE = 9;
    private int [][] initial_matrix;
    public SudokuTest() {
        initComponents();
        
        setLayout(null);
        
        setSize(600,400);
        setLocation(300,200);
        setResizable(false);  
        
        sudoku_board = new javax.swing.JTextField [SUDOKU_SIZE][SUDOKU_SIZE];
        solution_matrix = new int [SUDOKU_SIZE][SUDOKU_SIZE];
        this.loadSolution("./src/main/java/team_penguin/cs2450_project1/sudoku_solution.txt",this.solution_matrix);
        initial_matrix = new int [SUDOKU_SIZE][SUDOKU_SIZE];
        this.loadSolution("./src/main/java/team_penguin/cs2450_project1/initial_matrix.txt",this.initial_matrix);
        
        showDate();
        showTime();
        
        keybindings();
        
        generateBoard();
        
    }
    
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
    
    private void loadSolution(String filepath, int [][] matrix)
    {
        try{
            //JOptionPane.showMessageDialog(null,System.getProperty("user.dir"));
            File myFile = new File(filepath);
            Scanner read = new Scanner(myFile);
            int row = 0;
            int col = 0;
            while(read.hasNextLine())
            {
                String [] values = read.nextLine().split(",");
                for(String value: values)
                {
                    matrix[row][col] = Integer.parseInt(value);
                    col++;
                }
                col = 0;
                row++;
            }
        }
        catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "File not found: " + filepath);
        }
    }
    
    private void generateBoard()
    {
        //Generate jPanel container for all textFields
        javax.swing.JPanel GameBoard = new javax.swing.JPanel();
        GameBoard.setBackground(new java.awt.Color(255, 255, 255));
        GameBoard.setBounds(150,40,300,300);
        GameBoard.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        
        //Adjust Layout
        GameBoard.setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
        
        //Generate textFields
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j<9; j++)
            {
                javax.swing.JTextField textArea = new javax.swing.JTextField();
                textArea.setEditable(true);
                textArea.setPreferredSize(new java.awt.Dimension(33, 33));
                textArea.setSelectedTextColor(new java.awt.Color(51, 51, 51));
                textArea.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                GameBoard.add(textArea);
                sudoku_board[i][j] = textArea;
                if(this.initial_matrix[i][j] != 0)
                {
                    sudoku_board[i][j].setText(Integer.toString(this.initial_matrix[i][j]));
                    sudoku_board[i][j].setEditable(false);
                    sudoku_board[i][j].setBackground(Color.LIGHT_GRAY);
                }
            }
        }
        this.add(GameBoard);
        
    }
    
    //Implementaion of esc key to exit program and f1 to pop out display. 
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

        // I tried to implement f1 key but I don't know what I'm doing wrong n it does not do anything when f1 is pressed. 
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Date = new javax.swing.JLabel();
        Time = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Submit");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 298, -1, -1));

        jButton2.setText("Quit");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 296, -1, -1));

        Date.setText("Date");
        getContentPane().add(Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 110, 23));

        Time.setText("Time");
        getContentPane().add(Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 97, 25));

        jLabel1.setFont(new java.awt.Font("Ravie", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("Sudoku");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 100, 30));

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
            java.util.logging.Logger.getLogger(SudokuTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SudokuTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SudokuTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SudokuTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SudokuTest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Date;
    private javax.swing.JLabel Time;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    


}
