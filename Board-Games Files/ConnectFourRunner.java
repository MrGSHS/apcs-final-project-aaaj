
/**
 * Write a description of class ConnectFourRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class ConnectFourRunner
{
   
    public static void main(String[] args)
    {
        int col=0;
        System.out.println("Enter the column number");
        Scanner sc = new Scanner(System.in);
        ConnectFourBoard hi = new ConnectFourBoard();
        
        while(hi.gameOver()==-1 )
        {
 
            System.out.print("Player " + hi.getPlayer() + ", please make a move: ");
            col = sc.nextInt();
            while (col<0 || col>6) 
            {
                System.out.print("Invalid move. Player " + hi.getPlayer() + ", please make a legal move: ");
                col=sc.nextInt();
            }
            hi.play(0,col);         
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
