/** 
 * BankTest.java:  The driver class for the Bank class.
 * @version CPSC 233
 * @Author Nathaly Verwaal, Mea Wang
 * Copyright (c) 2016. All rights reserved.
 */

public class BankTest {
    public static boolean test1() {
        System.out.println("Test1: Create Bank. Should have 0 account.");
        Bank b = new Bank();
        return b.numAccounts == 0;
    }
    
    public static boolean test2() {
        System.out.println("Test2: Create Bank and add one account.");
        Bank b = new Bank();
        if (!b.addAccount(new BankAccount()))
            return false;
            
        BankAccount b1 = b.getAccount(1);
        if (b1 == null)
            return false;
        else
            return Math.abs(b1.getBalance() - 0.0) < 0.00001;
    }
    
    public static boolean test3() {
        System.out.println("Test3: Create Bank and add four accounts.");
        Bank b = new Bank();
        if (!b.addAccount(new BankAccount()))
            return false;
        if (!b.addAccount(new BankAccount()))
            return false;
        if (!b.addAccount(new BankAccount()))
            return false;
        if (!b.addAccount(new BankAccount()))
            return false;
        BankAccount b1 = b.getAccount(2);
        BankAccount b2 = b.getAccount(3);
        BankAccount b3 = b.getAccount(4);
        BankAccount b4 = b.getAccount(5);
        if (b1 == null || b2 == null || b3 == null || b4 == null)
            return false;
        else
            return Math.abs(b1.getBalance() - 0.0) < 0.00001 && Math.abs(b2.getBalance() - 0.0) < 0.00001
                && Math.abs(b3.getBalance() - 0.0) < 0.00001 && Math.abs(b4.getBalance() - 0.0) < 0.00001;
    }

    public static boolean test4() {
         System.out.println("Test4: Create Bank and add five accounts. The last one should not be added.");
         Bank b = new Bank();
         if (!b.addAccount(new BankAccount()))
             return false;
         if (!b.addAccount(new BankAccount()))
             return false;
         if (!b.addAccount(new BankAccount()))
             return false;
         if (!b.addAccount(new BankAccount()))
             return false;
         if (b.addAccount(new BankAccount()))
             return false;
         BankAccount b1 = b.getAccount(6);
         BankAccount b2 = b.getAccount(7);
         BankAccount b3 = b.getAccount(8);
         BankAccount b4 = b.getAccount(9);
         BankAccount b5 = b.getAccount(10);
         if (b1 == null || b2 == null || b3 == null || b4 == null || b5 != null)
             return false;
         else
             return Math.abs(b1.getBalance() - 0.0) < 0.00001 && Math.abs(b2.getBalance() - 0.0) < 0.00001
                 && Math.abs(b3.getBalance() - 0.0) < 0.00001 && Math.abs(b4.getBalance() - 0.0) < 0.00001;
     }
    
     public static boolean test5() {
          System.out.println("Test5: Create Bank and add and remove accounts.");
          Bank b = new Bank();
          if (!b.addAccount(new BankAccount()))
              return false;
          if (!b.addAccount(new BankAccount()))
              return false;
          if (!b.addAccount(new BankAccount()))
              return false;
          if (!b.addAccount(new BankAccount()))
              return false;
          if (!b.removeAccount(12))
              return false;
          if (!b.addAccount(new BankAccount()))
              return false;
          BankAccount b1 = b.getAccount(11);
          BankAccount b2 = b.getAccount(12);
          BankAccount b3 = b.getAccount(13);
          BankAccount b4 = b.getAccount(14);
          BankAccount b5 = b.getAccount(15);
          if (b1 == null || b2 != null || b3 == null || b4 == null || b5 == null)
              return false;
          else
              return Math.abs(b1.getBalance() - 0.0) < 0.00001 && Math.abs(b3.getBalance() - 0.0) < 0.00001
                  && Math.abs(b4.getBalance() - 0.0) < 0.00001 && Math.abs(b5.getBalance() - 0.0) < 0.00001;
    }

     public static boolean test6() {
          System.out.println("Test6: Create Bank and add and remove accounts.");
          Bank b = new Bank();
          if (!b.addAccount(new BankAccount(5.0)))
              return false;
          if (!b.addAccount(new BankAccount(10.0)))
              return false;
          if (!b.addAccount(new BankAccount(15.5)))
              return false;
          if (!b.addAccount(new BankAccount(20.5)))
              return false;
          if (b.removeAccount(12))
              return false;
          BankAccount b1 = b.getAccount(16);
          BankAccount b2 = b.getAccount(17);
          BankAccount b3 = b.getAccount(18);
          BankAccount b4 = b.getAccount(19);
          if (b1 == null || b2 == null || b3 == null || b4 == null)
              return false;
          else
              return Math.abs(b1.getBalance() - 5.0) < 0.00001 && Math.abs(b2.getBalance() - 10.0) < 0.00001
                  && Math.abs(b3.getBalance() - 15.5) < 0.00001 && Math.abs(b4.getBalance() - 20.5) < 0.00001;
    }

    
    public static boolean test7() {
        System.out.println("Test7: Transfer momeny.  Should fail because one of the account does not exist.");
        Bank b = new Bank();
        if (!b.addAccount(new BankAccount(45.50)))
            return false;
        if (!b.addAccount(new BankAccount(100.00)))
            return false;
        return !b.transfer(20, 22, 5.0);
    }

    public static boolean test8() {
        System.out.println("Test7: Transfer momeny.  Should fail because there is no sufficient fund in the from account.");
        Bank b = new Bank();
        if (!b.addAccount(new BankAccount(45.50)))
            return false;
        if (!b.addAccount(new BankAccount(100.00)))
            return false;
        return !b.transfer(22, 23, 50.0) && Math.abs(b.getAccount(22).getBalance() - 45.50) < 0.00001
              && Math.abs(b.getAccount(23).getBalance() - 100.00) < 0.00001;
    }

    public static boolean test9() {
        System.out.println("Test8: Transfer momeny.  Should success with new balances (40.50, 105.00).");
        Bank b = new Bank();
        if (!b.addAccount(new BankAccount(45.50)))
            return false;
        if (!b.addAccount(new BankAccount(100.00)))
            return false;
        return b.transfer(24, 25, 5.0) && Math.abs(b.getAccount(24).getBalance() - 40.50) < 0.00001
              && Math.abs(b.getAccount(25).getBalance() - 105.00) < 0.00001;
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

    }
    
}