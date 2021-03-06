import java.util.*;
/**
 * Write a description of class UltRunner here.
 * 
 * @Josh
 * @version (a version number or a date)
 */
public class UltRunner
{
    public static void main(String[] args)
    {
        String str, str2;
        int row=0, col=0, row2=0, col2=0, indexOfComma;
        System.out.println("Enter the coordinates of the board you want to make your move in in the format #,# separated by a comma and with no space.");
        System.out.println("Then enter the coordinates of the square of the board in the same format.");
        Scanner sc = new Scanner(System.in);
        UltimateTicTacToe hi = new UltimateTicTacToe();
        
        
        
        System.out.print("Player " + hi.getPlayer() + ", please make a move: ");
        str = sc.nextLine();
        indexOfComma=str.indexOf(",");
        while(indexOfComma==-1 || (Integer.parseInt(str.substring(0,indexOfComma))>2 || Integer.parseInt(str.substring(0,indexOfComma))<0)|| (Integer.parseInt(str.substring(indexOfComma+1))>2 || Integer.parseInt(str.substring(indexOfComma+1))<0))
        {
            System.out.print("Invalid move. Player " + hi.getPlayer() + ", please make a legal move: ");
            str=sc.nextLine();
            indexOfComma=str.indexOf(",");
        }
        row=Integer.parseInt(str.substring(0,indexOfComma));
        col=Integer.parseInt(str.substring(indexOfComma+1));
            
            
            
            
        while(hi.gameOver()==-1)
        {
            
            int player = hi.getPlayer();
            while(player == hi.getPlayer()){
                System.out.print("Player " + hi.getPlayer() + ", please choose a square: ");
                str2 = sc.nextLine();
                indexOfComma=str2.indexOf(",");
                while(indexOfComma==-1 || (Integer.parseInt(str2.substring(0,indexOfComma))>2 || Integer.parseInt(str2.substring(0,indexOfComma))<0)
                || (Integer.parseInt(str2.substring(indexOfComma+1))>2 || Integer.parseInt(str2.substring(indexOfComma+1))<0))
                {
                    System.out.print("Invalid move. Player " + hi.getPlayer() + ", please make a legal move: ");
                    str2=sc.nextLine();
                    indexOfComma=str2.indexOf(",");
                }
                row2=Integer.parseInt(str2.substring(0,indexOfComma));
                col2=Integer.parseInt(str2.substring(indexOfComma+1));
            
            
                hi.play(row,col,row2,col2);
                
            }
            
            row = row2;
            col = col2;
                
            if(hi.getUltBoard()[row][col].gameOver() == 0 || hi.getUltBoard()[row][col].gameOver() == 1 || hi.getUltBoard()[row][col].gameOver() == 2){
                System.out.print("Player " + hi.getPlayer() + ", please choose a tic tac toe board: ");
                str = sc.nextLine();
                indexOfComma=str.indexOf(",");
                while(indexOfComma==-1 || (Integer.parseInt(str.substring(0,indexOfComma))>2 || Integer.parseInt(str.substring(0,indexOfComma))<0)|| (Integer.parseInt(str.substring(indexOfComma+1))>2 || Integer.parseInt(str.substring(indexOfComma+1))<0))
                {
                    System.out.print("Invalid move. Player " + hi.getPlayer() + ", please make a legal move: ");
                    str=sc.nextLine();
                    indexOfComma=str.indexOf(",");
                }
                row=Integer.parseInt(str.substring(0,indexOfComma));
                col=Integer.parseInt(str.substring(indexOfComma+1));
            
            }
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
