import java.util.Scanner;

public class Transaction {
    private int[] id = new int[10];
    private int[] accNo = new int[10];
    private String[] type = new String[10];
    private double[] amount = new double[10];
    private int count = 0;
    Scanner sc = new Scanner(System.in);

    public void transactionMenu() {
        int ch;
        do {
            System.out.println("\n--- Transaction Management ---");
            System.out.println("1.Add Transaction");
            System.out.println("2.View Transactions");
            System.out.println("3.Back");
            System.out.print("Enter Choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Transaction ID: ");
                    id[count] = sc.nextInt();
                    System.out.print("Account Number: ");
                    accNo[count] = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Transaction Type: ");
                    type[count] = sc.nextLine();
                    System.out.print("Amount: ");
                    amount[count] = sc.nextDouble();
                    count++;
                    System.out.println("Transaction Added Successfully.");
                    break;

                case 2:
                    if (count == 0)
                        System.out.println("No Transactions Found.");
                    else
                        for (int i = 0; i < count; i++)
                            System.out.println(id[i] + "  " + accNo[i] + "  " + type[i] + "  " + amount[i]);
                    break;

                case 3:
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }
        } while (ch != 3);
    }
}
