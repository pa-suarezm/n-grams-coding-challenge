/**
 * This class is the main class (i.e. the program runs through the main method in this class)
 * 
 * @author Pablo Suarez (pa-suarezm)
 *
 */

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class NGrams
{

	/**
	 * Main method. Will take user input using the console and output through there also.
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in).useDelimiter("\n"); //Takes user input by reading from console (a.k.a. System.in)

		//Variables to be used on each iteration
		int menuOption = 0;
		String userInput = "";

		while(0 <= menuOption && menuOption <= 2) //Quits if the selected option is 3
		{
			printMenu();

			userInput = s.next().trim();

			try
			{
				menuOption = Integer.parseInt(userInput);
			}
			catch(Exception e)
			{
				printInvalidInput();
				
				//TODO erase - debug purposes
				e.printStackTrace();
				
				continue;
			}

			if(menuOption != 1 && menuOption != 2 && menuOption != 3)
			{
				printInvalidInput();
			}
			else
			{
				//Runs the program if the selected menu option is valid
				if(menuOption == 3)	//Program ends
				{
					break;
				}
				else if(menuOption == 1) //calculateNGrams
				{
					String msg =  "------------------------------------------\n"
							+ "Selected calculateNGrams.\n"
							+ "Please input the text to be analyzed:\n";
					System.out.println(msg);

					String text = s.next().trim();

					msg = "Please input the desired n-gram to be calculated (positive whole number):";
					System.out.println(msg);

					int n = -1;
					try
					{
						n = Integer.parseInt(s.next().trim());
					}
					catch(Exception e)
					{
						printInvalidParams();
						
						//TODO erase - debug purposes
						e.printStackTrace();
						
						continue;
					}

					if(n < 1)
					{
						printInvalidParams();
						continue;
					}
					
					List<String> ans = calculateNGrams(text, n);
					
					//TODO print results
				}
				else //mostFrequentNGram
				{
					String msg =  "------------------------------------------\n"
							+ "Selected mostFrequentNGram.\n"
							+ "Please input the text to be analyzed:\n";
					System.out.println(msg);

					String text = s.next().trim();

					msg = "Please input the desired n-gram to be evaluated (positive whole number):";
					System.out.println(msg);

					int n = -1;
					try
					{
						n = Integer.parseInt(s.next().trim());
					}
					catch(Exception e)
					{
						printInvalidParams();
						continue;
					}
					
					if(n < 1)
					{
						printInvalidParams();
						continue;
					}

					String ans = mostFrequentNGram(text, n);
					
					System.out.println("The most frequent " + n + "-gram for '" + text + "' is '" + ans + "'\n"
							+ "------------------------------------------\n\n");
				}
			}
		}

		s.close();
	}

	/**
	 * 
	 * @param text: String to be analyzed
	 * @param n: Indicates the n to be used in calculating the n-grams
	 * @return ans: The whole list of n-grams for the text
	 */
	private static List<String> calculateNGrams(String text, int n)
	{
		List<String> ans = new ArrayList<String>();

		String[] allChars = text.split("");
		
		if(n == 1)
		{
			for(int i = 0; i < allChars.length; i++)
				ans.add(allChars[i]);
		}
		else if(n >= allChars.length)
		{
			ans.add(text);
		}
		else
		{
			for(int i = 0; i < allChars.length-(n-1); i++)
			{
				String aux = "";
				
				int j = i;
				int cnt = 0;
				
				while(cnt < n)
				{
					aux += allChars[j];
					
					j++;
					cnt++;
				}
				
				ans.add(aux);
			}
		}
		
		return ans;
	}

	/**
	 * 
	 * @param text: String to be analyzed
	 * @param n: Indicates the n to be used in calculating the n-grams
	 * @return ans: The most frequent n-gram found in the calculated n-grams
	 */
	private static String mostFrequentNGram (String text, int n)
	{
		List<String> nGrams = calculateNGrams(text, n);
	
		String ans = nGrams.get(0);
		int maxActual = 0;
		
		String actual = "";
		int cnt = 0;
		
		for(int i = 0; i < nGrams.size(); i++)
		{
			actual = nGrams.get(i);
			cnt = 0;
			
			for(int j = i; j < nGrams.size(); j++)
			{
				if(actual.equals(nGrams.get(j)))
					cnt++;
			}
			
			if(cnt > maxActual)
			{
				maxActual = cnt;
				ans = actual;
			}
		}
		
		return ans;
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
				+ "Returning to main menu.\n"
				+ "--------------------------------\n\n");
	}

	private static void printInvalidParams()
	{
		System.out.println("--------------------------------\n"
				+ "Your input was not valid. This program expects positive whole numbers.\n"
				+ "Returning to main menu.\n"
				+ "--------------------------------\n\n");
	}

}
