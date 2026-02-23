import java.util.*;
import java.lang.*;


import java.io.*;


public class Main 
{
    public static void main(String args[]) 
	{
        Scanner sc = new Scanner(System.in);

        boolean playAgain = true;

        while (playAgain) 
		{
            System.out.println("Welcome To GUESSING APP ");
			
            GameConfig game = new GameConfig();
            game.showRules();

            System.out.print("Enter your name: ");
            String player = sc.nextLine();

            int attempts = 0;
            boolean win = false;

            while (attempts < game.getMax_Attempts()) 
			{
                System.out.print("Enter Your Guess : ");
                try 
				{
                    int guess = ValidationService.validateInput(sc.nextLine());
                    attempts++;

                    String result = GuessValidator.validateGuess(guess, game.getTargetNumber());
                    System.out.println(result);

                    if (" CORRECT ".equals(result)) 
					{
                        win = true;
                        break;
                    } 
					else 
					{
                        if (attempts <= game.getMax_Hints()) 
						{
                            System.out.println(HintService.generateHint(game.getTargetNumber(), attempts));
                        }
                    }
                } 
				
				catch (InvalidInputException e) 
				{
                    System.out.println(e.getMessage());
                }
            }

            StorageService.saveResult(player, attempts, win);
            System.out.println("Game result saved to game_results.txt");

            
            playAgain = GameController.restartGame(sc);
        }

        System.out.println("Thanks for playing");
    }
}
