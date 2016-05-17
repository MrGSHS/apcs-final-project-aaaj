import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Write a description of class TicTacToeGUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TicTacToeGUI extends JPanel
{
    private int WIDTH = 500;
    private int HEIGHT = 500;
    private JFrame frame;
    private JPanel panel;
    TicTacToeBoard hello;
    

    /**
     * Constructor for objects of class TicTacToeGUI
     */
    public TicTacToeGUI()
    {
        
    }
    
    private void initialize()
    {
        frame = new JFrame();
        
    }
    
    
    
    public static void main(String[] args)
    {
        JPanel panel2 = new JPanel();
        JButton hi = new JButton("OK");
        panel2.add(hi);
        JButton cancelButton = new JButton("Cancel");
        panel2.add(cancelButton);
        JFrame frame2 = new JFrame("testing");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.add(panel2);
        frame2.setSize(300,200);
        frame2.setVisible(true);
     
    }

    
}
