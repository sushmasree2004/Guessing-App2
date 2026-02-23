
import java.util.*;

public class Main 
{
    public static void main(String args[]) 
	{
        System.out.println("Welcome To GUESSING APP ");
		
        GameConfig game = new GameConfig();
        game.showRules();

        Scanner sc = new Scanner(System.in);
		
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
    }
}
