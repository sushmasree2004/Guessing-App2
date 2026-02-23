
import java.util.*;

class GameController
{
	
	public static boolean restartGame(Scanner sc)
	{
		System.out.print("Do YOU Want to Play Again ?? (YES/NO ):");
		return sc.nextLine().equalsIgnoreCase("YES");
		
		
	}
	
	
}