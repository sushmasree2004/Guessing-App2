import java.io.*;

class StorageService 
{
    public static void saveResult(String player, int attempts, boolean win) 
	{
        try (BufferedWriter wr = new BufferedWriter(new FileWriter("game_results.txt", true))) 
		{
            wr.write("Player: " + player + 
			" , Attempts: " + attempts + 
			" , Result: " + (win ? "WIN" : "LOSE"));
			
            wr.newLine();
        } 
		catch (IOException e) 
		{
            System.out.println("Unable to Save Game Result.");
        }
    }
}
