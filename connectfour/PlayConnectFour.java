/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connectfour;

import java.util.*;

/**
 * Class to allow a user to play Connect Four.
 * Uses the ConnectFour class.
 * @author Benjamin Carle
 */
public class PlayConnectFour
{

  /**
   * Main method to take user input for each
   * turn and interface with ConnectFour.
   */
  public static void main(String[] args)
  {
    // Create the game object
    ConnectFour cf = new ConnectFour();
    // Use the scanner to take input from the user
    Scanner sc = new Scanner(System.in);
    int column;
    int winner = 0;
    while(winner == 0) {
      System.out.print("Column:  ");
      column = sc.nextInt() - 1;
      cf.dropChecker(column, 1);
      if((winner = cf.getWinner()) == 0) {
        cf.opponentMove();
        winner = cf.getWinner();
      }
    }
    // Game over, display the result
    if(winner == 1)
      System.out.println("Player 1 Wins!");
    else if(winner == 2)
      System.out.println("Player 2 Wins!");
    else if(winner == 3)
      System.out.println("Draw!");
    else
      System.out.println("No Winner");    
  }
}
