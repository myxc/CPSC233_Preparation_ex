/** 
 * SavingsAccountTest.java: The test class for SavingsAccount class.
 * @version CPSC 233
 * @Author Nathaly Verwaal, Mea Wang
 * Copyright (c) 2016. All rights reserved.
 */

public class SavingsAccountTest2 {
        
    private static int accountCounter = 0;

    public static boolean test1() {
        //System.out.println("Test1: Construction with balance 12.34 and interest rate 10% and minimum balance to 10.  Apply the interest.");
        SavingsAccount b = new SavingsAccount(12.34, 0.1, 10);
        accountCounter++;
        return Math.abs(b.getBalance() - 12.34) < 0.00001 && Math.abs(b.getFeesAndInterest() - 1.234) < 0.00001; 
    }

    public static boolean test2() {
        //System.out.println("Test2: Construction with balance 12.34 and interest rate 10% and minimum balance to 10.  Apply the interest.");
        SavingsAccount b = new SavingsAccount(12.34, 0.1, 10);
        Double expected = b.getBalance() + b.getFeesAndInterest();
        b.applyFeesAndInterest();
        accountCounter++;
        return Math.abs(b.getBalance() - 13.574) < 0.00001; 
    }

        
    public static void main(String[] args) {
        String result = "";
        System.out.print("Test 1: ");
        result = test1() ? "pass." : "failed.";
        System.out.println(result);
    
        System.out.print("Test 2: ");
        result = test2() ? "pass." : "failed.";
        System.out.println(result);

   }
}