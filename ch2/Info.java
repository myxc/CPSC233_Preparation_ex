import java.util.Scanner;

public class Info
{
	public static void main(String[] args)
	{
		System.out.println("Please enter your name:");
		String name;
		Scanner keyboard = new Scanner(System.in);
		name = keyboard.nextLine();
		String[] subname = name.split(" ");
		System.out.println("Your first name is " + subname[0]);
		System.out.println("Your last name is " + subname[1]);
	}
}