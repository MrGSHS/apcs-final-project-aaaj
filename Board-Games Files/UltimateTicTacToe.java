
/**
 * Write a description of class UltimateTicTacToe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UltimateTicTacToe extends TicTacToeBoard
{
    private TicTacToeBoard [][] ult;
    private TicTacToeBoard ultBoardVals;
    private boolean [][]availableMoves;
    private int playNumber;
    
    public UltimateTicTacToe(){
        ultBoardVals = new TicTacToeBoard();
        ult = new TicTacToeBoard [3][3];
        playNumber = 1;
    }
    
    public int play(int rowUlt, int colUlt, int row, int col)
    {
        availableMoves = availableMoves();
        if(availableMoves[rowUlt][colUlt]==false)
        {
            return -1;
        }
        else
        {
            if((ult[rowUlt][colUlt].availableMoves())[row][col]==false){
                return -1;
            }
            else{
                ((ult[rowUlt][colUlt]).getBoard())[row][col] = playNumber;
                playNumber++;
            }
        }
        return playNumber;
        
    }

    public boolean[][] availableMoves()
    {
        for(int row=0; row<availableMoves.length; row++)
        {
            for(int col=0; col<availableMoves[0].length; col++)
            {
                if(ult[row][col].getBoardVal()==-1)
                    availableMoves[row][col]=true;
                else
                    availableMoves[row][col]=false;
            }
        }
        return availableMoves;
    }
}
