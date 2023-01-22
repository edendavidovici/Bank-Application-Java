package com.example.bank;

public class main {
    public static void main(String[] args) {
        // Create Standard Account with credit limit of -100
        IAccount standard  = new StandardAccount(1,-100);
        // Create Basic Account with Withdraw limit of 100
        IAccount basic = new BasicAccount(2,100);
        // Create new Premium Account
        IAccount premium = new PremiumAccount(3);
        // Create new bank
        IBank bank = new Bank();

        // Open those 3 acccounts in the bank
        bank.OpenAccount(standard);
        bank.OpenAccount(basic);
        bank.OpenAccount(premium);

        // Deposit 1000 in each account
        System.out.println("Depositing 1000 in each account...");
        premium.Deposit(1000);
        standard.Deposit(1000);
        basic.Deposit(1000);
        System.out.println("");

        System.out.println("Withdrawing 3000 from each account...");
        // Try to Withdraw 3000 from premium account (should print 3000)
        System.out.println("Widthdrawn " + premium.Withdraw(3000) + " From Premium Account");
        // Try to Withdraw 3000 from basic account (should print 100)
        System.out.println("Widthdrawn " + basic.Withdraw(3000) + " From Basic Account");
        // Try to Withdraw 3000 from standard account (should print 1100)
        System.out.println("Widthdrawn " + standard.Withdraw(3000) + " From Standard Account");
        System.out.println("");

        // Check Balance in premium Account (Should print -2000)
        System.out.println("Current Balance in account number " + premium.GetAccountNumber() + " (Premium) is " + premium.GetCurrentBalance());
        // Check Balance in basic Account (Should print 900)
        System.out.println("Current Balance in account number " + basic.GetAccountNumber() + " (Basic) is " + basic.GetCurrentBalance());
        // Check Balance in standard Account (Should print -100)
        System.out.println("Current Balance in account number " + standard.GetAccountNumber() + " (Standard) is " + standard.GetCurrentBalance());
        System.out.println("");

        // Print all accounts in debt (should print accounts 1 and 3)
        for (IAccount account: bank.GetAllAccountInDebt()){
            System.out.println("Account " + account.GetAccountNumber() + " is in debt");
        }
        System.out.println("");

        // Close All Bank Accounts
        System.out.println("Closing all accounts in the bank...");
        bank.CloseAccount(premium.GetAccountNumber());
        bank.CloseAccount(standard.GetAccountNumber());
        bank.CloseAccount(basic.GetAccountNumber());

        // check how many accounts are present in the bank (should be only 2 - cannot close accounts in debt)
        System.out.println("There are " + bank.GetAllAccounts().size() + " accounts in the bank");
        System.out.println("");

        // Deposit 2000 to each of the accounts left
        System.out.println("Depositing 2000 in each account...");
        premium.Deposit(2000);
        standard.Deposit(2000);

        // Print all the accounts with Balance more than 1000 ( should print account 1 only )
        for (IAccount account: bank.GetAllAccountsWithBalance(1000)) {
            System.out.println("Account " + account.GetAccountNumber() + " has more than 1000 in its balance");
        }
        System.out.println("");

        // Check Balance in Premium Account (should print 0)
        System.out.println("Current Balance in account number " + premium.GetAccountNumber() + " (Premium) is " + premium.GetCurrentBalance());
        // Check Balance in Standard Account (should print 1900)
        System.out.println("Current Balance in account number " + standard.GetAccountNumber() + " (Standard) is " + standard.GetCurrentBalance());

        // Close All Bank Accounts
        System.out.println("");
        System.out.println("Closing all bank accounts...");
        bank.CloseAccount(premium.GetAccountNumber());
        bank.CloseAccount(standard.GetAccountNumber());
        // check how many accounts are present in the bank (should be only 0)
        System.out.println("There are " + bank.GetAllAccounts().size() + " accounts in the bank");
    }
}
