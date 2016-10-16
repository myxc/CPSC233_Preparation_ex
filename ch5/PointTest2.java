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

    }
}