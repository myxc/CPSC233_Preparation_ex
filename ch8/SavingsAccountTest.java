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
        return Math.abs(b.getBalance() - 12.34) < 0.00001 && Math.abs(b.getInterestRate() - 0.07) < 0.00001
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
             && Math.abs(b.getMinimumBalance() - 100.0) < 0.00001 && b.getAccountNumber() == accountCounter; 
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
        return Math.abs(b.getBalance() - 12.34) < 0.00001 && Math.abs(b.getInterestRate() + 0.1) < 0.00001
            && Math.abs(b.getMinimumBalance() - 10) < 0.00001 && b.getAccountNumber() == accountCounter; 
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
   }
}