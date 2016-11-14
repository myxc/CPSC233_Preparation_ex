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
            // do 
            // {
                grade = keyboard.nextInt();
            //     if ((grade < 0) || (grade > 100))
            //     {
            //         System.out.println("Hello the grade you entered is impossible to achieve, enter a grade between 0 and 100.");
            //     }
            // }
            // while ((grade < 0) || (grade > 100));
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

    /**
     * @param array of doubles which are the cut off grades to group the grades into
     * @return returns an array of arrays, with the first row containing all grades for first cutoff point etc.
    */
    //assuming that cutoffs are entered in order.
    //2D, first array holds each set of categorized grades
    // each element in first array is an array of grades that fit in that category.
    public void groupGradesIntoRanges(double[] cutoffs_array)
    {
        double[][] sorted_array = new double[cutoffs_array.length + 1][grades_array.length];//assuming that user entered 10 grades, case when all 10 grades fall into a certain category. 
        
        //1 for loop to create the 2d array of the size of the cutoffs array + 1 rows and columns = to the number of grades in the element
        //  the first for loop iterates through each row of the array and inside it will be another for loop.
        //  the second for loop iterates through each of the grades in the grade array and checks if it fits inside the grade cutoff for that row, which lower bound is inclusive upper bound is exclusive
        //  in the second loop there should be a counter that starts at 0 and is reset for each iteration of the row loop, to indicate the next avaiable position to put a grade in the row.

        for (int i = 0; i <= cutoffs_array.length; i++)
        {
            //the above for loop will check each row, along with an extra row for "others" which are grades that are less than 0, or greater than 100.0
            int x = 0; //this is the counter which increments if a value is assigned, indicating where the next value will be assigned to in this row.
            for (int j = 0; j < grades_array.length; j++)
            {
                //this for loop iterates through the grades array and checks to see if each value fits into the criteria for this row
                if (i == 0 && grades_array[j] < cutoffs_array[i] && grades_array[j] >= 0) //For the first row, the lower bound will be specified as 0/.
                {
                    sorted_array[i][x] = grades_array[j];
                    x++; //sorted array's row i element x will be assigned with this grade and then x will increment so the next grade won't be assigned to the same element.
                }

                if (i > 0 && i < (cutoffs_array.length) && grades_array[j] < cutoffs_array[i] && grades_array[j] >= cutoffs_array[i - 1])
                {
                    //if this is not the last row value which is reserved for numbers outside of 0 to 100 and it is not the first row, check if the grade is less than the cutoff value, but higher than or equal to the 
                    //value of the lower bound aka the previous grade cutoff.
                    sorted_array[i][x] = grades_array[j];
                    x++; //same deal with the x.
                }

                if (i == cutoffs_array.length && (grades_array[j] < 0 || grades_array[j] > 100.0))
                {
                    //for the last row of the 2d matrix which is reserved for #'s outside of 0 and 100
                    sorted_array[i][x] = grades_array[j];
                    x++;
                }
            }
        }

        for (int a = 0; a <= cutoffs_array.length; a++)
        {
            if (a != cutoffs_array.length)
            {
            System.out.print(cutoffs_array[a] + ": ");                
            }
            else 
                System.out.print("other: ");
            for (int b = 0; b < grades_array.length; b++)
            {
                System.out.print(sorted_array[a][b] + ", ");
            }
            System.out.print("\n");
        }
    }

}