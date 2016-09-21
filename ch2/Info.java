import java.util.Scanner;

public class Info
{
	public static void main(String[] args)
	{
		System.out.println("Please enter your name:");
		String name;
		Scanner keyboard = new Scanner(System.in);
		name = keyboard.nextLine();
		String[] array_of_subnames = name.split(" ");//created an array and populated with parts of "name" that are separated by whitespace.
		System.out.println("Your first name is " + array_of_subnames[0]);
		System.out.println("Your last name is " + array_of_subnames[1]);
		int n;
		n = 10;
		n++; //n is treated as 10 in this line of operations then incremented to 11
		System.out.println("n is " + n); // n is 11 and outputted as such
		n--;
		System.out.println("n is now " + n);
	}
}

/*public class Info
{
	public static void main(String[] args)
	{
		System.out.println("Please enter your name:");
		String name;
		Scanner keyboard = new Scanner(System.in);
		String first_name = keyboard.next();
		String last_name = keyboard.next();
		System.out.println("Your first name is " + first_name + " and your last name is " + last_name);
	}
}*/

/*public class Info 
{
	public static void main(String[] args)
	{
		System.out.println("Please enter your name:");
		String name;
		Scanner keyboard = new Scanner(System.in);
		name = keyboard.nextLine();
		int whitespace_index = name.substring(" ");
		String first_name = name.substring(0, whitespace_index); //begins at start of name and ends but not including index location of whitespace
		String last_name = name.substring(whitespace_index + 1); //begins at the next index after lcoation of whitespace
		System.out.println("Your first name is " + first_name + " and your last name is " + last_name);
	}
}*/