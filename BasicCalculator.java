import java.util.*;

public class BasicCalculator {
	private static double firstNumber;
	private static double newNumber;
	private static char operation;

	static {
		//Welcome message
		System.out.println("------------------------------- ");
		System.out.println("WELCOME TO CODTECH IT SOLUTIONS ");
		System.out.println("------------------------------- ");
		System.out.println("BASIC CALCULATOR PROJECT ");
		System.out.println("------------------------ ");
	}
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			// Reading first number from the user
			while (true) {
				System.out.print("Enter First number : ");
				try {
					firstNumber = sc.nextDouble();
					break;
				} catch (InputMismatchException e) {
					System.err.println("ENTER ONLY NUMERIC VALUES");
					sc.next();
				}
			}

			//for further operations
			while (true) {
				
				//reading the character for suitable operation from the user
				while (true) {
					System.out.print("Choose one of the following Operations \n"
							+ "	'+' -> ADDITION\n"
							+ "	'-' -> SUBRACTION\n"
							+ "	'*' -> MULTIPLICATION\n"
							+ "	'/' -> DIVISION\n"
							+ "Enter the char for suitable Operation : ");
					
					operation = sc.next().charAt(0);
					if (operation == '+' || operation == '-' || operation == '*' || operation == '/') {
						break;
					} else
						System.err.println("INVALID OPERATION");
				}

				// Reading new number from the user
				while (true) {
					System.out.print("Enter Next Number : ");
					try {
						newNumber = sc.nextDouble();
						break;
					} catch (InputMismatchException e) {
						System.err.println("ENTER ONLY NUMERIC VALUES");
						sc.next();
					}
				}
				System.out.println("\nRESULT = " + performOperation()+"\n");

				System.out.print("Do you want to perform further operations (Y/N) : ");
				while (true) {
					char perform = sc.next().toUpperCase().charAt(0);
					System.out.println();
					if (perform == 'Y') {
						firstNumber = performOperation();
						System.out.println("-----------------------------------------------");
						break;
					} else if (perform == 'N') {
						System.out.println("Thank you. Have a Nice day!");
						return;
					} else {
						System.err.println("INVALID CHOICE");
					}
				}
			}
		}
	}

	public static double performOperation() {
		double result = 0;
		switch (operation) {
		case '+':
			result = firstNumber + newNumber;
			break;
		case '-':
			result = firstNumber - newNumber;
			break;
		case '*':
			result = firstNumber * newNumber;
			break;
		case '/':
			if(newNumber==0) {
				System.err.println("Cannot divide a number by zero");
			}
			result = firstNumber / newNumber;
			break;
		default:
			System.out.println("Invalid operation");
		}
		return result;
	}
}