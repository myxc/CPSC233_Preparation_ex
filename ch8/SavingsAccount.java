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
        setInterestRate(rate);
    }

    /**
     * Creates savings account with starting balance, interest rate and min balance as args
     * @param startBalance initial balance of new account
     * @param rate inerest rate for the account
     * @param minBalance the minimum balance of the account
    */
    public SavingsAccount(double startBalance, double rate, double minBalance) {
        this(startBalance, rate);
        setMinimumBalance(minBalance);
    }

    /**
     * Sets interestRate to specified rate
     * @param rate rate to set interestRate variable
    */
    public void setInterestRate(double rate) {
        if (rate <= 1.0 && 0 <= rate)
            {this.interestRate = rate;}
        else
            interestRate = 0;
    }

    /**
     * Returns interestRate variable
     * @return interestRate variable
    */
    public double getInterestRate() {
        return this.interestRate;
    }

    /**
     * sets minimumbalance variable to specified value
     * @param minBal the new value for the minimum balance
    */
    public void setMinimumBalance(double minBal) {
        if (minBal > 0)
        {
            this.minimumBalance = minBal;
        }
        else
            minimumBalance = 0;
    }

    /**
     * returns minimum balance variable
     * @return minimumBalance variable as a double value
    */
    public double getMinimumBalance() {
        return minimumBalance;
    }

    /**
     * computes interest based on account balance, deposits interest into the account.
    */
    public void addInterest() {
        double interestAmount = getBalance() * getInterestRate();
        deposit(interestAmount);
    }

    public SavingsAccount(SavingsAccount accToCopy)
    {
        super(accToCopy);
        setInterestRate(accToCopy.getInterestRate());
        setMinimumBalance(accToCopy.getMinimumBalance());
    }

    public boolean withdraw(double withdrawAmount)
    {
        if (getBalance() - withdrawAmount < minimumBalance)
        {
            return false;
        }
        else
        {
            super.withdraw(withdrawAmount);
            return true;
        }
    }

    public boolean transfer(double transferAmount, BankAccount accountToTransfer)
    {
        if (getBalance() - transferAmount < minimumBalance)
        {
            return false;
        }
        else
        {
            super.transfer(transferAmount, accountToTransfer);
            return true;
        }
    }

    
}