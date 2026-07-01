import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Customer customer = new Customer();
        Account account = new Account();
        Transaction transaction = new Transaction();

        int choice;

        do {

            System.out.println("\n======================================");
            System.out.println("      BANK MANAGEMENT SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Customer Management");
            System.out.println("2. Account Management");
            System.out.println("3. Transaction Management");
            System.out.println("4. Exit");
            System.out.print("Enter your choice : ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    customer.customerMenu();
                    break;

                case 2:
                    account.accountMenu();
                    break;

                case 3:
                    transaction.transactionMenu();
                    break;

                case 4:
                    System.out.println("\nThank You for Using Bank Management System.");
                    break;

                default:
                    System.out.println("Invalid Choice! Try Again.");
            }

        } while (choice != 4);

        sc.close();
    }
}
