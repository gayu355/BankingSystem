import java.util.Scanner;

public class Transaction {

    private int transactionId;
    private int accountNumber;
    private String transactionType;
    private double amount;


    private Transaction[] transactions = new Transaction[100];
    private int count = 0;

    Scanner sc = new Scanner(System.in);

    public Transaction() {

    }


    public Transaction(int transactionId, int accountNumber,
                       String transactionType, double amount) {

        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.amount = amount;
    }

 
    public int getTransactionId() {
        return transactionId;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    
    public void displayTransaction() {

        System.out.println("-------------------------------");
        System.out.println("Transaction ID : " + transactionId);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Type           : " + transactionType);
        System.out.println("Amount         : " + amount);
        System.out.println("-------------------------------");
    }

public void transactionMenu() {

        int choice;

        do {

            System.out.println("\n========== TRANSACTION MENU ==========");
            System.out.println("1. Add Transaction");
            System.out.println("2. View Transactions");
            System.out.println("3. Search Transaction");
            System.out.println("4. Delete Transaction");
            System.out.println("5. Back");
            System.out.print("Enter Choice : ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addTransaction();
                    break;

                case 2:
                    viewTransactions();
                    break;

                case 3:
                    searchTransaction();
                    break;

                case 4:
                    deleteTransaction();
                    break;

                case 5:
                    System.out.println("Returning...");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 5);
    }

    
    public void addTransaction() {

        System.out.print("Enter Transaction ID : ");
        int id = sc.nextInt();

        System.out.print("Enter Account Number : ");
        int accNo = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Transaction Type (Deposit/Withdraw) : ");
        String type = sc.nextLine();

        System.out.print("Enter Amount : ");
        double amount = sc.nextDouble();

        transactions[count] = new Transaction(id, accNo, type, amount);

        count++;

        System.out.println("Transaction Added Successfully.");
    }

    public void viewTransactions() {

        if (count == 0) {

            System.out.println("No Transactions Available.");
            return;

        }

        System.out.println("\n========== TRANSACTION LIST ==========");

        for (int i = 0; i < count; i++) {

            transactions[i].displayTransaction();

        }

    }

    
    public void searchTransaction() {

        System.out.print("Enter Transaction ID : ");
        int id = sc.nextInt();

        for (int i = 0; i < count; i++) {

            if (transactions[i].getTransactionId() == id) {

                transactions[i].displayTransaction();
                return;

            }

        }

        System.out.println("Transaction Not Found.");

    }

 
    public void deleteTransaction() {

        System.out.print("Enter Transaction ID : ");
        int id = sc.nextInt();

        for (int i = 0; i < count; i++) {

            if (transactions[i].getTransactionId() == id) {

                for (int j = i; j < count - 1; j++) {

                    transactions[j] = transactions[j + 1];

                }

                transactions[count - 1] = null;
                count--;

                System.out.println("Transaction Deleted Successfully.");
                return;

            }

        }

        System.out.println("Transaction Not Found.");

    }

}
