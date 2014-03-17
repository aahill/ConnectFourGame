/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connectfour;

/**
 * Class to referee a game of connect four.  
 * @author Benjamin Carle
 */
public class Referee
{
  //--//--//--//--// Fields //--//--//--//--//
  
  // The game grid
  private int [][] grid;
  
  //--//--//--//--// Constructors //--//--//--//--//

  /**
   * Constructor to setup a referee with a game grid.
   * @param grid the game grid
   */
  public Referee(int [][] grid)
  {
    this.grid = grid;
  }

  //--//--//--//--// Methods //--//--//--//--//

  /**
   * Method to check whether a location in the grid is
   * occupied by a player.
   * @param x the x coordinate
   * @param y the y coordinate
   * @param player the player to check
   * @return true if player occupies location (x,y), false otherwise
   */
  private boolean isMatch(int x, int y, int player)
  {
    if(x < 0 || y < 0 || x >=7 || y >= 6)
      return false;
    return grid[x][y] == player;
  }
  
  /**
   * Method to find if the game is over and who won.
   * @return 1 if player 1 is the winner
   *         2 if player 2 is the winner
   *         3 if the game is a draw
   *         0 if the game is not finished
   */
  public int getWinner()
  {
    int draw = 3;
    for(int y = 0; y < 6; y++) {
      for(int x = 0; x < 7; x++) {
        if(grid[x][y] != 0) {
          if(isMatch(x+1, y, grid[x][y]) && 
             isMatch(x+2, y, grid[x][y]) && 
             isMatch(x+3, y, grid[x][y]) )
            return grid[x][y];
          if(isMatch(x, y+1, grid[x][y]) && 
             isMatch(x, y+2, grid[x][y]) && 
             isMatch(x, y+3, grid[x][y]) )
            return grid[x][y];
          if(isMatch(x+1, y+1, grid[x][y]) && 
             isMatch(x+2, y+2, grid[x][y]) && 
             isMatch(x+3, y+3, grid[x][y]) )
            return grid[x][y];
          if(isMatch(x+1, y-1, grid[x][y]) && 
             isMatch(x+2, y-2, grid[x][y]) && 
             isMatch(x+3, y-3, grid[x][y]) )
            return grid[x][y];
        } else {
          draw = 0;
        }
      }
    }
    return draw;
  }
}