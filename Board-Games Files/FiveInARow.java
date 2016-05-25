/**
 * Write a description of class FiveInARow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FiveInARow implements BlankInARow
{
    private int[][] fiveInARow;
    private boolean[][] availableMoves;
    private int playerCount;

    
    public FiveInARow()
    {
        fiveInARow = new int[19][19];
        availableMoves = new boolean[19][19];
        playerCount = 0;
        for (int row = 0; row < fiveInARow.length; row++)
        {
            for (int col = 0; col < fiveInARow[0].length; col++)
            {
                fiveInARow[row][col] = 0;
            }
        }
        
    }
    
    public int[][] getBoard()
    {
        return fiveInARow;
    }
    
    public int numInARow()
    {
        return 5;
    }
    
    public int getPlayer()
    {
        return playerCount%2 + 1;
    }
    
    public int getWinner()
    {
        return (playerCount - 1) % 2 + 1;
    }

    public int play(int row, int col)
    {
        int playNumber = playerCount % 2 + 1;
        availableMoves = availableMoves();
        if(availableMoves[row][col] == false)
        {
            return -1;
        }
        else
        {
            fiveInARow[row][col] = playNumber;
            playerCount++;
        }
        
        return playNumber;
    }
    
    public boolean[][] availableMoves()
    {
        for(int row=0; row<availableMoves.length; row++)
        {
            for(int col=0; col<availableMoves[0].length; col++)
            {
                if(fiveInARow[row][col]==0)
                    availableMoves[row][col]=true;
                else
                    availableMoves[row][col]=false;
            }
        }
        return availableMoves;
    }
    
    public int gameOver()
    {
        // checking for a win horizontally
        for (int row = 0; row < fiveInARow.length; row++)
        {
            for(int col = 0; col < fiveInARow[0].length - 4; col++)
            {
                if(fiveInARow[row][col] != 0 && fiveInARow[row][col] == fiveInARow[row][col+1]
                && fiveInARow[row][col] == fiveInARow[row][col+2] && 
                fiveInARow[row][col] == fiveInARow[row][col+3] && 
                fiveInARow[row][col] == fiveInARow[row][col+4])
                {
                    return fiveInARow[row][col];
                }
            }
        }
        
        // checking for a win vertically
        for (int row = 0; row < fiveInARow.length-4; row++)
        {
            for(int col = 0; col < fiveInARow[0].length; col++)
            {
                if(fiveInARow[row][col] != 0 && fiveInARow[row][col] == fiveInARow[row+1][col]
                && fiveInARow[row][col] == fiveInARow[row+2][col] && 
                fiveInARow[row][col] == fiveInARow[row+3][col] && 
                fiveInARow[row][col] == fiveInARow[row+4][col])
                {
                    return fiveInARow[row][col];
                }
            }
        }
        
        // checking for a win diagonally down to the right
        for (int row = 0; row < fiveInARow.length-4; row++)
        {
            for(int col = 0; col < fiveInARow[0].length-4; col++)
            {
                if(fiveInARow[row][col] != 0 && fiveInARow[row][col] == fiveInARow[row+1][col+1]
                && fiveInARow[row][col] == fiveInARow[row+2][col+2] && 
                fiveInARow[row][col] == fiveInARow[row+3][col+3] && 
                fiveInARow[row][col] == fiveInARow[row+4][col+4])
                {
                    return fiveInARow[row][col];
                }
            }
        }
        
        // checking for a win diagonally down to the left
        for (int row = 0; row < fiveInARow.length-4; row++)
        {
            for(int col = 4; col < fiveInARow[0].length; col++)
            {
                if(fiveInARow[row][col] != 0 && fiveInARow[row][col] == fiveInARow[row+1][col-1]
                && fiveInARow[row][col] == fiveInARow[row+2][col-2] && 
                fiveInARow[row][col] == fiveInARow[row+3][col-3] && 
                fiveInARow[row][col] == fiveInARow[row+4][col-4])
                {
                    return fiveInARow[row][col];
                }
            }
        }
        
        for (int[] row : fiveInARow)
        {
            for (int col = 0; col < fiveInARow[0].length; col++)
            {
                if (row[col] == 0)
                {
                    return -1;
                }
               
            }
        }
        
        // if there is a tie
        return 0;
        
    }
     
}