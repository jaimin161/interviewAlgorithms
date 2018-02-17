package jaimin.interview.algorithms.ha;

import java.util.Scanner;

public class NumberToWordsConverter {
	
	// Creating a single shared Scanner for keyboard input
    private static Scanner scanner = new Scanner( System.in );
	
	public static void main(final String[] args) {

		System.out.print( "Type any number for the program: " );

		String inputNumber = scanner.nextLine();
		
		System.out.println(inputNumber + "='" + convert(Integer.parseInt(inputNumber)) + "'");

	}
	
	public static final String[] units = { "", "One", "Two", "Three", "Four", 
			"Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
			"Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };

	public static final String[] tens = { 
			"", 		// 0 index
			"",			// 1 index
			"Twenty", 	// 2 index
			"Thirty", 	// 3
			"Forty", 	// 4
			"Fifty", 	// 5
			"Sixty", 	// 6
			"Seventy",	// 7
			"Eighty", 	// 8
			"Ninety" 	// 9
	};
	
	public static String convert(final int n) {
		if (n < 0) {
			return "Minus " + convert(-n);
		}

		if (n < 20) {
			return units[n];
		}

		if (n < 100) {
			return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
		}

		if (n < 1000) {
			return units[n / 100] + " Hundred" + ((n % 100 != 0) ? " " : "") + convert(n % 100);
		}

		if (n < 100000) {
			return convert(n / 1000) + " Thousand" + ((n % 10000 != 0) ? " " : "") + convert(n % 1000);
		}

		if (n < 10000000) {
			return convert(n / 100000) + " Lakh" + ((n % 100000 != 0) ? " " : "") + convert(n % 100000);
		}

		return convert(n / 10000000) + " Crore" + ((n % 10000000 != 0) ? " " : "") + convert(n % 10000000);
	}

}
