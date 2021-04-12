import java.util.Scanner;

public class Account {
    //variables
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    //constructor class
    Account(String cname, String cid){
        customerName = cname;
        customerId = cid;
    }

    //Function to deposit money
    void deposit(int amount){
        if (amount != 0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    //Function to withdraw money
    void withdraw(int amount){
        if (amount != 0){
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    //Function for showing the previous transaction
    void getPreviousTransaction(){
        if (previousTransaction > 0){
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0){
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred.");
        }
    }

    //Function for calculating interest of current funds after a certain period
    void calculateInterest(int years){
        double interestRate = .0185;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is " + (100 * interestRate));
        System.out.println("After  " + years + " years, your balance will be " + newBalance);
    }

    //Menu function
    void showMenu(){
        char option = '\0';
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your id is " + customerId);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Withdraw money");
        System.out.println("D. View previous transactions");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");

        do {
            System.out.println();
            System.out.println("Enter an option");
            char option1 = sc.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch (option){
                //Case A
                case 'A':
                    System.out.println("=============================");
                    System.out.println("        Balance = $" + balance);
                    System.out.println("=============================");
                    System.out.println();
                    break;
                case 'B':
                    System.out.println("Enter the amount you wish to deposit: ");
                    int amount = sc.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;
                case 'C':
                    System.out.println("Enter the amount you wish to withdraw: ");
                    int amount1 = sc.nextInt();
                    withdraw(amount1);
                    System.out.println();
                    break;
                case 'D':
                    System.out.println("=============================");
                    getPreviousTransaction();
                    System.out.println("=============================");
                    System.out.println();
                    break;
                case 'E':
                    System.out.println("How many years of accrued interest: ");
                    int years = sc.nextInt();
                    calculateInterest(years);
                    break;
                case 'F':
                    System.out.println("=============================");
                    break;
                default:
                    System.out.println("Invalid option, please enter a valid option!");
                    break;
            }
        } while (option != 'F');
            System.out.println("Thank you for banking with us!");


    }

}
