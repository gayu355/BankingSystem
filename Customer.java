import java.util.Scanner;

public class Customer {

    private int customerId;
    private String customerName;
    private String phoneNumber;
    private String address;

    private Customer[] customers = new Customer[100];
    private int count = 0;

    Scanner sc = new Scanner(System.in);

    public Customer() {

    }

    public Customer(int customerId, String customerName,
                    String phoneNumber, String address) {

        this.customerId = customerId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

  
       public void displayCustomer() {

        System.out.println("----------------------------------");
        System.out.println("Customer ID   : " + customerId);
        System.out.println("Customer Name : " + customerName);
        System.out.println("Phone Number  : " + phoneNumber);
        System.out.println("Address       : " + address);
        System.out.println("----------------------------------");
    }

    public void customerMenu() {

        int choice;

        do {

            System.out.println("\n========== CUSTOMER MENU ==========");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Search Customer");
            System.out.println("4. Update Customer");
            System.out.println("5. Delete Customer");
            System.out.println("6. Back");
            System.out.print("Enter Choice : ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addCustomer();
                    break;

                case 2:
                    viewCustomers();
                    break;

                case 3:
                    searchCustomer();
                    break;

                case 4:
                    updateCustomer();
                    break;

                case 5:
                    deleteCustomer();
                    break;

                case 6:
                    System.out.println("Returning...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 6);
    }

    public void addCustomer() {

        System.out.print("Enter Customer ID : ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Customer Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Phone Number : ");
        String phone = sc.nextLine();

        System.out.print("Enter Address : ");
        String address = sc.nextLine();

        customers[count] = new Customer(id, name, phone, address);

        count++;

        System.out.println("Customer Added Successfully.");
    }


    public void viewCustomers() {

        if (count == 0) {
            System.out.println("No Customers Available.");
            return;
        }

        System.out.println("\n========== CUSTOMER LIST ==========");

        for (int i = 0; i < count; i++) {
            customers[i].displayCustomer();
        }
    }


    public void searchCustomer() {

        System.out.print("Enter Customer ID : ");
        int id = sc.nextInt();

        for (int i = 0; i < count; i++) {

            if (customers[i].getCustomerId() == id) {

                customers[i].displayCustomer();
                return;
            }
        }

        System.out.println("Customer Not Found.");
    }

    public void updateCustomer() {

        System.out.print("Enter Customer ID : ");
        int id = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < count; i++) {

            if (customers[i].getCustomerId() == id) {

                System.out.print("Enter New Customer Name : ");
                customers[i].setCustomerName(sc.nextLine());

                System.out.print("Enter New Phone Number : ");
                customers[i].setPhoneNumber(sc.nextLine());

                System.out.print("Enter New Address : ");
                customers[i].setAddress(sc.nextLine());

                System.out.println("Customer Updated Successfully.");
                return;
            }
        }

        System.out.println("Customer Not Found.");
    }
 
    public void deleteCustomer() {

        System.out.print("Enter Customer ID : ");
        int id = sc.nextInt();

        for (int i = 0; i < count; i++) {

            if (customers[i].getCustomerId() == id) {

                for (int j = i; j < count - 1; j++) {
                    customers[j] = customers[j + 1];
                }

                customers[count - 1] = null;
                count--;

                System.out.println("Customer Deleted Successfully.");
                return;
            }
        }

        System.out.println("Customer Not Found.");
    }

}