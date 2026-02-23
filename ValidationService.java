class ValidationService
{
	public static int validateInput(String input) throws InvalidInputException
	{
		try
		{
			int val=Integer.parseInt(input);
			if(val<1 || val>100)
			{
				throw new InvalidInputException("Number must be between 1 and 100");
			}
			
			
			return val;
		}
		
		catch(NumberFormatException e)
		{
			throw new InvalidInputException("Invalid inout .Please enter numbers only ..");
		}
		
	}
	
	
	
}

class InvalidInputException extends Exception
{
    public InvalidInputException(String message) 
	{
        super(message);
    }
}
