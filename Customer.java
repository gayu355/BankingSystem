import java.util.Scanner;

public class Customer {
    private int[] id = new int[10];
    private String[] name = new String[10];
    private String[] phone = new String[10];
    private int count = 0;
    Scanner sc = new Scanner(System.in);

    public void customerMenu() {
        int ch;
        do {
            System.out.println("\n--- Customer Management ---");
            System.out.println("1.Add Customer");
            System.out.println("2.View Customers");
            System.out.println("3.Search Customer");
            System.out.println("4.Back");
            System.out.print("Enter Choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Customer ID: ");
                    id[count] = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Customer Name: ");
                    name[count] = sc.nextLine();
                    System.out.print("Phone Number: ");
                    phone[count] = sc.nextLine();
                    count++;
                    System.out.println("Customer Added Successfully.");
                    break;

                case 2:
                    if (count == 0)
                        System.out.println("No Customers Found.");
                    else
                        for (int i = 0; i < count; i++)
                            System.out.println(id[i] + "  " + name[i] + "  " + phone[i]);
                    break;

                case 3:
                    System.out.print("Enter Customer ID: ");
                    int search = sc.nextInt();
                    boolean found = false;
                    for (int i = 0; i < count; i++) {
                        if (id[i] == search) {
                            System.out.println(id[i] + "  " + name[i] + "  " + phone[i]);
                            found = true;
                        }
                    }
                    if (!found)
                        System.out.println("Customer Not Found.");
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }
        } while (ch != 4);
    }
}
