import java.applet.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Write a description of class testApplet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TicTacToeGUI extends Applet implements MouseListener
{
    int xpos;
    int ypos;
    boolean mouseEntered;
    boolean[][] squares;
    boolean rect1Clicked;
    TicTacToeBoard board = new TicTacToeBoard();

    public void init()
    {
        addMouseListener(this);
    }

    public void paint(Graphics g)
    {
        

        g.setColor(Color.black);
        g.drawLine(0,200,600,200);
        g.drawLine(0,400,600,400);
        g.drawLine(200,0,200,600);
        g.drawLine(400,0,400,600);

        if(board.gameOver() == -1)
        {
            for(int row = 0; row < 3; row ++)
            {
                for (int col = 0; col < 3; col++)
                {
                    if (board.getBoard()[row][col] == 1)
                    {
                        g.drawLine(25+row*200,25+col*200,175 + row*200, 175 + col*200);
                        g.drawLine(25+row*200, 175+col*200, 175+ row*200, 25+col*200);
                    }
                    else if(board.getBoard()[row][col]==2)
                    {
                        g.drawOval(25+row*200,25+col*200,150,150);
                    }

                }

            }
        }

        if(board.gameOver() == 0)
        {
            g.drawString("It's a tie!",270,290);
        }
        if(board.gameOver()==1 || board.gameOver()==2)
        {
            g.drawString("Player " + board.gameOver() + " wins!", 265,290);
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
