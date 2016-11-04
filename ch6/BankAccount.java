/** 
 * Class that holds a BankAccount which has a balance and an account number.
 * You can deposit money into the account, withdraw money from the account and
 * transfer money to another account.
 * @version CPSC 233
 * @Author Nathaly Verwaal, Mea Wang
 * Copyright (c) 2016. All rights reserved.
 */

public class BankAccount {
    /** Counter that keeps track of the number of accounts created.  Used
     * to assign account numbers to new accounts.
     */
    private static int accountCounter;
    public static void accountIncrementer()
    {
        accountCounter += 1;
    }

    private double balance = 0.0;
    private int accountNumber = 1;
        
    /** 
     * This accessor methods returns the current balance in this account.
     * @return the current balance of the account.
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * This accessor method returns the account number of this account.
     * @return The account number of the account.
     */
    public int getAccountNumber() {
        return accountNumber;
    }
    
    /**
     * Default constructor method that initializes the account's balance to 0.0
    */
    public BankAccount()
    {
        accountIncrementer();
        accountNumber = accountCounter;
        balance = 0.0;
    }        

    /**
     * Overloaded constructor that initializes account balance to what the user desires
     * @param double value to set the bank account balance to
    */
    public BankAccount(double val)
    {
        balance = val;
        accountIncrementer();
        accountNumber = accountCounter;
    }

    /**
     * Corresponding Overloaded constructor to take in the copied constructor's reference values and assign them as the values of the new Copy.
     * @param double account balance
     * @param int accountNumber
    */
    public BankAccount(double copiedBalance, int copiedAccNum)
    {
        balance = copiedBalance;
        accountNumber = copiedAccNum;
    }

    /**
     * Copy constructor that takes a BankAccount object and copies the reference addresses to that object's balance and account number.
     * @param BankAccount object
    */
    public BankAccount(BankAccount copiedAccount)
    {
        this(copiedAccount.getBalance(), copiedAccount.getAccountNumber());
    }

    /**
     * This accessor method returns a string representation of this account
     * in the format (<account_number>,<current_balance>).
     * @return a string representation of this account.
     */
    public String toString() {
        return String.format("%d,%.2f",accountNumber,balance);
    }
    
    /**
     * Returns true if this account is considered equal to the specified account.
     * Two BankAccounts are considered equal if they have the same account number.
     * @param other The account to check for equality with.
     */
    public boolean equals(BankAccount other) {
        return accountNumber == other.accountNumber;
    }

    /**
     * method deposits specified amount to bank acount
     * @param double value for amount to deposit into the account
     * @return true if the deposit succeeded and false otherwise
    */
    public boolean deposit(double amount)
    {
        double orig_balance = balance;
        if ((amount > 0) && (orig_balance + amount >= 0))
        {
            balance += amount;
            return true;
        }
        else
            return false;
    }

    /**
     * method withdraws specified amount from bank acount
     * @param double value for amount to withdrawl from the account
     * @return true if the withdrawlal succeeded and false otherwise
    */
    public boolean withdraw(double amount)
    {
        double orig_balance = balance;
        if ((orig_balance - amount >= 0) && (amount > 0))
        {
            balance -= amount;
            return true;
        }    
        else
            return false;
    }

    /**
     * method withdraws from account calling method and deposits into the account specified in argument.
     * @param double amount to transfer
     * @param BankAccount to transfer the money to
     * @return bool to indicate if transfer succeeded
    */
    public boolean transfer(double amount, BankAccount accToTransTo)
    {
        if ((balance - amount) >= 0)
        {
            boolean bool1 = withdraw(amount);
            boolean bool2 = accToTransTo.deposit(amount);
            return bool1 && bool2;
        }
        else
            return false;
    }
// There are no security leaks because everything is private and all methods pass by value rather than reference, 
    //only potential security leak is with a copied account using copy constructor which does pass by reference

}