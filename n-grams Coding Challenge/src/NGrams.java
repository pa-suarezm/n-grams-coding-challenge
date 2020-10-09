/**
 * This class is the main class (i.e. the program runs through the main method in this class)
 * 
 * @author Pablo Suarez (pa-suarezm)
 *
 */

import java.util.Scanner;

public class NGrams
{
	
	/**
	 * Main method. Will take user input using the console and output through there also.
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);			//Takes user input by reading from console (a.k.a. System.in)
		int menuOption = 0;
		String userInput = "";
		
		while(0 <= menuOption && menuOption <= 2) //Quits if the selected option is 3
		{
			printMenu();
			
			userInput = s.next();
			
			try
			{
				menuOption = Integer.parseInt(userInput);
			}
			catch(Exception e)
			{
				printInvalidInput();
				continue;
			}
			
			if(menuOption != 1 || menuOption != 2 || menuOption != 3)
			{
				printInvalidInput();
			}
			else
			{
				//Runs the program if the selected menu option is valid
				if(menuOption == 3)	//Program ends
					break;
				else if(menuOption == 1) //calculateNGrams
				{
					
				}
				else //mostFrequentNGram
				{
					
				}
			}
		}
	}

	private static void calculateNGrams(String text, int n)
	{
		
	}
	
	private static void mostFrequentNGram (String text, int n)
	{
		
	}
	
	/**
	 * Prints the menu the user will interact with
	 */
	private static void printMenu()
	{
		String menu = "====================================================\n"
					+ "-----------------------N-grams----------------------\n"
					+ "====================================================\n\n"
					+ "Please press the number for the function you want and 'enter'\n"
					+ "You'll be prompted to enter the needed parameters for each function.\n\n"
					+ "1. calculateNGrams: Will ask for a text and a whole number n, and then will return all n-grams for\n"
					+ "that text\n"
					+ "2. mostFrequentNGram: Will ask for a text and a whole number n, and then will return only the most\n"
					+ "frequent item of the n-grams for that text\n"
					+ "3. Exit program";
		System.out.println(menu);	//It's far more efficient to write on console once instead of doing it once per line
	}
	
	/**
	 * Error message if the selected option is not valid
	 */
	private static void printInvalidInput()
	{
		System.out.println("--------------------------------\n"
				+ "Your input was not valid. This program expects either 1, 2, or 3.\n"
				+ "--------------------------------\n\n");
	}
	
}
