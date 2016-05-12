
/**
 * Write a description of class TicTacToeBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TicTacToeBoard implements BlankInARow
{
    private int[][] tictactoe;
    private boolean[][] availableMoves;
    private static int playerCount;
    private int boardVal;

    public TicTacToeBoard()
    {
        tictactoe = new int[3][3];
        availableMoves = new boolean [3][3];
        playerCount = 0;
        boardVal = -1;
        for (int row = 0; row < tictactoe.length; row++)
        {
            for (int col = 0; col < tictactoe[0].length; col++)
            {
                tictactoe[row][col] = 0;
            }
        }

    }

    public int[][] getBoard()
    {
        return tictactoe;
    }
    
    public int numInARow()
    {
        return tictactoe.length;
    }

    public int getPlayer()
    {
        return playerCount%2 + 1;
    }
    
    public int getBoardVal()
    {
        return boardVal;
    }
    
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
