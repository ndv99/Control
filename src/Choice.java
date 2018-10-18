import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

import java.util.Scanner;

public class Choice {

    public static void calculateGrade(){
        Scanner markScanner = new Scanner(System.in);

        boolean validInput = false;
        while (!validInput) {
            System.out.println("Please enter your mark (percentage): ");
            String mark = markScanner.nextLine();
            int markInt = Integer.parseInt(mark);
            if (markInt > 69 && markInt <= 100) {
                System.out.println("You got an A.");
                validInput = true;
            } else if (markInt > 59 && markInt <= 69) {
                System.out.println("You got a B.");
                validInput = true;
            } else if (markInt > 49 && markInt <= 59) {
                System.out.println("You got a C.");
                validInput = true;
            } else if (markInt > 39 && markInt <= 49) {
                System.out.println("You got a D.");
                validInput = true;
            } else if (markInt < 40 && markInt >= 0) {
                System.out.println("You got an E.");
                validInput = true;
            } else {
                System.out.println("Dumb fuck, enter a percentage, it's between 0 and 100.");
            }
        }
    }

    public static boolean numberRangeInformation(int lowerBound, int upperBound){
        boolean validInput = false;
        if (upperBound > lowerBound && upperBound <= 100 && lowerBound >= 1){
            validInput = true;

            // headers
            System.out.print("Value");
            System.out.print("\tSquare");
            System.out.print("\tCube");
            System.out.print("\tSquare Root");

            for (int i = lowerBound, j = upperBound; i<=j; i++){
                // information
                System.out.print("\n" + i);
                System.out.print("\t\t" + i*i);
                System.out.print("\t\t" + (i*i)*i);
                System.out.printf("\t\t%.2f", Math.sqrt(i));
            }
        }
        return validInput;
    }

    public static void numbersStatistics(){
        int total = 0;
        float average = 0;
        int min = 0;
        int max = 0;

        boolean finished = false;

        int count = 0;
        Scanner inputScanner = new Scanner(System.in);
        while (!finished){
            System.out.println("Enter an integer, or enter -1 if you are finished:");
            String userInput = inputScanner.nextLine();
            if (userInput.equals("-1")){
                if (count > 0) {
                    finished = true;
                } else {
                    System.out.println("Please enter a number first.");
                }
            } else {
                try{
                    int number = Integer.parseInt(userInput);
                    count += 1;
                    total += number;
                    average = (average*(count - 1) + number)/count;
                    if (count > 1){
                        if (number > max){
                            max = number;
                        } else if (number < min){
                            min = number;
                        }
                    } else {
                        max = number;
                        min = number;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("That is not an integer. Please enter an integer.");
                }
            }
        }
        System.out.println("Total: " + total);
        System.out.printf("Average: %.2f", average);
        System.out.println("\nMinimum value: " + min);
        System.out.println("Maximum value: " + max);
    }

    public static void exit(){
        System.out.println("Goodbye.");
        System.exit(0);
    }
}
