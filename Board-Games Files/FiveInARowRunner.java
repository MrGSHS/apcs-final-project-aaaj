import java.util.*;
/**
 * Write a description of class FiveInARowRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FiveInARowRunner
{
    // instance variables - replace the example below with your own
    
    public static void main(String[] args)
    {
        String str;
        int row=0, col=0, indexOfComma;
        System.out.println("Enter the coordinates in the format #,# seperated by a comma with no space");
        Scanner sc = new Scanner(System.in);
        FiveInARow hi = new FiveInARow();
        
        while(hi.gameOver() == -1)
        {
            System.out.print("Player " + hi.getPlayer() + ", please make a move: ");
            str = sc.nextLine();
            indexOfComma=str.indexOf(",");
            
            while(indexOfComma == -1 || Integer.parseInt(str.substring(0,indexOfComma))>18 ||
            Integer.parseInt(str.substring(0,indexOfComma))<0 ||
            Integer.parseInt(str.substring(indexOfComma+1))>18 || Integer.parseInt(str.substring(indexOfComma+1))<0)
            {
                System.out.print("Invalid move. Player " + hi.getPlayer() + ", please make a legal move: ");
                str=sc.nextLine();
                indexOfComma=str.indexOf(",");
            }
            
            row=Integer.parseInt(str.substring(0,indexOfComma));
            col=Integer.parseInt(str.substring(indexOfComma+1));
            hi.play(row,col);
            
        }
        
        if(hi.gameOver()==0)
        {
            System.out.println("The game is a tie!");
        }
        else
        {
            System.out.println("Player " + hi.gameOver() + " wins!");
        }
    }
}
