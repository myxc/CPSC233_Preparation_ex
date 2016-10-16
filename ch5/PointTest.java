/** 
 * PointTest.java:  The driver class for the Point class.
 * @version CPSC 233
 * @Author Nathaly Verwaal, Mea Wang
 * Copyright (c) 2016. All rights reserved.
 */

public class PointTest{
    public static boolean test1()
    {
        Point p = new Point();
        p.moveUp(1);
        return (p.getX() == 0) && (p.getY() == 1);
    }
    
    public static boolean test2() 
    {
        Point p = new Point(-7, 14);
        p.moveDown(10);
        return (p.getX() == -7) && (p.getY() == 4);
    }
    
    public static boolean test3() 
    {
        Point p = new Point();
        p.moveLeft(8);
        return (p.getX() == -8) && (p.getY() == 0);
    }
    
    public static boolean test4() 
    {
        Point p = new Point(-7, 14);
        p.moveRight(198);
        return (p.getX() == 191) && (p.getY() == 14);
    }
    
    public static boolean test5() {
         Point p = new Point(-7, 14);
         return (p.quadrant().equals("NW"));
     }

     public static boolean test6() {
         Point p = new Point();
         return (p.quadrant().equals("origin"));
     }

     public static boolean test7() {
         Point p = new Point(-1, -1);
         return (p.quadrant().equals("SW"));
     }

     public static boolean test8() {
         Point p = new Point(13, 0);
         p.moveDown(4);
         return (p.quadrant().equals("SE"));
     }
    
    public static void main(String[] args)
    {
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