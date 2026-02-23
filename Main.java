/*

Guessing APP -Use Case 1 : Game Initialization


Thiss class acts as the apllication Entry point
It intializes the game configuration and display rules
No user input or game Play logic is implemented

@author : B.Sushma Sree
@version: 1

*/

import java.util.*;
public class Main 
{
   public static void main(String args[])
   {
	   System.out.println("Welcome To GUESSING APP ");
	   GameConfig game=new GameConfig();
	   game.showRules();
   }
}