package com.company;

import java.util.Scanner;
import java.util.HashMap;


public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static ATM atm = new ATM();
    public static HashMap<String, Double> names = new HashMap();

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to TCF Bank");

        atm.chooseName();

        atm.chooseTransactions();

        while (true){
           boolean keepRunning = atm.chooseTransactions();
            if(!keepRunning){
                atm.chooseName();

            }
        }








    }
}
