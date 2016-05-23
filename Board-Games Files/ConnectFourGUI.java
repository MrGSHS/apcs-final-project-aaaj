
/**
 * Write a description of class ConnectFourGUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class ConnectFourGUI extends MouseAdapter implements ActionListener
{
    private int width;
    private int height;
    
    private JFrame frmConnectfour;
    private JButton[][] options;
    private JButton reset;
    
    private boolean over;
    
    private ConnectFourBoard stuff;
    public static void main (String [] args)
    {
        
    }
    
    public ConnectFourGUI()
    {
        width=7;
        height=6;
        over=false;
        initialize();
    }
    
    public void initialize()
    {
        //main frame
        frmConnectfour=new Jframe();
        frmConnectfour.setTitle("ConnectFour");
        frmConnectfour.setBounds(100,100,500,550);
        frmConnectfour.setLayout(new BorderLayout());
        frmConnectfour.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //creating button array
        tiles=newJButton[0][height];
        for (int i=0; i<tiles[0].length; i++)
        {
            tiles[0][i]=new JButton();
            tiles[0][i].addActionListener(this);
            tiles[0][i].addMouseListener(this);
            tiles[0][i].setFocusPainted(false); //removes blue border
            
        }
        
        frmConnectfour.add(BorderLayout.CENTER);
    }
}
