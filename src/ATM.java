
import java.util.Scanner;

import static java.lang.String.valueOf;

public class ATM {
    private static Scanner in;
    private static float balance = 0;
    private static int anotherTransaction;

    public static void main(String args[]) {
        in = new Scanner(System.in);


        System.out.println("Welcome to the ATM machine!");
        System.out.println("Please insert your card\n");
        //signup
        signup();
    }
    private static void signup(){
        int Option = 0;
        System.out.println("Click 1 for sign in and Click 2 for sign Up");
        System.out.println("1. sign in");
        System.out.println("2. sign up");
        Option = in.nextInt();

        switch (Option){
            case 1:
                String signuserid=null;
                int supuser = 0;
                int suppass = 0;
                String signpass=null;
                System.out.println("Enter your username");
                signuserid = String.valueOf(in.next());
                System.out.println("Enter your password");
                supuser = in.nextInt();
                System.out.println("------------Login successfully One Plate Bank LTD.------------");
                System.out.println("Hello Mr/mrs "+signuserid +" Welcome to One plate Bank LTD.");
                runATM();
//                if (signuserid==supuser || signpass==suppass) {
//
//                    System.out.println("------------------------Login successfully----------------------");
//
//                }
//                else {
//                    System.out.println("username or password is wrong try again");
//                    anotherTransaction();
//                }
            break;
            case 2:
                System.out.println("Enter your username");
                supuser = in.nextInt();
                System.out.println("Enter your password");
                suppass = in.nextInt();
                signup();
            break;
        }


    }
    private static void runATM() {
        System.out.println("Please select an option");
        System.out.println("1. View Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Exit");

        int option = in.nextInt();

        switch (option) {
            case 1:
                System.out.println("Your current balance is: " + balance);
                anotherTransaction();
                break;
            case 2:
                float amount;
                System.out.println("Please enter the amount you would like to withdraw: ");
                amount = in.nextFloat();
                if (amount > balance || amount == 0) {
                    System.out.println("You have insufficient funds\n\n");
                    anotherTransaction();
                } else {
                    balance = balance - amount;
                    System.out.println("You have withdrawn " + amount + " and your new balance is " + balance + "\n");
                    anotherTransaction();
                }
                break;
            case 3:
                float deposit;
                System.out.println("Please enter the amount you would like to deposit: ");
                deposit = in.nextFloat();
                balance = deposit + balance;
                System.out.println("You have deposited " + deposit + " and your new balance is " + balance + "\n");
                anotherTransaction();
                break;
            case 4:
                System.out.println("Thank you for using One plate ATM machine!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option!\n\n");
                anotherTransaction();
                break;
        }
    }

    private static void anotherTransaction() {
        System.out.println("Do you want another transaction?\nPress 1 for another transaction\npress 2 for Logout\npress 3 To exit");
        anotherTransaction = in.nextInt();
        if (anotherTransaction == 1) {
            runATM();
        } else if (anotherTransaction == 2) {
            signup();
        } else if (anotherTransaction==3) {
            System.out.println("Thank you for using One Plate ATM machine!");
            System.exit(0);
        }
    }
}
