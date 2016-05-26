
/**
 * Write a description of class TicTacToeBoard here.
 * 
 * @Andrew and Alex
 * @1.0
 */
public class TicTacToeBoard implements BlankInARow
{
    private int[][] tictactoe;
    private boolean[][] availableMoves;
    private static int playerCount;
    private int boardVal;
    
    //creates the board
    public TicTacToeBoard()
    {
        tictactoe = new int[3][3];
        availableMoves = new boolean [3][3];
        playerCount = 0;
        boardVal = -1;
        
    }

    
    
    public int[][] getBoard()
    {
        return tictactoe;
    }
    //returns the player
    public int getPlayer()
    {
        return playerCount%2 + 1;
    }
    //used for ultimate tic tac toe
    public int getBoardVal()
    {
        return boardVal;
    }
    //makes the move, returns -1 if the square is already filled
    public int play(int row, int col)
    {
        int playNumber = playerCount%2 + 1;
        availableMoves = availableMoves();
        if(availableMoves[row][col]==false)
        {
            return -1;
        }
        else
        {
            tictactoe[row][col] = playNumber;
            playerCount++;
        }
        boardVal = gameOver();
        return playNumber;
    }
    //alternate play method for ultimate tic tac toe
    public int play(int row, int col, int input)
    {
        availableMoves = availableMoves();
        if(availableMoves[row][col]==false)
        {
            return -1;
        }
        else
        {
            if(input == 1 || input == 2){
                tictactoe[row][col] = input;
            }
        }
        boardVal = gameOver();
        return -1000;
    }
    //returns the available moves
    public boolean[][] availableMoves()
    {
        for(int row=0; row<availableMoves.length; row++)
        {
            for(int col=0; col<availableMoves[0].length; col++)
            {
                if(tictactoe[row][col]==0)
                    availableMoves[row][col]=true;
                else
                    availableMoves[row][col]=false;
            }
        }
        return availableMoves;
    }
    //checks if there is a 3 in a row, returns the value of the winner. Otherwise, returns 0 if 
    //the game is a tie, and -1 if moves are still available.
    public int gameOver()
    {
        boolean a = true;
        
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
