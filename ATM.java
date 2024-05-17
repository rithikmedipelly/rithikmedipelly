import java.util.Scanner;

// Bank Account class to represent the user's account
class BankAccount {
    private double balance;

    // Constructor to initialize the account balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to get the current balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        balance += amount;
    }

    // Method to withdraw money from the account
    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }
}

// ATM class to represent the ATM machine
public class ATM {
    private BankAccount account;
    private Scanner scanner;

    // Constructor to initialize the ATM with a bank account
    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    // Method to display the ATM menu
    public void displayMenu() {
        System.out.println("Welcome to the ATM");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    // Method to handle the user's choice
    public void handleChoice(int choice) {
        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                deposit();
                break;
            case 3:
                withdraw();
                break;
            case 4:
                System.out.println("Thank you for using the ATM.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    // Method to check the account balance
    public void checkBalance() {
        System.out.println("Your current balance is: $" + account.getBalance());
    }

    // Method to deposit money into the account
    public void deposit() {
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();
        account.deposit(amount);
        System.out.println("Deposit successful. Your new balance is: $" + account.getBalance());
    }

    // Method to withdraw money from the account
    public void withdraw() {
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();
        boolean success = account.withdraw(amount);
        if (success) {
            System.out.println("Withdrawal successful. Your new balance is: $" + account.getBalance());
        }
    }

    // Main method to run the ATM
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000); // Initialize account balance
        ATM atm = new ATM(account);

        boolean exit = false;
        while (!exit) {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            int choice = atm.scanner.nextInt();
            atm.handleChoice(choice);

            if (choice == 4) {
                exit = true;
            }
        }

        atm.scanner.close();
    }
}