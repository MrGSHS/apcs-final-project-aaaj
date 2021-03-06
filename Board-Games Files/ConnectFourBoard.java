
/**
 * 
 * @aAlbert and Alex
 * @1.0
 */
public class ConnectFourBoard implements BlankInARow
{
    private int [][] connectfour;
    private boolean [][] availableMoves;
    private int playerCount=0;
    /**
     * Constructor for objects of class ConnectFourBoard
     */
    public ConnectFourBoard()
    {
        connectfour=new int[6][7];
        availableMoves=new boolean[1][7];
    }
    //returns the player who made the move
    public int getPlayer()
    {
        return playerCount%2+1;
    }
    
    public int[][] getBoard()
    {
        return connectfour;
    }
    //makes the move onto the board, returns -1 if the column is full.
    public int play(int row, int col)
    {
        int playNumber = playerCount%2 + 1;
        availableMoves = availableMoves();
        if(availableMoves[0][col]==false)
        {
            return -1;
        }
        else
        {
            int index=5;
            while (index>=0 && connectfour[index][col]==0)
            {
                index--;
            }
            connectfour[index+1][col] = playNumber;
            playerCount++;
        }
        return playNumber;
    }
    //returns a boolean of the available moves
    public boolean[][] availableMoves()
    {
        for(int row = 0; row < connectfour.length; row++){
        for (int i=0; i<availableMoves[0].length; i++)
        {
            if (connectfour[row][i]==0)
                availableMoves[0][i]=true;
            else
                availableMoves[0][i]=false;
        }
    }
        return availableMoves;
    }
    //checks to see if someone wins, returns player # if so. Otherwise, returns -1 if moves can still be made,
    //or 0 if the game is a tie.
    public int gameOver()
    {
        //rows
        for (int row=0; row<connectfour.length; row++)
        {
            for (int col=0; col<connectfour[0].length-3; col++)
            {
                if (connectfour[row][col]==connectfour[row][col+1] && connectfour[row][col]==connectfour[row][col+2]
                &&  connectfour[row][col]==connectfour[row][col+3] && connectfour[row][col]!=0)
                    return connectfour[row][col];
            }
        }
        //columns
        for (int col=0; col<connectfour[0].length; col++)
        {
            for (int row=0; row<connectfour.length-3; row++)
            {
                if (connectfour[row][col]==connectfour[row+1][col] && connectfour[row][col]==connectfour[row+2][col]
                &&  connectfour[row][col]==connectfour[row+3][col] && connectfour[row][col]!=0)
                    return connectfour[row][col];
            }
        }

        for(int row = 0; row < connectfour.length-4; row++)
        {
            for (int col = 0; col < connectfour[0].length-3; col++)
            {
                if(connectfour[row][col]==connectfour[row+1][col+1] && connectfour[row][col]==connectfour[row+2][col+2]
                && connectfour[row][col]==connectfour[row+3][col+3] && connectfour[row][col]!=0)
                    return connectfour[row][col];                    
            }
        }
        for (int row=connectfour.length-1; row>2; row--)
        {
            for (int col=0; col<connectfour[0].length-3; col++)
            {
                if (connectfour[row][col]==connectfour[row-1][col+1] && connectfour[row][col]==connectfour[row-2][col+2]
                &&  connectfour[row][col]==connectfour[row-3][col+3] && connectfour[row][col]!=0)
                    return connectfour[row][col];
            }
        }
        for(int row = 0; row < connectfour.length; row++)
        {
            for (int col = 0; col < connectfour[0].length; col++)
            {
                if (connectfour[row][col] == 0)
                {
                    return -1;
                }
            }
        }
        return 0;
    }
}
