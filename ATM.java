package octanet;

import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {
        Atm atm = new Atm();
        atm.checkPin();
    }

    static class Atm {
        float balance = 0;
        int pin = 1111;

        public void checkPin() {
            System.out.print("Enter your pin:  ");
            Scanner sc = new Scanner(System.in);
            int enteredPin = sc.nextInt();

            if (enteredPin == pin) {
                menu();
            } else {
                System.out.println("Invalid pin");
            }
        }

        private void menu() {
            System.out.println("Enter your choice:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. EXIT");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            if (choice == 1) {
                withdraw();
            } else if (choice == 2) {
                deposit();
            } else if (choice == 3) {
                checkBalance();
            } else if (choice == 4) {
                exit();
            } else {
                System.out.println("Invalid Choice");
                menu();
            }
        }

        private void withdraw() {
            System.out.print("Enter money to be withdrawn: ");
            Scanner sc = new Scanner(System.in);
            int withdrawAmount = sc.nextInt();

            if (balance >= withdrawAmount) {
                balance -= withdrawAmount;
                System.out.println("Please collect your money" + withdrawAmount);

                System.out.println("remaning amount : - " +  balance);
            } else {
                System.out.println("Insufficient Balance");
            }
            menu();
        }

        private void deposit() {
            System.out.print("Enter money to be deposited: ");
            Scanner sc = new Scanner(System.in);
            int depositAmount = sc.nextInt();

            balance += depositAmount;
            System.out.println("Your money has been successfully deposited");
            menu();
        }

        private void checkBalance() {
            System.out.println("Balance: " + balance);
            menu();
        }

        private void exit() {
            System.out.println("Thank you for using our ATM. Goodbye!");
            System.exit(0);
        }
    }
}
