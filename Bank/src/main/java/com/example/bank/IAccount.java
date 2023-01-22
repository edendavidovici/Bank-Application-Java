package com.example.bank;

// Interface IAccount which will be implemented by All the Account Classes
public interface IAccount {
    void Deposit(double amount);
    double Withdraw(double amount);
    double GetCurrentBalance();
    int GetAccountNumber();
}
