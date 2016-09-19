import java.util.Scanner;

public class Average
{
	public static void main(String[] args)
	{
		System.out.println("Enter the first number:");
		int num1, num2, num3;
		Scanner keyboard = new Scanner(System.in);
		num1 = keyboard.nextInt();
		System.out.println("Enter the second number:");
		num2 = keyboard.nextInt();
		System.out.println("Enter the third number:");
		num3 = keyboard.nextInt();
		System.out.println("The average of " + num1 + ", " + num2 + ", " + num3 + " is " + ((num1 + num2 + num3) / 3));
	}
}