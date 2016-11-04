/** 
 * BankAccountTest.java:  The driver class for the BankAccount class.
 * @version CPSC 233
 * @Author Nathaly Verwaal, Mea Wang
 * Copyright (c) 2016. All rights reserved.
 */
 
public class BankAccountTest {
        
    private static int accountCounter = 0;
    
    public static boolean test1(){
        System.out.println("Test1: Default Construction. Balance should be $0.00, and account number 1");
        BankAccount b = new BankAccount();
        accountCounter++;
        return Math.abs(b.getBalance() - 0.0) < 0.00001 && accountCounter == b.getAccountNumber();
    }
    
    public static boolean test2() {
        System.out.println("Test2: Construction with balance 12.34. Balance should be $12.34 and account number 2");
        BankAccount b = new BankAccount(12.34);
        accountCounter++;
        return Math.abs(b.getBalance() - 12.34) < 0.00001 && accountCounter == b.getAccountNumber();
    }
    
    public static boolean test3() {
        System.out.println("Test3: Construction with balance -12.34. Balance should be $-12.34 and account number 3");
        BankAccount b = new BankAccount(-12.34);
        accountCounter++;
        return Math.abs(b.getBalance() + 12.34) < 0.00001 && accountCounter == b.getAccountNumber();
    }
    
    public static boolean test4() {
        System.out.println("Test4: Copy Construction with balance 0.0. Balance should be $0.0 and account number 4.");
        BankAccount b = new BankAccount();
        accountCounter++;
        BankAccount copy = new BankAccount(b);
        return Math.abs(copy.getBalance() - 0.0) < 0.00001 && accountCounter == copy.getAccountNumber()
                && b != copy;
    }
    
    public static boolean test5() {
        System.out.println("Test5: Copy Construction with balance 12345.61. Balance should be $12345.61 and account number 5.");
        BankAccount b = new BankAccount(12345.61);
        accountCounter++;
        BankAccount copy = new BankAccount(b);
        return Math.abs(copy.getBalance() - 12345.61) < 0.00001 && accountCounter == copy.getAccountNumber()
                && b != copy;
    }
    
    public static boolean test6() {
        System.out.println("Test6: Copy Construction with balance -12345.61. Balance should be $-12345.61 and account number 6.");
        BankAccount b = new BankAccount(-12345.61);
        accountCounter++;
        BankAccount copy = new BankAccount(b);
        return Math.abs(copy.getBalance() + 12345.61) < 0.00001 && accountCounter == copy.getAccountNumber()
                && b != copy;
    }
    
    public static boolean test7() {
        System.out.println("Test7: Construct 5 accounts, default constructor. Balance should be $0.0 and account nums 7,8,9,10,11.");
        BankAccount b1 = new BankAccount();
        BankAccount b2 = new BankAccount();
        BankAccount b3 = new BankAccount();
        BankAccount b4 = new BankAccount();
        BankAccount b5 = new BankAccount();
        accountCounter += 5;
        return Math.abs(b1.getBalance() - 0.0) < 0.00001 && (accountCounter - 4) == b1.getAccountNumber()
                && Math.abs(b2.getBalance() - 0.0) < 0.00001 && (accountCounter - 3) == b2.getAccountNumber()
                && Math.abs(b3.getBalance() - 0.0) < 0.00001 && (accountCounter - 2) == b3.getAccountNumber()
                && Math.abs(b4.getBalance() - 0.0) < 0.00001 && (accountCounter - 1) == b4.getAccountNumber()
                && Math.abs(b5.getBalance() - 0.0) < 0.00001 && (accountCounter) == b5.getAccountNumber();
    }
    
    public static boolean test8() {
        System.out.println("Test8: Construct 5 accounts start balances 10.5,7.5,1.2,123.45,65487.4567. Account nums 12,13,14,15,16.");
        BankAccount b1 = new BankAccount(10.5);
        BankAccount b2 = new BankAccount(7.5);
        BankAccount b3 = new BankAccount(1.2);
        BankAccount b4 = new BankAccount(123.45);
        BankAccount b5 = new BankAccount(65487.4567);
        accountCounter += 5;
        return Math.abs(b1.getBalance() - 10.5) < 0.00001 && (accountCounter - 4) == b1.getAccountNumber()
                && Math.abs(b2.getBalance() - 7.5) < 0.00001 && (accountCounter - 3) == b2.getAccountNumber()
                && Math.abs(b3.getBalance() - 1.2) < 0.00001 && (accountCounter - 2) == b3.getAccountNumber()
                && Math.abs(b4.getBalance() - 123.45) < 0.00001 && (accountCounter - 1) == b4.getAccountNumber()
                && Math.abs(b5.getBalance() - 65487.4567) < 0.00001 && (accountCounter) == b5.getAccountNumber();
    }
    
    public static boolean test9() {
        System.out.println("Test9: Copy 3rd account after construct 5 accounts start balances 10.5,7.5,1.2,123.45,65487.45, Copy Account num 19");
        BankAccount b1 = new BankAccount(10.5);
        BankAccount b2 = new BankAccount(7.5);
        BankAccount b3 = new BankAccount(1.2);
        BankAccount b4 = new BankAccount(123.45);
        BankAccount b5 = new BankAccount(65487.45);
        BankAccount copy = new BankAccount(b3);
        accountCounter += 5;
        return Math.abs(copy.getBalance() - 1.2) < 0.00001 && (accountCounter - 2) == copy.getAccountNumber()
                && b3 != copy;
    }
    
    public static boolean test10() {
        System.out.println("Test10: Deposit(10.0) - Balance should be $10.00.");
        BankAccount b = new BankAccount();
        accountCounter++;
        if (!b.deposit(10.0))
            return false;
        
        return Math.abs(b.getBalance() - 10.0) < 0.00001;
    }
    
    public static boolean test11() {
        System.out.println("Test11: Deposit sequence: 5.0,4.56,11.90,16. Balance should be 37.46.");
        BankAccount b = new BankAccount();
        accountCounter++;
        if (!b.deposit(5.00))
            return false;
        if (!b.deposit(4.56))
            return false;
        if (!b.deposit(11.90))
            return false;
        if (!b.deposit(16.00))
            return false;
        return Math.abs(b.getBalance() - 37.46) < 0.00001;
    }
    
    public static boolean test12() {
        System.out.println("Test12: Deposit negative amount. Balance should remain at 0.00.");
        BankAccount b = new BankAccount();
        accountCounter++;
        if (b.deposit(-12.45))
            return false;
        return Math.abs(b.getBalance() - 0.0) < 0.00001;
    }
    
    public static boolean test13() {
        System.out.println("Test13: Withdraw 15.50 when balance is 20. Balance should be 4.50.");
        BankAccount b = new BankAccount(20.00);
        accountCounter++;
        if (!b.withdraw(15.50))
            return false;
        return Math.abs(b.getBalance() - 4.5) < 0.00001;
    }
    
    public static boolean test14() {
        System.out.println("Test14: Withdraw 20.00 when balance is 15. Balance should be unchanged.");
        BankAccount b = new BankAccount(15.00);
        accountCounter++;
        if (b.withdraw(20.0))
            return false;
        return Math.abs(b.getBalance() - 15.0) < 0.00001;
    }
    
    public static boolean test15() {
        System.out.println("Test15: Withdraw 5.00 when balance is 5.00. Resulting balance should be 0.0.");
        BankAccount b = new BankAccount(5.00);
        accountCounter++;
        if (!b.withdraw(5.00))
            return false;
        return Math.abs(b.getBalance() - 0.0) < 0.00001;
    }
    
    public static boolean test16() {
        System.out.println("Test16: Balance of 50.00, withdraw sequence: 0.50, 5.10, 20.00. Result balance should be 24.40.");
        BankAccount b = new BankAccount(50.00);
        accountCounter++;
        if (!b.withdraw(.5))
            return false;
        if (!b.withdraw(5.1))
            return false;
        if (!b.withdraw(20.0))
            return false;
        return Math.abs(b.getBalance() - 24.4) < 0.00001;
    }
    
    public static boolean test17() {
        System.out.println("Test17: Balance of acct1:50.00, acct2: 546.21, transfer 15.45 from 1 to 2. Result balances should be 34.45, 561.66.");
        BankAccount b1 = new BankAccount(50.00);
        BankAccount b2 = new BankAccount(546.21);
        accountCounter+=2;
        if (!b1.transfer(15.45,b2))
            return false;
        return Math.abs(b1.getBalance() - 34.55) < 0.00001 && Math.abs(b2.getBalance() - 561.66) < 0.00001;
    }
    
    public static boolean test18() {
        System.out.println("Test18: Balance of acct1:50.00, acct2: 546.21, transfer 50 from 1 to 2. Result balances should be 0.0, 596.21.");
        BankAccount b1 = new BankAccount(50.00);
        BankAccount b2 = new BankAccount(546.21);
        accountCounter+=2;
        if (!b1.transfer(50.00,b2))
            return false;
        return Math.abs(b1.getBalance() - 0.0) < 0.00001 && Math.abs(b2.getBalance() - 596.21) < 0.00001;
    }
    
    public static boolean test19() {
        System.out.println("Test19: Balance of acct1:50.00, acct2: 546.21, transfer 51.0 from 1 to 2. Balances should be unchanged.");
        BankAccount b1 = new BankAccount(50.00);
        BankAccount b2 = new BankAccount(546.21);
        accountCounter+=2;
        if (b1.transfer(51.00,b2))
            return false;
        return Math.abs(b1.getBalance() - 50.0) < 0.00001 && Math.abs(b2.getBalance() - 546.21) < 0.00001;
    }
    
    public static void main(String[] args) {
        String result = "";
        //System.out.print("Test 1: ");
        result = test1() ? "pass." : "failed.";
        System.out.println(result);
    
        //System.out.print("Test 2: ");
        result = test2() ? "pass." : "failed.";
        System.out.println(result);

        //System.out.print("Test 3: ");
        result = test3() ? "pass." : "failed.";
        System.out.println(result);

        //System.out.print("Test 4: ");
        result = test4() ? "pass." : "failed.";
        System.out.println(result);

        //System.out.print("Test 5: ");
        result = test5() ? "pass." : "failed.";
        System.out.println(result);

        //System.out.print("Test 6: ");
        result = test6() ? "pass." : "failed.";
        System.out.println(result);

        //System.out.print("Test 7: ");
        result = test7() ? "pass." : "failed.";
        System.out.println(result);

        //System.out.print("Test 8: ");
        result = test8() ? "pass." : "failed.";
        System.out.println(result);

        //System.out.print("Test 9: ");
        result = test9() ? "pass." : "failed.";
        System.out.println(result);

        //System.out.print("Test 10: ");
        result = test10() ? "pass." : "failed.";
        System.out.println(result);

        //System.out.print("Test 11: ");
        result = test11() ? "pass." : "failed.";
        System.out.println(result);

        //System.out.print("Test 12: ");
        result = test12() ? "pass." : "failed.";
        System.out.println(result);
        
        //System.out.print("Test 13: ");
        result = test13() ? "pass." : "failed.";
        System.out.println(result);
    
        //System.out.print("Test 14: ");
        result = test14() ? "pass." : "failed.";
        System.out.println(result);

        //System.out.print("Test 15: ");
        result = test15() ? "pass." : "failed.";
        System.out.println(result);

        //System.out.print("Test 16: ");
        result = test16() ? "pass." : "failed.";
        System.out.println(result);

        //System.out.print("Test 17: ");
        result = test17() ? "pass." : "failed.";
        System.out.println(result);

        //System.out.print("Test 18: ");
        result = test18() ? "pass." : "failed.";
        System.out.println(result);

        //System.out.print("Test 19: ");
        result = test19() ? "pass." : "failed.";
        System.out.println(result);

    }
}