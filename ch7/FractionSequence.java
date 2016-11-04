import java.util.Scanner;

public class FractionSequence{
    private Fraction[] fractions;
    public FractionSequence(int numOfFractions) {
        Scanner keyboard = new Scanner(System.in);
        fractions = new Fraction[numOfFractions];
        for (int index = 0; index < numOfFractions; index++) {
            System.out.print("Enter numerator for fraction " + (index + 1) + ": ");
            int numerator = keyboard.nextInt();
            System.out.print("Enter denominator for fraction " + (index + 1) + ": ");
            int denominator = keyboard.nextInt();
            System.out.println();
            //Fraction f = new Fraction(numerator,denominator);
            //fractions[index] = f;
            fractions[index] = new Fraction(numerator,denominator);
        }
    }

    public int count(Fraction fractionToCount) {
        int counter = 0;
        for (int index = 0; index < fractions.length; index++) {
            if (fractionToCount.equals(fractions[index])) {
            counter++;
            }
        }
        return counter;
    }

    public Fraction multiplyAll() {
        Fraction multAll = null;
        if (fractions.length >= 1) {
            multAll = fractions[0];
            for (int index = 1; index < fractions.length; index++) {
                multAll = multAll.multiply(fractions[index]);
            }
        }
        return multAll;
    }

    public static void main(String[] args) {
        int numOfFractions = Integer.parseInt(args[0]);
        FractionSequence sequence = new FractionSequence(numOfFractions);
        int count = sequence.count(new Fraction(1,2));
        Fraction multAll = sequence.multiplyAll();

        System.out.printf("The sequence has %d fractions equal to a half.\n", count);
        System.out.printf("The sequence multiplied results in %s.\n", multAll);
    }	    
}