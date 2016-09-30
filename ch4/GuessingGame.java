import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
	public static void main(String[] args) {
		System.out.println("The program has selected a random number between 0 and 9\nPlease guess what this number is: ");
		Scanner keyboard = new Scanner(System.in);
		int randomNumber = new Random().nextInt(10);
		int user_guess = 22;
		String string_guess = keyboard.next();
		while (user_guess != randomNumber)
		{
			if ((string_guess.length() == 1) && (Character.isDigit(string_guess.charAt(0))))
			{
				user_guess = Integer.parseInt(string_guess);
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
					System.out.println("Invalid guess. The number is between 0 and 9 (inclusive).");
			}
			else
				System.out.println("Invalid please enter a number not a letter.");
		} 
		if (user_guess == randomNumber)
			System.out.println("Correct!");

	}
}