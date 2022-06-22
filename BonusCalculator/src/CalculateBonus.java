import java.util.Scanner;

public class CalculateBonus {
	private static final double BONUS_RATE = 0.16;
	
	/**
	 * primary method too be used for the batch processing of bonus calculations
	 * @param x - first command line argument
	 * @param y - second command line argument
	 */
	private static void bonusCalculationPrimary(String x, String y) {
		try {
			double salary = Double.valueOf(x) ; // use first command line argument as the salary
			double bonusRate = Double.valueOf(y) ; // uses second command line argument as the bonus rate.
			double bonusAmount = salary * bonusRate;
			System.out.printf("Salary: %.2f, ", salary );	
			System.out.printf("Bonus: %.2f, ", bonusAmount );
			System.out.printf("Total: %.2f, ", (salary+bonusAmount));	

			
		} catch (Exception e) {
			throw new IllegalArgumentException("you have entered the wrong number of arguments or invalid arguments");
			//catches all errors that may be thrown 
		}
	}
	/**
	 * acts as a backup method in case batch processing fails still allows for manual input via ui if necessary
	 */
	private static void bonusCalculationSecondary() {
		try {
			Scanner in = new Scanner (System.in);
			System.out.println("Enter the annual salary: ");
			double salary = in.nextDouble();
			double bonusAmount = salary * BONUS_RATE;
			System.out.printf("Salary: %.2f, ", salary );	
			System.out.printf("Bonus: %.2f, ", bonusAmount );
			System.out.printf("Total: %.2f, ", (salary+bonusAmount));

			in.close();//closes the scanner (extra wasnt part of the requirements but it was left open in previous iteration.
		} catch (Exception e) {
			throw new IllegalArgumentException("you have entered the wrong value for input or invalid input");
		}
		
	}
	
	
	public static void main(String[] args)   {
	
	
		if(args.length == 2) //checks if any command line arguments have been provided
		{
			bonusCalculationPrimary(args[0], args[1]);

		}
		else {
			bonusCalculationSecondary();
		}
	}
}
