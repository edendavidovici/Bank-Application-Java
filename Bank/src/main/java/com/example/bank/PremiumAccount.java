package com.example.bank;

// Standard Account typethat implements IAccount has 2 variables int,double
// Constructor takes account number. Any amount can be withdrawn or depsoit.
// All of the provided functions in base interface class are implemented here according to premium account specifications
public class PremiumAccount implements IAccount{
    public int accountID;
    public double balance;
    public PremiumAccount(int accountNumber){ // Constructor initializes account number and here balance=0
        accountID = accountNumber;
        balance = 0;
    }

    @Override
    public void Deposit(double amount) {// No limit on deposit
        balance += amount;
    }

    @Override
    public double Withdraw(double amount) {// No limit on withdrawal
        balance -= amount;
        return amount;
    }

    @Override
    public double GetCurrentBalance() {
        return balance;
    }

    @Override
    public int GetAccountNumber() {
        return accountID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
