/** 
 * GradesTest.java:  A class testing the Grades class.
 * @version CPSC 233
 * @Author Nathaly Verwaal, Mea Wang
 * Copyright (c) 2016. All rights reserved.
 */

import java.util.Scanner;

public class GradesTest {
    static Grades grades; 
    
    public static void test1(int numOfGrades) {
        // Get the grades from the user on creation.
        grades = new Grades(numOfGrades);
    }

    public static void test2() {
        System.out.println("Average: " + grades.getAverage());
    }

    public static void test3() {
        System.out.println("Lowest grade: " + grades.getMin());
    }
    
    public static void test4() {
        System.out.println("Highest grade: " + grades.getMax());
    }
    
    public static void main(String[] args) {

        System.out.println("Test 1 (prompt user for input): ");
        int numOfGrades = Integer.parseInt(args[0]);
        test1(numOfGrades);
        
        System.out.println("Test 2 (get average): ");
        test2();
        
        System.out.println("Test 3 (get the lowest grade): ");
        test3();

        System.out.println("Test 4 (get the highest grade): ");
        test4();

        double[] cutoffs = {50.0, 60.0, 70.0, 80.0, 90.0, 100.0};
        grades.groupGradesIntoRanges(cutoffs);
    }
}