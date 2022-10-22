package app;

import java.util.Scanner;

public class CashRegister {
	public static void main(String[] args) {
		System.out.println("Welcome to the register!");
		ringUp();
		System.out.println("Thank you have a good day!");
	}

	private static void ringUp() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter cost of items:");
		double cost = scanner.nextDouble();
		System.out.println("Please enter amount tendered by customer:");
		double tender = scanner.nextDouble();
		// take first two integers and convert cents into integers
		// and store them in perspective variable
		int dollarCost = (int) cost;
		int centCost = (int) (.1 + (cost - dollarCost) * 100);
		int dollarTender = (int) tender;
		int centTender = (int) ((tender - dollarTender) * 100);
		payEnough(dollarCost, centCost, dollarTender, centTender);
		scanner.close();
	}

	private static void payEnough(int dollarCost, int centCost, int dollarTender, int centTender) {
		Scanner scanner = new Scanner(System.in);
		// if they don't pay enough
		if (dollarCost > dollarTender || ((dollarCost >= dollarTender) && (centCost > centTender))) {
			System.out.println("Not enough please ask customer to tender more money");
			System.out.println("And lets try that again");
			ringUp();
		} // if they pay exact
		else if ((dollarCost == dollarTender) && (centCost == centTender)) {
			System.out.println("Exact amount tendered.");
			System.out.println("Smile and thank customer.");

		} // if they pay too much
		else {
			int dollarChange = dollarTender - dollarCost;
			int centChange = centTender - centCost;
			// carry the one if we need to use a dollar to cover the cents
			if (centChange < 0) {
				centChange += 100;
				dollarChange -= 1;
			}
			change(dollarChange, centChange);
		}
		scanner.close();
	}

	private static void change(int dollarChange, int centChange) {
// this method uses recursion to move through data and print corresponding change.
		if (dollarChange >= 50) {
			System.out.println("Sorry we don't make change of $50 or greater");
			System.out.println("Lets try that again");
			ringUp();
		} else if (dollarChange >= 20) {
			// if change is 40 or more give 2 $20
			if (!(dollarChange < 40)) {
				System.out.print("2 $20 bills");
				dollarChange -= 40;
			} // if change is more than $20 give 1 $20
			else {
				System.out.println("1 $20 bill");
				dollarChange -= 20;
			}
			change(dollarChange, centChange);
		} else if (dollarChange >= 10) {
			System.out.print(" 1 $10 bill");
			dollarChange -= 10;
			change(dollarChange, centChange);
		} else if (dollarChange >= 5) {
			System.out.print(" 1 $5 bill");
			dollarChange -= 5;
			change(dollarChange, centChange);
		} else if (dollarChange >= 1) {
			// when 4 bills required
			if (dollarChange >= 4) {
				System.out.print(" 4 $1 bills");
				dollarChange -= 4;
			} // when 3 bills required
			else if (dollarChange >= 3) {
				System.out.print(" 3 $1 bills");
				dollarChange -= 3;
			} // when 2 bills required
			else if (dollarChange >= 2) {
				System.out.print(" 2 $1 bills");
				dollarChange -= 2;
			} // when 1 bill required
			else {
				System.out.print(" 1 $1 bill");
				dollarChange -= 1;
			}
			change(dollarChange, centChange);
		} else if (centChange >= 25) {
			// when 3 quarters required
			if (centChange >= 75) {
				System.out.print(" 3 Quarters");
				centChange -= 75;
			} // when 2 quarters required
			else if (centChange >= 50) {
				System.out.print(" 2 Quarters");
				centChange -= 50;
			} // when 1 quarters required
			else {
				System.out.print(" 1 Quarter");
				centChange -= 25;
			}
			change(dollarChange, centChange);
		} else if (centChange >= 10) {
			// if change is .2 or more give 2 dimes
			String pr = (!(centChange < 20)) ? " 2 dimes" : " 1 dime";
			centChange -= (!(centChange < 20)) ? 20 : 10;
			System.out.print(pr);
			change(dollarChange, centChange);
		} else if (centChange >= 5) {
			System.out.print(" 1 nickle");
			centChange -= 5;
			change(dollarChange, centChange);
		} else if (centChange >= 1) {
			// when 4 pennies required
			if (centChange >= 4) {
				System.out.print(" 4 pennies");
				centChange -= 4;
			}
			// when 3 pennies required
			else if (centChange >= 3) {
				System.out.print(" 3 pennies");
				centChange -= 3;
			}
			// when 2 pennies required
			else if (centChange >= 2) {
				System.out.print(" 2 pennies");
				centChange -= 2;
			}
			// when 1 penny required
			else if (centChange >= 1) {
				System.out.print(" 1 penny");
				centChange -= 1;
			} else {
				centChange = 0;
			}
			change(dollarChange, centChange);
		} else {
			System.out.println(".");

		}
	}
}
