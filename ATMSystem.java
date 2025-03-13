
import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! New Balance: Rs/-" + balance);
        } else {
            System.out.println("Invalid amount! Please enter amount greater than 0.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful! New Balance: Rs/-" + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            System.out.println("Invalid amount! Please enter a amount greater than 0.");
        }
    }
}


class ATM {
    private final BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    /**
     * 
     */
    public void showMenu() {
        try (Scanner sc = new Scanner(System.in)) {
            int option;
            
            do {
                System.out.println("\nATM Machine");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                while (!sc.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a number.");
                    sc.next();
                }
                option = sc.nextInt();
                
                switch (option) {
                    case 1:
                        System.out.println("Current Balance: Rs/-" + account.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: Rs/-");
                        if (sc.hasNextDouble()) {
                            double depositAmount = sc.nextDouble();
                            account.deposit(depositAmount);
                        } else {
                            System.out.println("Invalid input! Please enter a number.");
                            sc.next();
                        }
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: Rs/-");
                        if (sc.hasNextDouble()) {
                            double withdrawAmount = sc.nextDouble();
                            account.withdraw(withdrawAmount);
                        } else {
                            System.out.println("Invalid input! Please enter a number.");
                            sc.next();
                        }
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM!");
                        break;
                    default:
                        System.out.println("Invalid option! Please try again.");
                }
            } while (option != 4);
        }
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); 
        ATM atm = new ATM(userAccount);
        atm.showMenu();
    }
}

