
/**
 * Write a description of class ConnectFourGUI here.
 * 
 * @Albert
 * @version (a version number or a date)
 */
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class ConnectFourGUI extends Applet implements MouseListener
{
    int xpos;
    int ypos;
    boolean mouseEntered;
    boolean[][] squares;
    boolean rect1Clicked;
    ConnectFourBoard board = new ConnectFourBoard();

    public void init()
    {
        addMouseListener(this);
    }
    //draws the board, and redraws it each time as a move is made.
    public void paint(Graphics g)
    {
        
        g.setColor(Color.black);
        for (int i=0; i<=600; i+=100)
        {
            g.drawLine(0,i,700,i);
        }
        for (int i=0; i<=700; i+=100)
        {
            g.drawLine(i,0,i,600);
        }

        if(board.gameOver() == -1)
        {
            for(int row = 0; row < 6; row ++)
            {
                for (int col = 0; col < 7; col++)
                {
                    if (board.getBoard()[row][col] == 1)
                    {
                        g.setColor(Color.black);
                        g.fillOval((col)*100,(5-row)*100,100,100);
                    }
                    else if(board.getBoard()[row][col]==2)
                    {
                        g.setColor(Color.red);
                        g.fillOval((col)*100,(5-row)*100,100,100);
                    }
                    
                }

            }
        }

        if(board.gameOver() == 0)
        {
            g.drawString("It's a tie!",305,345);
        }
        if(board.gameOver()==1 || board.gameOver()==2)
        {
            g.drawString("Player " + board.gameOver() + " wins!", 307,350);
        }

    }
    //gets the coordinates of where the move clicked.
    public void mouseClicked (MouseEvent me) 
    {
        xpos = me.getX();

        int col = xpos/100;

        if(board.availableMoves()[0][col])
        {
            board.play(0,col);
            repaint();
        }
        else
        {

        }

    } 
    //simply needed to be implemeneted, no use for mousePressed and mouseReleased
    public void mouseEntered (MouseEvent me) 
    {
        mouseEntered = true; 
        repaint();
    } 

    public void mousePressed (MouseEvent me) 
    {
    } 

    public void mouseReleased (MouseEvent me)
    {
    }  

    public void mouseExited (MouseEvent me) 
    {
        mouseEntered = false; 
        repaint(); 
    }  
}
