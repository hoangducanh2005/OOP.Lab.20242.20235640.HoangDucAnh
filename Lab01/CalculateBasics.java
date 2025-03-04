import java.util.Scanner;

public class CalculateBasics{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter 1st num: ");
        	double num1 = scanner.nextDouble();
		System.out.print("Enter 2nd num: ");
        	double num2 = scanner.nextDouble();
		
		//calculate
		double sum= num1 +num2;
		double difference= 	num1-num2;
		double product = num1*num2;
		double quotient = num1/num2;
		System.out.println("Sum: " + sum);
        	System.out.println("Difference: " + difference);
        	System.out.println("Product: " + product);
		System.out.println("Quotient: " + quotient);
		scanner.close();
	}
}
		

	

