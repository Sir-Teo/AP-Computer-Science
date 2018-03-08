package com.company.cs;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class BankBalance {

    public static void main(String[] args) throws IOException {
        // Redirect output to the file
        PrintStream file = new PrintStream(new File("AccountReport.txt"));
        PrintStream console = System.out;
        System.setOut(file);

        // Init
        Scanner reader = new Scanner(new File("AccountData.txt"));
        ArrayList<Account> list = new ArrayList<>();

        // Read data
        while (reader.hasNextLine()) {
            // parse data into three parts
            String[] parts = reader.nextLine().split(" ", 3);

            // read and assign
            int accountID = Integer.parseInt(parts[0]);
            Double accountBalance = Double.parseDouble(parts[1]);
            String accountName = parts[2];

            // Update list
            Account newAccount = new Account(accountID, accountBalance, accountName);
            list.add(newAccount);
        }

        // Pre Statement
        System.out.format("%-10s%-20s%-30s%-20s \r\n\r\n",
                "Account", "Owner", "Beginning Balance", "Ending Balance");

        // Detailed Information
        for (Account currentAccount :
                list) {
            System.out.format("%-8s%-22s%-2s%-28s%-2s%-28s \r\n",
                    currentAccount.getAccountID(),
                    currentAccount.getAccountName(),
                    "$ ",
                    ConvertNumberToString(currentAccount.getBalance()),
                    "$ ",
                    ConvertNumberToString(currentAccount.getAddedBalance(0.1))
            );
        }

        file.close();
        System.setOut(console);
        System.out.println("Successfully Print the result to the file AccountReport.txt");
    }

    public static String ConvertNumberToString(Double balance) {
        // Define format of the number
        DecimalFormat formatter = new DecimalFormat("##,###,###,##0.00");
        return formatter.format(balance);
    }
}


class Account {
    private int accountID;
    private String accountName;
    private Double balance;

    Account(int accountID, Double balance, String accountName) {
        this.accountID = accountID;
        this.accountName = accountName;
        this.balance = balance;
    }

    public int getAccountID() {
        return this.accountID;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public Double getBalance() {
        return this.balance;
    }

    public Double getAddedBalance(double percent) {
        return this.balance * (1 + percent);
    }
}