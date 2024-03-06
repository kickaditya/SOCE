import java.util.Scanner;

public class getConsoleInputExample {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String s = input.nextLine();
		System.out.println("Your Name is " + s);
		System.out.print("Enter Your Roll Number: ");
		int a = input.nextInt();
		System.out.println("Your Roll Number is " + a);
		System.out.println("Eenter the value of Pi in decimal: ");
		float b = input.nextFloat();
		System.out.println("The value of Pi in decimal is " + b);
}
}