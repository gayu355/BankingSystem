import java.util.Scanner;

public class Account {
    private int[] accNo = new int[10];
    private String[] type = new String[10];
    private double[] balance = new double[10];
    private int count = 0;
    Scanner sc = new Scanner(System.in);

    public void accountMenu() {
        int ch;
        do {
            System.out.println("\n--- Account Management ---");
            System.out.println("1.Create Account");
            System.out.println("2.Deposit");
            System.out.println("3.Withdraw");
            System.out.println("4.View Accounts");
            System.out.println("5.Back");
            System.out.print("Enter Choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Account Number: ");
                    accNo[count] = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Account Type (Savings/Current): ");
                    type[count] = sc.nextLine();
                    System.out.print("Initial Balance: ");
                    balance[count] = sc.nextDouble();
                    count++;
                    System.out.println("Account Created Successfully.");
                    break;

                case 2:
                case 3:
                    System.out.print("Enter Account Number: ");
                    int no = sc.nextInt();
                    System.out.print("Enter Amount: ");
                    double amt = sc.nextDouble();
                    boolean found = false;

                    for (int i = 0; i < count; i++) {
                        if (accNo[i] == no) {
                            if (ch == 2)
                                balance[i] += amt;
                            else if (amt <= balance[i])
                                balance[i] -= amt;
                            else
                                System.out.println("Insufficient Balance.");

                            System.out.println("Current Balance: " + balance[i]);
                            found = true;
                        }
                    }

                    if (!found)
                        System.out.println("Account Not Found.");
                    break;

                case 4:
                    if (count == 0)
                        System.out.println("No Accounts Found.");
                    else
                        for (int i = 0; i < count; i++)
                            System.out.println(accNo[i] + "  " + type[i] + "  " + balance[i]);
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }
        } while (ch != 5);
    }
}
