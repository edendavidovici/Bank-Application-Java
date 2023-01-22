package com.example.bank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Bank Class that implements IBank interface and contains List<IAccount> and #totalAccounts
public class Bank implements IBank{
    public List<IAccount> accounts;
    public int totalAccounts;
    public Bank() {
        accounts = new LinkedList<IAccount>();
        totalAccounts = 0;
    }

    @Override
    public void OpenAccount(IAccount account) {
        accounts.add(account);
    }

    @Override
    public void CloseAccount(int accountNumber) { // Iterate over the accounts list and remove all the indices with account provided as function parameters. Keep in mind that Balance of that account must be >=0 to be closed.
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).GetAccountNumber()==accountNumber && accounts.get(i).GetCurrentBalance()>=0){
                accounts.remove(i);
            }
        }
    }

    @Override
    public List<IAccount> GetAllAccounts() {
        return accounts;
    }

    @Override
    public List<IAccount> GetAllAccountInDebt() { // Iterate over accounts list and Get balance and check if balance is negative then add in debt accounts list and return that list.
        List<IAccount> DebtAccount = new LinkedList<IAccount>();
        for (IAccount account : accounts) {
            if (account.GetCurrentBalance() < 0) {
                DebtAccount.add(account);
            }
        }
        return DebtAccount;
    }

    @Override
    public List<IAccount> GetAllAccountsWithBalance(double balanceAbove) {// Iterate over accounts list and Get balance and check if balance is above specified limit then add in temp accounts list and return that list.
        List<IAccount> Account = new LinkedList<IAccount>();
        for (IAccount account : accounts) {
            if (account.GetCurrentBalance() >= balanceAbove) {
                Account.add(account);
            }
        }
        return Account;
    }
}
