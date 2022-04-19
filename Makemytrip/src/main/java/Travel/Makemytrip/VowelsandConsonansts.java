package Travel.Makemytrip;

public class VowelsandConsonansts {
	
	
	
	public static void checkforVowelandConsonants(Character input)
	{
		if(input.equals(""))
		{
			System.out.println("Entered character is invalid");
		}
		
		
			
		
		else if(input=='a' || input=='e' || input=='i' || input=='o' || input=='u' )
		{
			System.out.println("Entered character is vowel");
		}
		else
		{
			System.out.println("Entered character is conconant");
		}
	}
	
	public static void main(String[] args)
	{
		checkforVowelandConsonants('a');
	}

}
