import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
	public static void main(String[] args) {
		System.out.println("The program has selected a random number between 0 and 9\nPlease guess what this number is: ");
		Scanner keyboard = new Scanner(System.in);
		int randomNumber = new Random().nextInt(10);
		int user_guess = 22;
		String string_guess = keyboard.next();
		int counter = 1;
		while ((user_guess != randomNumber) && (counter != 5)) 
		{
			if ((string_guess.length() == 1) && (Character.isDigit(string_guess.charAt(0)))) //entry is only 1 character, and that character is a digit.
			{
				user_guess = Integer.parseInt(string_guess); //parse string to get the number
				if ((0 <= user_guess) && (user_guess <= 9))
				{
					if (user_guess < randomNumber) {
						System.out.println("Your guess is too low, guess again: ");
						string_guess = keyboard.next();
					}
					else if (user_guess > randomNumber) {
						System.out.println("Your guess is too high, guess again: ");
						string_guess = keyboard.next();
					}
				}
				else
					{System.out.println("Invalid guess. The number is between 0 and 9 (inclusive).");
					string_guess = keyboard.next();
					}
			}
			else
				{System.out.println("Invalid please enter a number not a letter.");
				string_guess = keyboard.next();
				}
				counter ++;
		} 
		if (user_guess == randomNumber)
			System.out.println("Correct!");
		else
			System.out.println("Your 5 chances are up.");

	}
}