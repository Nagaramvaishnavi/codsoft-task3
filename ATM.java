import java.util.Scanner;

public class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            int choice;

            while (true) {
                showMenu();
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        handleDeposit(scanner);
                        break;
                    case 3:
                        handleWithdraw(scanner);
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    private void showMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    private void checkBalance() {
        System.out.printf("Current balance: $%.2f\n", account.getBalance());
    }

    private void handleDeposit(Scanner scanner) {
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
        System.out.printf("New balance: $%.2f\n", account.getBalance());
    }

    private void handleWithdraw(Scanner scanner) {
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
        System.out.printf("New balance: $%.2f\n", account.getBalance());
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00); // Initial balance
        ATM atm = new ATM(account);
        atm.start();
    }
}

