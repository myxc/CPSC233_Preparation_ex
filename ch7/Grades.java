import java.util.Scanner;

public class Grades {
    private int[] grades_array;
    /**
     * @param integer for how many grades will be in this Grades object, and prompts user for it.
    */
    public Grades(int numOfGrades) {
        System.out.println("You have indicated that there are " + numOfGrades + " grades to be entered. Please enter them.");
        Scanner keyboard = new Scanner(System.in);
        grades_array = new int[numOfGrades];
        for (int i = 0; i < numOfGrades; i++)
        {
            int grade;
            do 
            {
                grade = keyboard.nextInt();
                if ((grade < 0) || (grade > 100))
                {
                    System.out.println("Hello the grade you entered is impossible to achieve, enter a grade between 0 and 100.");
                }
            }
            while ((grade < 0) || (grade > 100));
            grades_array[i] = grade;
        }
    }
    /**
     * @return the average of grades in the array
    */
    public double getAverage() {
        int sum = 0;
        for (int i = 0; i < grades_array.length; i++)
        {
            sum += grades_array[i];
        }
        return (sum/grades_array.length);
    }
    /**
     * @return the point value of the lowest grade provided
    */
    public double getMin() {
        int min = 0;
        for (int i = 0; i < grades_array.length; i++)
        {
            if (i == 0)
                min = grades_array[i];
            else if (grades_array[i] < min)
                min = grades_array[i];
            else 
                continue;
        }
        return min;
    }
    /**
     * @return the point value of the highest grade provided
    */
    public double getMax() {
        int max = 1000;
        for (int i = 0; i < grades_array.length; i++)
        {
            if (i == 0)
                max = grades_array[i];
            else if (grades_array[i] > max)
                max = grades_array[i];
            else 
                continue;
        }
        return max;
    }

}