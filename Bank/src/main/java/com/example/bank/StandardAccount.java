package com.example.bank;

// Standard Account typethat implements IAccount has 3 variables double,int,double
// Constructor takes account number and credit limit, credit limit will limit how much money can be taken out of the bank account and deposit at a time.
// All of the provided functions in base interface class are implemented here according to standard account specifications
public class StandardAccount implements IAccount{
    public double creditLim;
    public int accountID;
    public double balance;
    public double getCreditLim() {
        return creditLim;
    }

    public void setCreditLim(double creditLim) {
        this.creditLim = creditLim;
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

    public StandardAccount(int accountNumber, double creditLimit){// Constructor initializes account number, credit limit(negative only) and here balance=0.
        accountID = accountNumber;
        creditLim = creditLimit;
        if(creditLimit>0){
            creditLim = 0;
        }
        balance = 0;
    }

    @Override
    public void Deposit(double amount) {
        balance += amount;
    }

    @Override
    public double Withdraw(double amount) {
        double maxWithdrawAmount = balance - creditLim; // Calculate max withdrawable amount from ctredit limit and available balance
        if ( amount > maxWithdrawAmount) {
            balance = balance - maxWithdrawAmount;
            return maxWithdrawAmount;
        }
        else{
            balance = balance - amount;
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
