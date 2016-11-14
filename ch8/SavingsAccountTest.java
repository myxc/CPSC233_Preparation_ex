/** 
 * SavingsAccountTest.java: The test class for SavingsAccount class.
 * @version CPSC 233
 * @Author Nathaly Verwaal, Mea Wang
 * Copyright (c) 2016. All rights reserved.
 */

public class SavingsAccountTest {
        
    private static int accountCounter = 0;
        
    public static boolean test1() {
        //System.out.println("Test1: Construction with balance 12345.61, interest rate 10% and minimum balance 500");
        SavingsAccount b = new SavingsAccount(12345.61,0.1,500.0);
        accountCounter++;
        return Math.abs(b.getBalance() - 12345.61) < 0.00001 && Math.abs(b.getInterestRate() - 0.1) < 0.00001
            && Math.abs(b.getMinimumBalance() - 500.0) < 0.00001 && b.getAccountNumber() == accountCounter; 
    }

    public static boolean test2() {
         ////System.out.println("Test2: Construction with balance 12.34, interest rate 0 and minimum balance 10");
         SavingsAccount b = new SavingsAccount(12.34,0.1,10.0);
         accountCounter++;
         return Math.abs(b.getBalance() - 12.34) < 0.00001 && Math.abs(b.getInterestRate() - 0.1) < 0.00001
             && Math.abs(b.getMinimumBalance() - 10.0) < 0.00001 && b.getAccountNumber() == accountCounter; 
    }

    public static boolean test3() {
         //System.out.println("Test3: Construction with balance 12.34, and then set interest rate 10%");
         SavingsAccount b = new SavingsAccount(12.34);
         b.setInterestRate(0.1);
         accountCounter++;
         return Math.abs(b.getBalance() - 12.34) < 0.00001 && Math.abs(b.getInterestRate() - 0.1) < 0.00001
             && b.getAccountNumber() == accountCounter; 
    }

    public static boolean test4() {
        //System.out.println("Test4: Construction with balance 12.34, and then set interest rate -10%");
        SavingsAccount b = new SavingsAccount(12.34);
        b.setInterestRate(-0.1);
        accountCounter++;
        return Math.abs(b.getBalance() - 12.34) < 0.00001 && Math.abs(b.getInterestRate() - 0.0) < 0.00001
            && b.getAccountNumber() == accountCounter; 
    }

    public static boolean test5() {
        //System.out.println("Test5: Construction with balance 12.34 and interest rate 10%, then set minimum balance to 10.");
        SavingsAccount b = new SavingsAccount(12.34, 0.1);
        b.setMinimumBalance(10);
        accountCounter++;
        return Math.abs(b.getBalance() - 12.34) < 0.00001 && Math.abs(b.getInterestRate() - 0.1) < 0.00001
            && Math.abs(b.getMinimumBalance() - 10.0) < 0.00001 && b.getAccountNumber() == accountCounter; 
    }

    public static boolean test6() {
        //System.out.println("Test6: Construction with balance 12.34 and interest rate 10%, then set minimum balance to -10.");
        SavingsAccount b = new SavingsAccount(12.34, 0.1);
        b.setMinimumBalance(-10);
        accountCounter++;
        return Math.abs(b.getBalance() - 12.34) < 0.00001 && Math.abs(b.getInterestRate() - 0.1) < 0.00001
             && Math.abs(b.getMinimumBalance() - 0.0) < 0.00001 && b.getAccountNumber() == accountCounter; 
    }

    public static boolean test7() {
        //System.out.println("Test7: Construction with balance 12.34 and interest rate 10% and minimum balance to 10.  Apply the interest.");
        SavingsAccount b = new SavingsAccount(12.34, 0.1, 10);
        b.addInterest();
        accountCounter++;
        return Math.abs(b.getBalance() - 13.574) < 0.00001 && Math.abs(b.getInterestRate() - 0.1) < 0.00001
              && Math.abs(b.getMinimumBalance() - 10.0) < 0.00001 && b.getAccountNumber() == accountCounter; 
    }

    public static boolean test8() {
        //System.out.println("Test8: Construction with balance 12.34 and interest rate -0.1 and minimum balance to -10.  Apply the interest.");
        SavingsAccount b = new SavingsAccount(12.34, -0.1, 10);
        b.addInterest();
        accountCounter++;
        return Math.abs(b.getBalance() - 12.34) < 0.00001 && Math.abs(b.getInterestRate() - 0.0) < 0.00001
            && Math.abs(b.getMinimumBalance() - 10) < 0.00001 && b.getAccountNumber() == accountCounter; 
    }

    public static boolean test9() {
         //System.out.println("Test9: Copy Construction with balance 12345.61, interest rate 10% and minimum balance 500");
         SavingsAccount b = new SavingsAccount(12345.61,0.1,500.0);
         accountCounter++;
         SavingsAccount copy = new SavingsAccount(b);
         // System.out.println(copy.getBalance());
         // System.out.println(copy.getInterestRate());
         // System.out.println(copy.getMinimumBalance());
         return Math.abs(copy.getBalance() - 12345.61) < 0.00001 && Math.abs(copy.getInterestRate() - 0.1) < 0.00001
                && Math.abs(copy.getMinimumBalance() - 500.0) < 0.00001 && copy.getAccountNumber() == accountCounter 
                && b != copy;
    }

     public static boolean test10() {
         //System.out.println("Test10: Copy Construction with balance 12345.61, interest rate 10% and minimum balance 500. Apply the interest to the copy.");
         SavingsAccount b = new SavingsAccount(12345.61,0.1,500.0);
         accountCounter++;
         SavingsAccount copy = new SavingsAccount(b);
         copy.addInterest();
         return Math.abs(copy.getBalance() - 13580.171) < 0.00001 && Math.abs(copy.getInterestRate() - 0.1) < 0.00001
                && Math.abs(copy.getMinimumBalance() - 500.0) < 0.00001 && copy.getAccountNumber() == accountCounter 
                && b != copy;
    }

    public static boolean test11() {
        //System.out.println("Test11: Withdraw 15.50 when balance is 1200, balance should be 1184.5.");
        SavingsAccount b = new SavingsAccount(1200, 0.1, 1000.00);
        accountCounter++;
        b.withdraw(15.50);
        return Math.abs(b.getBalance() - 1184.5) < 0.00001;
    }

    public static boolean test12() {
        //System.out.println("Test12: Withdraw 20.00 when balance is 999, balance should be unchanged.");
        SavingsAccount b = new SavingsAccount(999.00, 0.1, 1000.00);
        accountCounter++;
        b.withdraw(20.0);
        return Math.abs(b.getBalance() - 999.00) < 0.00001;
    }

    public static boolean test13() {
        //System.out.println("Test13: Withdraw 100.00 when balance is 1100.00, resulting balance should be 1000.0");
        SavingsAccount b = new SavingsAccount(1100.00, 0.1, 1000.00);
        accountCounter++;
        b.withdraw(100.00);
        return Math.abs(b.getBalance() - 1000.00) < 0.00001;
    }

    public static boolean test14() {
        //System.out.println("Test14: Balance of 1050.00, withdraw sequence: 0.50, 5.10, 20.00. Result balance should be 1024.40");
        SavingsAccount b = new SavingsAccount(1050.00, 0.1, 1000.00);
        accountCounter++;
        b.withdraw(.5);
        b.withdraw(5.1);
        b.withdraw(20.0);
        return Math.abs(b.getBalance() - 1024.40) < 0.00001;
    }

    public static boolean test15() {
        //System.out.println("Test15: Deposit 10.0 to default account.  Balance should be $10.00");
        SavingsAccount b = new SavingsAccount();
        accountCounter++;
        b.deposit(10.0);
        return Math.abs(b.getBalance() - 10.00) < 0.00001;
    }

    public static boolean test16() {
        //System.out.println("Test16: Deposit sequence: 5.0,4.56,11.90,16. Balance should be 37.46");
        SavingsAccount b = new SavingsAccount();
        accountCounter++;
        b.deposit(5.00);
        b.deposit(4.56);
        b.deposit(11.90);
        b.deposit(16.00);
        return Math.abs(b.getBalance() - 37.46) < 0.00001;
    }

    public static boolean test17() {
        //System.out.println("Test17: Deposit negative amount. Balance should remain at 0.00");
        SavingsAccount b = new SavingsAccount();
        accountCounter++;
        b.deposit(-12.45);
        return Math.abs(b.getBalance() - 0.0) < 0.00001;
    }
    
    public static boolean test18() {
        //System.out.println("Test18: Balance of acct1:1050.00, acct2: 546.21, transfer 15.45 from 1 to 2. Result balances should be 1034.45, 561.66");
        SavingsAccount b1 = new SavingsAccount(1050.00, 0.1, 1000.00);
        SavingsAccount b2 = new SavingsAccount(546.21, 0.1, 500.00);
        accountCounter+=2;
        b1.transfer(15.45,b2);
        return Math.abs(b1.getBalance() - 1034.55) < 0.00001 && Math.abs(b2.getBalance() - 561.66) < 0.00001;
    }

    public static boolean test19() {
        //System.out.println("Test19: Balance of acct1:1050.00, acct2: 546.21, transfer 50 from 1 to 2. Result balances should be 1000.0, 596.21");
        SavingsAccount b1 = new SavingsAccount(1050.00, 0.1, 1000.00);
        SavingsAccount b2 = new SavingsAccount(546.21, 0.1, 500.00);
        accountCounter+=2;
        b1.transfer(50.00,b2);
        return Math.abs(b1.getBalance() - 1000.0) < 0.00001 && Math.abs(b2.getBalance() - 596.21) < 0.00001;
    }

     public static boolean test20() {
        //System.out.println("Test20: Balance of acct1:950.00, acct2: 546.21, transfer 51.0 from 1 to 2. Balances remain unchanged.");
        SavingsAccount b1 = new SavingsAccount(950.00, 0.1, 1000.00);
        SavingsAccount b2 = new SavingsAccount(546.21, 0.1, 500.00);
        accountCounter+=2;
        b1.transfer(51.00,b2);
        return Math.abs(b1.getBalance() - 950.00) < 0.00001 && Math.abs(b2.getBalance() - 546.21) < 0.00001;
    }
        
    public static void main(String[] args) {
        String result = "";
        System.out.print("Test 1: ");
        result = test1() ? "pass." : "failed.";
        System.out.println(result);
    
        System.out.print("Test 2: ");
        result = test2() ? "pass." : "failed.";
        System.out.println(result);

        System.out.print("Test 3: ");
        result = test3() ? "pass." : "failed.";
        System.out.println(result);

        System.out.print("Test 4: ");
        result = test4() ? "pass." : "failed.";
        System.out.println(result);

        System.out.print("Test 5: ");
        result = test5() ? "pass." : "failed.";
        System.out.println(result);

        System.out.print("Test 6: ");
        result = test6() ? "pass." : "failed.";
        System.out.println(result);

        System.out.print("Test 7: ");
        result = test7() ? "pass." : "failed.";
        System.out.println(result);

        System.out.print("Test 8: ");
        result = test8() ? "pass." : "failed.";
        System.out.println(result);

        System.out.print("Test 9: ");
        result = test9() ? "pass." : "failed.";
        System.out.println(result);

        System.out.print("Test 10: ");
        result = test10() ? "pass." : "failed.";
        System.out.println(result);

        System.out.print("Test 11: ");
        result = test11() ? "pass." : "failed.";
        System.out.println(result);

        System.out.print("Test 12: ");
        result = test12() ? "pass." : "failed.";
        System.out.println(result);

        System.out.print("Test 13: ");
        result = test13() ? "pass." : "failed.";
        System.out.println(result);
    
        System.out.print("Test 14: ");
        result = test14() ? "pass." : "failed.";
        System.out.println(result);

        System.out.print("Test 15: ");
        result = test15() ? "pass." : "failed.";
        System.out.println(result);

        System.out.print("Test 16: ");
        result = test16() ? "pass." : "failed.";
        System.out.println(result);

        System.out.print("Test 17: ");
        result = test17() ? "pass." : "failed.";
        System.out.println(result);

        System.out.print("Test 18: ");
        result = test18() ? "pass." : "failed.";
        System.out.println(result);

        System.out.print("Test 19: ");
        result = test19() ? "pass." : "failed.";
        System.out.println(result);

        System.out.print("Test 20: ");
        result = test20() ? "pass." : "failed.";
        System.out.println(result);
   }
}