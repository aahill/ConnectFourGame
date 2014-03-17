package connectfour;
import mediacomp.Picture;
import mediacomp.Pixel;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * Class to allow a user to play Connect Four. 
 * Uses the PlayConnectFour and Referee classes.
 * @author Aaron Hill
 */
public class ConnectFour
{
  //------------------------FIELDS----------------------------------
  private int [][] grid;
  private Picture display;
  private static final Color [] CHECKER_COLORS = {Color.GRAY, Color.RED, Color.BLACK};
  private Referee ref;
  //-------------------------CONSTRUCTORS----------------------------------------
  /**
   * Constructor to initialize the grid array, and board for the game
   * 
   **/
  public ConnectFour()
  {    
    //creates a new grid, display and referee
    grid = new int [7][6];
    ref = new Referee(grid);
    display = new Picture (700, 600);
    //defines the target pixel
    Pixel targetPixel;
    //initializes the graphics
    Graphics graphics = display.getGraphics();
    //creates yellow background by looping through display pixels
    for ( int x=0; x < display.getWidth(); x++)
    {
      for (int y=0; y < display.getHeight(); y++)
      {
        targetPixel = display.getPixel(x, y);
        //divisible X and Y check to see if x and y are 
        //divisible by 100, which is where the circles are to be drawn
        int divisibleX = x % 100;
        int divisibleY = y % 100;
        targetPixel.setColor(Color.YELLOW);
      }
    }
    //for loop to create gray circles
    for ( int x=0; x < display.getWidth(); x++)
    {
      for (int y=0; y < display.getHeight(); y++)
      {
        int divisibleX = x % 100;
        int divisibleY = y % 100;
        //if pixel's x and y is divisble by 100, draw gray circle
        if ((divisibleX == 0) & (divisibleY == 0)) 
        {       
          //creates circles inside of created grid
          graphics.setColor(CHECKER_COLORS [0]);
          graphics.drawOval((1+x)*100,(1+y)*100,71,71);
          graphics.fillOval(x,y,70,70);
        }     
      }
    }   
    display.show();
  }
  //-------------------------METHODS---------------------//
  /**
   * Updates the display picture (based the grid) and repaints it
   * */
    public void updateDisplay()
     {   
    Graphics graphics = display.getGraphics();   
    //loops through grid array and draws circles with grid coordinates multiplied by 100
    for (int columnX = 0; columnX < 7; columnX++)
    {
      for (int columnY = 0; columnY < 6; columnY++)
      {
        //if grid index is equal to 1, paint circle at grid coordinates multiplied by 100 with
        //color CHECKER_COLORS [1], in this case red
        if (grid [columnX][columnY] == 1)
        {
          graphics.setColor(CHECKER_COLORS [1]);
          graphics.drawOval(((columnX) * 100),((columnY) * 100),70,70);
          graphics.fillOval(((columnX) * 100),((columnY) * 100),70,70);
        }
        //if grid index is equal to 1, paint circle at grid coordinates multiplied by 100 with
        //color CHECKER_COLORS [], in this case grey
        if(grid [columnX][columnY] ==0)
        {
          graphics.setColor(CHECKER_COLORS[0]);
          graphics.drawOval(((columnX) * 100),((columnY) * 100),70,70);
          graphics.fillOval(((columnX) * 100),((columnY) * 100),70,70);
        }
        //else if grid index is equal to 1, paint circle at grid coordinates multiplied by 100 with
        //color CHECKER_COLORS [2], in this case black
        else if(grid [columnX][columnY] == 2)
        {
          graphics.setColor(CHECKER_COLORS[2]);
          graphics.drawOval((( columnX) * 100),((columnY) * 100),70,70);
          graphics.fillOval(((columnX) * 100),((columnY) * 100),70,70);
        } 
      }
    }
    //repaints the grid
    display.repaint();
  }
  /**
   * simulates the dropping of a checker by changing the value of the grid [x][y]:
   * where x = the specified column, and y = the largest y value that is unocupied by an
   * integer greater then 0. the given coordinate is changed to [player]
   * @param column, the x coordinate of the grid, which is the column chosen by the player.
   * @param player, the player who's checker is being dropped
   * */
  public void dropChecker(int column, int player)
  {
    //use of for loop to drop a checker in 'column' by checking grid values to find open slot
    // columnPosition represents the first spot of the column to be checked
    // droppedChecker checks to see if a checker has been dropped arleady
    //loops by begining at lost spot of column and going up. 
    for (int columnPosition = 5, droppedChecker = 0; columnPosition > 1; columnPosition--)
    {
      //if the value at the given grid point and the droppedChecker are equal to 0, change the
      //data value
      if ((grid[column][columnPosition] == 0) && droppedChecker == 0)
      {
        grid[column][columnPosition] = player;
        droppedChecker = 1;        
      }
    }
     updateDisplay();
  }
  /**
   * returns the integer winner from the referee
   * */
  public int getWinner()
  {
    return ref.getWinner();
  }
  /**
   * simulates an opponent by having the computer choose a number between 0 and 6
   * and then calling it on the dropChecker method
   * */
  public void opponentMove()
  {
    Random rand = new Random();
    int randNum = rand.nextInt(7);
    dropChecker(randNum, 2);
  }  
 
}