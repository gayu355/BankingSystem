import java.util.Scanner;

public class Account {

    private int accountNumber;
    private int customerId;
    private String accountType;
    private double balance;

    private Account[] accounts = new Account[100];
    private int count = 0;

    Scanner sc = new Scanner(System.in);

    public Account() {

    }

    public Account(int accountNumber, int customerId,
                   String accountType, double balance) {

        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.accountType = accountType;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void displayAccount() {

        System.out.println("-------------------------------");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Customer ID    : " + customerId);
        System.out.println("Account Type   : " + accountType);
        System.out.println("Balance        : " + balance);
        System.out.println("-------------------------------");
    }

    public void accountMenu() {
        int choice;
        do {

            System.out.println("\n========== ACCOUNT MENU ==========");
            System.out.println("1. Create Account");
            System.out.println("2. View Accounts");
            System.out.println("3. Search Account");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Delete Account");
            System.out.println("7. Back");
            System.out.print("Enter Choice : ");

            choice = sc.nextInt();

            switch(choice) {

                case 1:
                    createAccount();
                    break;

                case 2:
                    viewAccounts();
                    break;

                case 3:
                    searchAccount();
                    break;

                case 4:
                    depositAmount();
                    break;

                case 5:
                    withdrawAmount();
                    break;

                case 6:
                    deleteAccount();
                    break;

                case 7:
                    System.out.println("Returning...");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while(choice != 7);
    }

    public void createAccount() {

        System.out.print("Enter Account Number : ");
        int accNo = sc.nextInt();

        System.out.print("Enter Customer ID : ");
        int custId = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Account Type (Savings/Current) : ");
        String type = sc.nextLine();

        System.out.print("Enter Initial Balance : ");
        double bal = sc.nextDouble();

        accounts[count] = new Account(accNo, custId, type, bal);

        count++;

        System.out.println("Account Created Successfully.");
    }

    public void viewAccounts() {

        if (count == 0) {
            System.out.println("No Accounts Available.");
            return;
        }

        System.out.println("\n========== ACCOUNT LIST ==========");

        for (int i = 0; i < count; i++) {
            accounts[i].displayAccount();
        }
    }

    public void searchAccount() {

        System.out.print("Enter Account Number : ");
        int accNo = sc.nextInt();

        for (int i = 0; i < count; i++) {

            if (accounts[i].getAccountNumber() == accNo) {

                accounts[i].displayAccount();
                return;
            }
        }

        System.out.println("Account Not Found.");
    }

    public void depositAmount() {

        System.out.print("Enter Account Number : ");
        int accNo = sc.nextInt();

        System.out.print("Enter Deposit Amount : ");
        double amount = sc.nextDouble();

        for (int i = 0; i < count; i++) {

            if (accounts[i].getAccountNumber() == accNo) {

                accounts[i].balance += amount;

                System.out.println("Amount Deposited Successfully.");
                System.out.println("Current Balance : " + accounts[i].balance);

                return;
            }
        }

        System.out.println("Account Not Found.");
    }


    public void withdrawAmount() {

        System.out.print("Enter Account Number : ");
        int accNo = sc.nextInt();

        System.out.print("Enter Withdraw Amount : ");
        double amount = sc.nextDouble();

        for (int i = 0; i < count; i++) {

            if (accounts[i].getAccountNumber() == accNo) {

                if (accounts[i].getAccountType().equalsIgnoreCase("Savings")) {

                    if (accounts[i].balance - amount >= 1000) {

                        accounts[i].balance -= amount;

                        System.out.println("Withdrawal Successful.");
                        System.out.println("Remaining Balance : " + accounts[i].balance);

                    } else {

                        System.out.println("Minimum Balance of Rs.1000 should be maintained.");
                    }

                } else if (accounts[i].getAccountType().equalsIgnoreCase("Current")) {

                    if (accounts[i].balance + 5000 >= amount) {

                        accounts[i].balance -= amount;

                        System.out.println("Withdrawal Successful.");
                        System.out.println("Current Balance : " + accounts[i].balance);

                    } else {

                        System.out.println("Overdraft Limit Exceeded.");
                    }
                }

                return;
            }
        }

        System.out.println("Account Not Found.");
    }

    public void deleteAccount() {

        System.out.print("Enter Account Number : ");
        int accNo = sc.nextInt();

        for (int i = 0; i < count; i++) {

            if (accounts[i].getAccountNumber() == accNo) {

                for (int j = i; j < count - 1; j++) {

                    accounts[j] = accounts[j + 1];
                }

                accounts[count - 1] = null;
                count--;

                System.out.println("Account Deleted Successfully.");

                return;
            }
        }

        System.out.println("Account Not Found.");
    }

}