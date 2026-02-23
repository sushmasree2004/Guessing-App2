import java.util.Scanner;

public class Main 
{
    public static void main(String args[]) throws InvalidInputException 
    {
        System.out.println("Welcome To GUESSING APP ");

        GameConfig game = new GameConfig();
        game.showRules();

        Scanner sc = new Scanner(System.in);
        int attempts = 0;

        while (attempts < game.getMax_Attempts()) 
        {
            System.out.print("Enter Your Guess : ");

            int guess = ValidationService.validateInput(sc.nextLine());
            attempts++;

            String result = GuessValidator.validateGuess(guess, game.getTargetNumber());
            System.out.println(result);

            if (" CORRECT ".equals(result)) 
            {
                break;
            }

            if (!" CORRECT ".equals(result)) 
            {
                if (attempts <= game.getMax_Hints()) 
                {
                    System.out.println(HintService.generateHint(game.getTargetNumber(), attempts));
                }
            }
        }

    }
}
