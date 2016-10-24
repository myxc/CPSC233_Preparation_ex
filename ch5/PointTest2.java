/** 
 * PointTest.java:  The driver class for the Point class.
 * @version CPSC 233
 * @Author Nathaly Verwaal, Mea Wang
 * Copyright (c) 2016. All rights reserved.
 */

public class PointTest2
{
    // test distance - same point - distance is 0
    public static boolean test1() 
    {
        Point p1 = new Point(4, 6);
        Point p2 = new Point(4, 6);
        Double distance = p1.distance(p2);
        return Math.abs(distance - 0.0) < 0.00001;
    }
    
    // test distance - from (0,0) to NE quadrant point
    public static boolean test2() 
    {
        Point p1 = new Point();
        Point p2 = new Point(3, 4);
        Double distance = p1.distance(p2);
        return Math.abs(distance - 5.0) < 0.00001;
    }
    
    // test distance from NE to SW
    public static boolean test3() 
    {
        Point p1 = new Point(3, 6);
        Point p2 = new Point(-6, -2);
        Double distance = p1.distance(p2);
        return Math.abs(distance - 12.04159) < 0.00001;
    }
    
    // test equals - same point
    public static boolean test4() 
    {
        Point p = new Point(3, 4);
        return p.equals(p);
    }
    
    // test equals - same xcoord, different ycoord
    public static boolean test5() 
    {
        Point p1 = new Point(3, 4);
        Point p2 = new Point(3, 5);
        return !p1.equals(p2);
    }
    
    // test equals - same ycoord, different xcoord
    public static boolean test6() 
    {
        Point p1 = new Point(3, 4);
        Point p2 = new Point(5, 4);
        return !p1.equals(p2);
    }
    
    // test equals - x and ycoords negated
    public static boolean test7() 
    {
        Point p1 = new Point(3, 4);
        Point p2 = new Point(-3, -4);
        return !p1.equals(p2);
    }
    
    // test equals - two different points with same x and ycoords
    public static boolean test8() 
    {
        Point p1 = new Point(3, 4);
        Point p2 = new Point(3, 4);
        return p1.equals(p2);
    }
    
    // test toString - positive coordinates
    public static boolean test9() 
    {
        Point p = new Point(3, 4);
        return p.toString().equals("(3,4)");
    }
    
    // test toString - negative coordinates
    public static boolean test10() 
    {
        Point p = new Point(-3, -4);
        return p.toString().equals("(-3,-4)");
    }
    
    // test add - two points with negative coordinates
    public static boolean test11() 
    {
        Point p1 = new Point(-7, -4);
        Point p2 = new Point(-3, -4);
        Point actual = p1.add(p2);
        return p1.toString().equals("(-7,-4)") && p2.toString().equals("(-3,-4)")
               && actual.toString().equals("(-10,-8)");
    }
    
    // test add - two points with (0,0)
    public static boolean test12() 
    {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 4);
        Point actual = p1.add(p2);
        return p1.toString().equals("(0,0)") && p2.toString().equals("(3,4)")
               && actual.toString().equals("(3,4)");
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

    }
}