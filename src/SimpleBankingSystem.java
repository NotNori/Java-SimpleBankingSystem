import java.util.Scanner;

public class SimpleBankingSystem {
    public static void main(String[] args) {
        //Withdrawal
        //Deposit
        //Non-bank balance
        //Bank balance
        //Previous transaction
        Scanner menu = new Scanner(System.in);
        double bankBalance = 0;
        double personBalance = 10000;
        double previousAmount = 0;
        String previousAction = new String();


        while(true) {
            System.out.println("You currently have:\n" + bankBalance + " in your bank.\n" + personBalance + " on your person.");
            System.out.println("What would you like to do?\n1. Withdraw\n2. Deposit\n3. Balance\n4. Previous Transaction\n5. Quit");
            int selection = menu.nextInt();

            if(selection == 1) {
                //Withdraw
                Scanner scanner = new Scanner(System.in);
                System.out.println("How much would you like to withdraw?");
                int amount = scanner.nextInt();

                if(amount > bankBalance) { //If amount is more than bank balance then do not withdraw.
                    System.out.println("You do not have enough money to withdraw!\n");
                }
                else { //If correct amount then withdraw, deduct bank balance, add to person, then log for previous transaction.
                    System.out.println("You have withdrawn " + amount + ".\n");
                    bankBalance -= amount;
                    personBalance += amount;
                    previousAction = "Withdrawal";
                    previousAmount = amount;
                }
            }
            else if(selection == 2) {
                //Deposit
                Scanner scanner = new Scanner(System.in);
                System.out.println("How much would you like to deposit?");
                int amount = scanner.nextInt();

                if(amount > personBalance) { //If amount is more than person balance then do not deposit.
                    System.out.println("You do not have enough on your person to deposit!\n");
                }
                else { //If correct amount then deposit, deduct person balance, add to bank, then log for previous transaction.
                    System.out.println("You have deposited " + amount + ".\n");
                    bankBalance += amount;
                    personBalance -= amount;
                    previousAction = "Deposit";
                    previousAmount = amount;
                }
            }
            else if(selection == 3) {
                //Balance check, although it is always on the home screen.
                System.out.println("Balance: " + bankBalance + ".\n");
            }
            else if(selection == 4) {
                //Show previous transaction.
                if (previousAction == "" || previousAmount == 0.0) {
                    System.out.println("You do not have any previous transactions.\n");
                } else {
                    System.out.println("Your previous transaction was a '" + previousAction + "' of '" + previousAmount + "'.\n");
                }
            }
            else if(selection == 5) {
                //Quit
                System.out.println("Sorry to see you go.");
                break;
            }
            else {
                //Error catch.
                System.out.println("Error, incorrect selection.");
            }
        }
    }
}
