import java.applet.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Write a description of class FiveInARowGUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FiveInARowGUI extends Applet implements MouseListener
{
    // instance variables - replace the example below with your own
    int xpos;
    int ypos;
    boolean mouseEntered;
    boolean[][] squares;
    boolean rect1Clicked;
    FiveInARow board = new FiveInARow();

    public void init()
    {
        addMouseListener(this);
    }
    
    public void paint(Graphics g)
    {
        g.setColor(new Color(193,154,107));
        g.fillRect(0,0,800,800);
        
        g.setColor(Color.black);
        for(int i = 1; i<=19; i++)
        {
            g.drawLine(40*i,40,40*i,760);
            g.drawLine(40,40*i,760,40*i);
        }
        
        
        g.fillOval(155,155,10,10);
        g.fillOval(395,155,10,10);
        g.fillOval(635,155,10,10);
        g.fillOval(155,395,10,10);
        g.fillOval(395,395,10,10);
        g.fillOval(635,395,10,10);
        g.fillOval(155,635,10,10);
        g.fillOval(395,635,10,10);
        g.fillOval(635,635,10,10);
        
        if(board.gameOver() == -1)
        {
            for(int row = 0; row < 19 ; row ++)
            {
                for (int col = 0; col < 19; col++)
                {
                    if (board.getBoard()[row][col] == 1)
                    {
                        g.setColor(Color.black);
                        g.fillOval((row+1)*40-15,(col+1)*40-15,30,30);
                    }
                    else if(board.getBoard()[row][col]==2)
                    {
                        g.setColor(Color.white);
                        g.fillOval((row+1)*40-15,(col+1)*40-15,30,30);
                    }

                }

            }
        }
        
        if(board.gameOver() == 0)
        {
            g.drawString("It's a tie!",370,390);
        }
        if(board.gameOver()==1 || board.gameOver()==2)
        {
            g.drawString("Player " + board.gameOver() + " wins!", 365,390);
        }
    }
  
    public void mouseClicked (MouseEvent me) 
    {
        xpos = me.getX(); 
        ypos = me.getY();

        int row = (xpos-20)/40;
        int col = (ypos-20)/40;

        if(board.availableMoves()[row][col])
        {
            board.play(row,col);
            repaint();
        }
        else
        {

        }

    } 

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
