/** 
 * A savings account is a bank account where interest is added to the account
 * on a regular basis.
 * @version CPSC 233
 * @Author Nathaly Verwaal, Mea Wang
 * Copyright (c) 2016. All rights reserved.
 */

public class SavingsAccount extends BankAccount {
    private double minimumBalance = 100;
    private double interestRate = 0.07;
    
    /**
     * Creates a default savings account.
     */
    public SavingsAccount() {
        super();
    }
    
    /**
     * Creates a savings account with a default interest rate and the specified
     * start balance.
     * @param startBalance the initial balance of the account that we're creating.
     */
    public SavingsAccount(double startBalance) {
        this(startBalance, .07);
    }
    
    /**
     * Creates a savings account with the specified starting balance and
     * interest rate.
     * @param startBalance the initial balance of the account we're creating.
     * @param rat the interest rate for the savings account we're creating.
     */
    public SavingsAccount(double startBalance, double rate) {
        super(startBalance);
        this.interestRate = rate;
    }
    
    /**
     * Creates a savings account with the specified starting balance and
     * interest rate.
     * @param startBalance the initial balance of the account we're creating.
     * @param rate the interest rate for the savings account we're creating.
     * @param min The minimum balance.
     */
    public SavingsAccount(double startBalance, double rate, double min) {
        super(startBalance);
        this.interestRate = rate;
        this.minimumBalance = min;
    }
    
    /**
     * Copy constructor which creates a copy of the specified account.
     * @param account the savings account to create a copy off.
     */
    public SavingsAccount(SavingsAccount account) {
        super(account);
        interestRate = account.interestRate;
        this.minimumBalance = account.minimumBalance;
    }
 
    /**
     * Change the interest for this account to the specified rate.
     * @param rate the interest rate that should be used for this account.
     */
    public void setInterestRate(double rate) {
        if (rate >= 0.0 && rate <= 1.0) {
            interestRate = rate;
        }
        else
            interestRate = 0.0;
    }

    /** Get the interest rate.
     * @return The interest rate
     */
    public double getInterestRate() {
        return interestRate;
    }
  
    /**
     * Change the interest for this account to the specified rate.
     * @param rate the interest rate that should be used for this account.
     */
    public void setMinimumBalance(double min) {
        if (min >= 0.0) {
            minimumBalance = min;
        }
        else
            minimumBalance = 0.0;
    }

    /** Get the minimum balance.
     * @return The minimum balance
     */
    public double getMinimumBalance() {
        return minimumBalance;
    }

    /**
     * Compute the interest and add it to this account.
     */
    public double getFeesAndInterest()
    {
        double interest = getBalance() * interestRate;
        return interest;
    }
    
    /** Override the method withdraw() in BankAccount.  If the withdraw would
     * result in a balance less than the minimumBalance, do nothing.  
     * Otherwise execute the withdraw in the parent class.
     * @param amount The amount to withdraw
     * @return Whether the withdraw was succssful.
     */
    public boolean withdraw(double amount) {
        if (getBalance() - amount >= minimumBalance) {
            return super.withdraw(amount);
        }
        else
            return false;
    }

    /** In this method, funds are only transferred if the resulting balance
     *  of the account will not go below the minimum balance. 
     * @param amount The ammount to transfer.
     * @param toAccount  The account to transfer the money to.
     * @return Whether the transfer was succssful.
     */
    public boolean transfer(double amount, BankAccount toAccount) {
        if (getBalance() - amount >= minimumBalance) {
            return super.transfer(amount, toAccount);
        }
        else
            return false;
    }
}