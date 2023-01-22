package com.example.bank;

import java.util.List;

// Interface class IBank that will be implemeted by Our Bank class
// Main functionality that implements here is Open Account, Close Account, Get All the Accounts , Debted Account or With Balance Above certain limit. 
public interface IBank {
    void OpenAccount(IAccount account);
    void CloseAccount(int accountNumber);
    List<IAccount> GetAllAccounts();
    List<IAccount> GetAllAccountInDebt();
    List<IAccount> GetAllAccountsWithBalance(double balanceAbove);
}
