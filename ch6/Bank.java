/** 
 * Class that represents a Bank entity that contains a list of BankAccounts
 * @version CPSC 233
 * @Author Nathaly Verwaal, Mea Wang
 * Copyright (c) 2016. All rights reserved.
 */

public class Bank{
    /** The four bank accounts contained by this bank.*/
    private BankAccount account1;
    private BankAccount account2;
    private BankAccount account3;
    private BankAccount account4;
    public int numAccounts = 0;
    
    /**
     * Creates a new Bank that contains four accounts, each with a default
     * starting balance of $0.
     */
    public Bank() 
    {
        account1 = null;
        account2 = null;
        account3 = null;
        account4 = null;
    }

    /**
     * Gets the account in this Bank that has the specified account number.
     * If no such account exists, this method returns null.  Note that this
     * method returns the reference to the original object.  The leak is necessary
     * because we may need to operate on the account.
     * @param accountNumber the account number of the account to retrieve.
     * @return The bank account that has the specified account number.
     */
    public BankAccount getAccount(int accountNumber) 
    {
        BankAccount account = null;

        if (account1 != null && account1.getAccountNumber() == accountNumber)
            account = account1;
        else if (account2 != null && account2.getAccountNumber() == accountNumber)
            account = account2;
        else if (account3 != null && account3.getAccountNumber() == accountNumber)
            account = account3;
        else if (account4 != null && account4.getAccountNumber() == accountNumber)
            account = account4;

        return account;
    }

    /**
     * Counts number of accounts in bank that are not null
     * @return int value representing number of accounts in bank that are actual objects.
    */
    public void countAccounts()
    {
        if (account1 != null)
            numAccounts += 1;
        else if (account2 != null)
            numAccounts += 1;
        else if (account3 != null)
            numAccounts += 1;
        else if (account4 != null)
            numAccounts += 1;
    }

    /**
     * Adds the specified account to the bank.
     * @param BankAccount to be added into the bank.
     * @return true if bank has less than four accounts and no account in bank has the same account number as the specified
     *         bank account and false otherwise.
    */
    public boolean addAccount(BankAccount account)
    {
        countAccounts();
        if (numAccounts < 4 && getAccount(account.getAccountNumber()) == null)
        {
            if (account1 == null)
                account1 = account;
            else if (account2 == null)
                account2 = account;
            else if (account3 == null)
                account3 = account;
            else
                account4 = account;
            return true;
        }
        else
            return false;
    }

    /**
     * Removes the specified account from the bank.
     * @param BankAccount to be removed from the bank.
     * @return true if account is in the bank and successfully removed, false otherwise.
    */
    public boolean removeAccount(int number)
    {
        BankAccount account = null;
        if (getAccount(number) != null)
        {
            account = getAccount(number);
            if (account.equals(account1))
            {
                account1 = null;
                numAccounts -= 1;
                return true;
            }
            else if (account.equals(account2))
            {
                account2 = null;
                numAccounts -= 1;
                return true;
            }
            else if (account.equals(account3))
            {
                account3 = null;
                numAccounts -= 1;
                return true;
            }
            else if (account.equals(account4))
            {
                account4 = null;
                numAccounts -= 1;
                return true;
            }
            else 
                return false;
        }
        else return false;
    }

    /**
     * method transfers from one bank account to another for a specified double amount
     * @param int bank to withdraw money from
     * @param int bank to deposit money into
     * @param double amount to transfer
     * @return bol to indicated whether transfer succeeded.
    */
    public boolean transfer(int fromBank, int toBank, double transAmount)
    {
        boolean bool1;
        boolean bool2;
        if ((getAccount(fromBank).getBalance() - transAmount) >= 0 && getAccount(fromBank) != null && getAccount(toBank) != null)
        {
            bool1 = getAccount(fromBank).withdraw(transAmount);
            bool2 = getAccount(toBank).deposit(transAmount);
        }
        else 
        {
            bool1 = false;
            bool2 = true;
        }
        return bool1 && bool2;
    }
// no privacy leak because all methods use pass by value. 
}
