
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
    
    public int play(int rowUlt, int colUlt, int row, int col){
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

    public void updateBoardVals(){
        for(int row=0; row<ult.length; row++){
            for(int col=0; col<ult[0].length; row++){
                ultBoardVals.play(row, col, ult[row][col].getBoardVal());
            }
        }
    }
    
    public boolean[][] availableMoves(){
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
    
    public int gameOver(){
        updateBoardVals();
        if(ultBoardVals.gameOver()==-1){
            return -1;
        }
        
        int [][] boardVals = new int [3][3];
        
        for(int row=0; row<ult.length; row++){
            for(int col=0; col<ult[0].length; row++){
                boardVals[row][col] = ult[row][col].getBoardVal();
            }
        }
        
        for (int[] row : tictactoe)
        {
            if (row[0] == row[1] && row[0] == row[2] && row[0] != 0)
            {
                return row[0];
            }
            
        }
        
        for(int col = 0; col < tictactoe[0].length; col++)
        {
            int num1, num2, num3;
            num1 = tictactoe[0][col];
            num2 = tictactoe[1][col];
            num3 = tictactoe[2][col];
            if (num1 == num2 && num1 == num3 && num1 != 0)
            {
                return num1;
            }
        }
        
        
        if(tictactoe[0][0]!=0 && tictactoe[0][0]==tictactoe[1][1] && tictactoe[0][0]==tictactoe[2][2])
        {
            return tictactoe[0][0];
        }
        if(tictactoe[2][0]!=0 && tictactoe[2][0]==tictactoe[1][1] && tictactoe[2][0]==tictactoe[0][2])
        {
            return tictactoe[2][0];
        }
        
        for(int row = 0; row < tictactoe.length; row++)
        {
            for (int col = 0; col < tictactoe[0].length; col++)
            {
                if (tictactoe [row][col] == 0)
                {
                    return -1;
                }
            }
        }

        return 0;
    }
}
