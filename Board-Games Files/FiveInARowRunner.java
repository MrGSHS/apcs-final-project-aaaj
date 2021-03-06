import java.util.*;
/**
 * Five in a row only using your mind. Played using coordinates.
 * 
 * @Andrew
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
            
            while(indexOfComma == -1 || Integer.parseInt(str.substring(0,indexOfComma))>19 ||
            Integer.parseInt(str.substring(0,indexOfComma))<0 ||

            Integer.parseInt(str.substring(indexOfComma+1))>19 || Integer.parseInt(str.substring(indexOfComma+1))<0 || 

            Integer.parseInt(str.substring(indexOfComma+1,indexOfComma+2))>18 || Integer.parseInt(str.substring(indexOfComma+1,indexOfComma+2))<0)

            {
                System.out.print("Invalid move. Player " + hi.getPlayer() + ", please make a legal move: ");
                str=sc.nextLine();
                indexOfComma=str.indexOf(",");
            }
            
            row=Integer.parseInt(str.substring(0,indexOfComma)) - 1;
            col=Integer.parseInt(str.substring(indexOfComma+1)) - 1;
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
