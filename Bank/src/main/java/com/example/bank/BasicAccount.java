package com.example.bank;

// Basic Account typethat implements IAccount has 3 variables int,double,double
// Constructor takes account number and withdraw limit, withdraw limit will limit how much money can be taken out of the bank account
// All of the provided functions in base interface class are implemented here according to basic account specifications
public class BasicAccount implements IAccount{
    public int accountID;
    public double withdrawLimit;
    public double balance;

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public BasicAccount(int accountNumber, double withdrawalLimit){ // Cnstructor that initializes the account number, withdraw limit and here balance=0.
        accountID = accountNumber;
        withdrawLimit = withdrawalLimit;
        balance = 0;
    }

    @Override
    public void Deposit(double amount) {
        balance += amount;
    }

    @Override
    public double Withdraw(double amount) {
        if(amount>=withdrawLimit){ // limit the withdraw amount if input withdraw amount exceeds available balance
            balance -= withdrawLimit;
            return withdrawLimit;
        }
        else{
            balance -= amount;
            return amount;
        }
    }

    @Override
    public double GetCurrentBalance() {
        return balance;
    }

    @Override
    public int GetAccountNumber() {
        return accountID;
    }
}
