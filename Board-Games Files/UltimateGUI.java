import java.applet.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Class UltimateGUI - write a description of the class here
 * 
 * @author (your name) 
 * @version (a version number)
 */
public class UltimateGUI extends Applet implements MouseListener
{
    int xpos;
    int ypos;
    boolean mouseEntered;
    boolean[][] squares;
    boolean rect1Clicked;
    UltimateTicTacToe board = new UltimateTicTacToe();
    int prevRow=-1, prevCol=-1;
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
        
        for(int x = 1; x<=8; x++){
            if(x%3!=0){
                g.drawLine(600*x/9, 10, 600*x/9, 190);
                g.drawLine(600*x/9, 210, 600*x/9, 390);
                g.drawLine(600*x/9, 410, 600*x/9, 590);
                g.drawLine(10, 600*x/9, 190, 600*x/9);
                g.drawLine(210, 600*x/9, 390, 600*x/9);
                g.drawLine(410, 600*x/9, 590, 600*x/9);
            }
        }
        

        if(board.gameOver() == -1)
        {
            for(int row = 0; row < 3; row ++)
            {
                for (int col = 0; col < 3; col++)
                {
                    for(int row2 = 0; row2<3; row2++){
                        for(int col2 = 0; col2<3; col2++){ 
                            if(board.getUltBoard()[row][col].getBoard()[row2][col2] == 1){
                                g.drawLine(row*200+66*row2+10, col*200+66*col2+10,row*200+66*row2+56,col*200+66*col2+56);
                                g.drawLine(row*200+66*row2+56, col*200+66*col2+10,row*200+66*row2+10,col*200+66*col2+56);
                            }
                            else if(board.getUltBoard()[row][col].getBoard()[row2][col2] == 2){
                                g.drawOval(row*200+66*row2+10, col*200+66*col2+10,46,46);
                            }
                    
                            /*
                            * if (board.getBoard()[row][col] == 1)
                            * {
                            *     g.drawLine(25+row*200,25+col*200,175 + row*200, 175 + col*200);
                            *     g.drawLine(25+row*200, 175+col*200, 175+ row*200, 25+col*200);
                            *   }
                            *   else if(board.getBoard()[row][col]==2)
                            *   {
                            *       g.drawOval(25+row*200,25+col*200,150,150);
                            *   }
                            */
                        }
                    }
                }

            }
            
            
            
            for(int row = 0; row < 3; row++){
                for(int col = 0; col < 3; col++){
                     
                            if(board.getUltBoard()[row][col].getBoardVal()==1){
                                g.drawLine(row*200, col*200, row*200+200, col*200+200);
                                g.drawLine(row*200+200, col*200, row*200, col*200+200);
                            }
                            else if (board.getUltBoard()[row][col].getBoardVal()==2){
                                g.drawOval(row*200, col*200,200,200);
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
        
        int row2 = (xpos%200)/66;
        int col2 = (ypos%200)/66;
        
        if(prevRow == -1 & prevCol==-1){
        
        
        
            if(board.getUltBoard()[row][col].getBoard()[row2][col2] != 1 && board.getUltBoard()[row][col].getBoard()[row2][col2] != 2 && board.getUltBoard()[row][col].gameOver()==-1)
            {
                board.play(row,col,row2,col2);
                repaint();
                prevRow = row2;
                prevCol = col2;
            }
            else
            {

            }
        }
        else if (board.getUltBoard()[prevRow][prevCol].gameOver() == -1){
            if(row == prevRow && col == prevCol){
                board.play(row,col,row2,col2);
                repaint();
                prevRow = row2;
                prevCol = col2;
            }
        
        }
        else if(board.getUltBoard()[prevRow][prevCol].gameOver() != -1){
            board.play(row,col,row2,col2);
            repaint();
            prevRow = row2;
            prevCol = col2;
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
