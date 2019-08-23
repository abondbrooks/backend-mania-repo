import java.text.NumberFormat;
import java.util.Scanner;

public class FutureValueApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the Future Value Calculator\n");
        Scanner sc = new Scanner(System.in);
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            // get the input from the user
            System.out.println("Enter monthly investment: ");
            double monthlyInvestment = sc.nextDouble();
            System.out.println("Enter yearly interest rate: ");
            double interestRate = sc.nextDouble();
            System.out.println("Enter number of years: ");
            int years = sc.nextInt();

            // convert yearly values to monthly values
            double monthlyInterestRate = interestRate / 12 / 100;
            int months = years * 12;

            // call the future value method
            double futureValue = calculateFutureValue(monthlyInvestment, monthlyInterestRate, months);

            // format and display the result
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            System.out.println("Future value: " + currency.format(futureValue));

            System.out.println();

            // see if the user want to continue
            System.out.println("Continue? (y/n): ");
            choice = sc.next();
            System.out.println();

        }
    }
        // a static method that requires 3 arguments and returns a double
    private static double calculateFutureValue(double monthlyInvestment, double monthlyInterestRate, int months) {
        double futureValue = 0.0;
        for (int i = 1; i <= months; i++) {
            futureValue = (futureValue + monthlyInvestment) * (1 + monthlyInterestRate);

        }
        return futureValue;
    }
}
