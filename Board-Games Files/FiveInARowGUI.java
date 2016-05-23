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
        g.setColor(Color.black);
        for(int i = 1; i<=19; i++)
        {
            
        }
    }
  
    public void mouseClicked (MouseEvent me) 
    {
        xpos = me.getX(); 
        ypos = me.getY();

        int row = xpos/200;
        int col = ypos/200;

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
