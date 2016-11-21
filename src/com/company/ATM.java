package com.company;


/**
 * Created by gilbertakpan on 11/17/16.
 */
public class ATM {
    private String name;
    private int withdrawal;
    private String transactions;

//initial transaction

    public void chooseName() throws Exception {
        boolean goBack = true;
        while (goBack == true) {

            System.out.println("Please enter name ...");
            name = Main.scanner.nextLine();
            System.out.println("Welcome, " + name);
            if (name.isEmpty()) {
                throw new Exception("Invalid Name");

            }
            if (Main.names.containsKey(name)) {
                goBack = false;
            }

            if (!Main.names.containsKey(name)) {
                System.out.println("Do you want to open an account ? [y/n]");
                String answer = Main.scanner.nextLine();
                if (answer.equalsIgnoreCase("y")) {
                    Main.names.put(name, 100.0);
                    System.out.println(Main.names.get(name));
                    goBack = false;
                } else if (answer.equalsIgnoreCase("n")) {
                    System.out.println("Good bye!");
                    goBack = true;


                }
            }
        }
    }


    public boolean chooseTransactions() throws Exception {
        System.out.println("Select Option[Check Balance/Withdrawal/close account/Cancel]");
        transactions = Main.scanner.nextLine();

        if (transactions.equalsIgnoreCase("Check Balance")) {
            System.out.println(Main.names.get(name));

        } else if (transactions.equalsIgnoreCase("Withdrawal")) {
            System.out.println("How much?");
            withdrawal = Main.scanner.nextInt();

            if (withdrawal <= (Main.names.get(name))) {
                System.out.println("Take money." + " Your new balance is " + "$" + (Main.names.get(name) - withdrawal) + " Have a nice day ");
                Double balance = (Main.names.get(name) - withdrawal);
                Main.names.put(name, balance);
            } else if (withdrawal > Main.names.get(name)) {
                System.out.println("Insufficient Funds");

            }
        }
        {
            if (transactions.equalsIgnoreCase("close account"))

            {
                System.out.println("close account [y/n]");
                String response = Main.scanner.nextLine();
                if (response.equalsIgnoreCase("y")) {
                    System.out.println("Your account has been closed!");
                    Main.names.remove(name);
                    return (false);
                } else if (transactions.equalsIgnoreCase("n")) {
                    System.out.println("Please enter name...");
                }

            }
        }
        if (transactions.equalsIgnoreCase("Cancel"))

        {

            System.out.println("Thank you and please come again");
            return (false);


        }
        return (true);
    }
}
