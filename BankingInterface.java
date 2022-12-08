import java.util.Scanner;

public class BankingInterface {

  // Create a BankAccount object to hold the user's account information
  static BankAccount account = new BankAccount();

  // Create a Scanner object to read user input
  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    // Display the main menu and wait for the user's input
    int option = showMainMenu();

    // Keep showing the main menu and processing user input until the user chooses to exit
    while (option != 4) {
      switch (option) {
        case 1:
          // Show the account balance
          showBalance();
          break;
        case 2:
          // Add or subtract funds from the account
          updateBalance();
          break;
        case 3:
          // Transfer funds to another account
          transferFunds();
          break;
        default:
          System.out.println("Invalid option. Please try again.");
          break;
      }

      // Display the main menu and wait for the user's input again
      option = showMainMenu();
    }

    // Close the scanner when the program ends
    scanner.close();
  }

  // Shows the main menu and returns the user's selected option
  static int showMainMenu() {
    System.out.println("Welcome to the banking interface!");
    System.out.println("Please select an option:");
    System.out.println("1. Show account balance");
    System.out.println("2. Add or subtract funds");
    System.out.println("3. Transfer funds");
    System.out.println("4. Exit");
    return scanner.nextInt();
  }

  // Shows the account balance
  static void showBalance() {
    System.out.println("Your account balance is: $" + account.getBalance());
  }

  // Adds or subtracts funds from the account
  static void updateBalance() {
    System.out.println("Enter the amount you want to add or subtract:");
    double amount = scanner.nextDouble();
    account.updateBalance(amount);
    System.out.println("Your new account balance is: $" + account.getBalance());
  }

  // Transfers funds to another account
  static void transferFunds() {
    System.out.println("Enter the recipient's account number:");
    long recipientAccountNumber = scanner.nextLong();
    System.out.println("Enter the amount you want to transfer:");
    double amount = scanner.nextDouble();
    account.transferFunds(recipientAccountNumber, amount);
    System.out.println("Funds transferred successfully. Your new account balance is: $" + account.getBalance());
  }

}

// A class representing a bank account
class BankAccount {

  // The account number
  private long accountNumber;

  // The account balance
  private double balance;

  public BankAccount() {
    // Generate a random account number for the user
    this.accountNumber = (long) (Math.random() * 100000000);
    // Set the initial balance to 0
    this.balance = 0;
  }

  public long getAccountNumber() {
    return accountNumber;
  }

  public double getBalance() {
    return balance;
  }

  // Updates the account balance by adding or subtracting the specified amount
  public void updateBalance(double amount) {
    balance += amount;
  }

  // Transfers the specified amount to the account with the specified account number
  public void transferFunds(long recipientAccountNumber, double amount) {
    // Validate the recipient account number and amount
    if (recipientAccountNumber <= 0 || amount <= 0) {
      System.out.println("Invalid recipient account number or transfer amount. Please try again.");
    } else {
      // Deduct the transfer amount from the user's account balance
      balance -= amount;
      // Transfer the funds to the recipient account
      // (for simplicity, we will assume that the recipient's account already exists)
      // TODO: Implement code to transfer funds to the recipient's account
    }
  }
}