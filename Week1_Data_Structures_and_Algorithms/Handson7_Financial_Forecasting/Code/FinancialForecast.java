import java.util.*;
public class FinancialForecast {

    // Recursive method to calculate future value
    public static double forecast(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return forecast(currentValue, growthRate, years - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter initial investment: ");
        double initialValue = sc.nextDouble();   // Starting investment
        System.out.print("Enter annual growth rate: ");
        double annualGrowthRate = sc.nextDouble(); // annual growth
        System.out.print("Enter number of years: ");
        int years = sc.nextInt();

        double futureValue = forecast(initialValue, annualGrowthRate, years);
        System.out.println("Predicted value after " + years + " years: " + futureValue);
        sc.close();
    }
}
