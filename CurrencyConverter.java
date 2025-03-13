import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            double eurRate = 0.85;
            double inrRate = 74.5;
            double gbpRate = 0.73;
            double jpyRate = 110.0;
            
            
            System.out.println("Choose the base currency:");
            System.out.println("1 - USD (Currently supported)");
            int baseCurrency = scanner.nextInt();
            
            System.out.println("Select the currency you want to convert to:");
            System.out.println("1 - EUR (Euro)");
            System.out.println("2 - INR (Indian Rupee)");
            System.out.println("3 - GBP (British Pound)");
            System.out.println("4 - JPY (Japanese Yen)");
            int targetCurrency = scanner.nextInt();
            
            
            System.out.print("Enter the amount: ");
            double amount = scanner.nextDouble();
            
            double result = 0;
            String currencyCode = "";
            
            
            if (baseCurrency == 1) {
                switch (targetCurrency) {
                    case 1:
                        result = amount * eurRate;
                        currencyCode = "EUR";
                        break;
                    case 2:
                        result = amount * inrRate;
                        currencyCode = "INR";
                        break;
                    case 3:
                        result = amount * gbpRate;
                        currencyCode = "GBP";
                        break;
                    case 4:
                        result = amount * jpyRate;
                        currencyCode = "JPY";
                        break;
                    default:
                        System.out.println("Invalid target currency selection.");
                        return;
                }
                
                System.out.printf("Converted Amount: %.2f %s%n", result, currencyCode);
            } else {
                System.out.println("Currently, only USD is supported as the base currency.");
            }
        }
    }
}
