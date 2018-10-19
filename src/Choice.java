import java.util.Scanner;

/**
 * Contains static methods for menu options.
 * @author Nick De Villiers
 * @version 1.0
 */
class Choice {

    /**
     * Calculates a grade from a user input (percentage) according to these grade boundaries:
     * A: >69
     * B: >59
     * C: >49
     * D: >39
     * E: <40
     * @param markInt Integer of the percentage given by the user.
     */
    static void calculateGrade(int markInt){

        // numbers are basically grade boundaries.
        if (markInt > 69) {
            System.out.println("You got an A.");
        } else if (markInt > 59) {
            System.out.println("You got a B.");
        } else if (markInt > 49) {
            System.out.println("You got a C.");
        } else if (markInt > 39) {
            System.out.println("You got a D.");
        } else {
            System.out.println("You got an E.");
        }
    }

    /**
     * Gives information on a range of integers determined by the user, who inputs a lower and upper bound.
     *
     * The value, square, cube, and square root of each number is shown individually in a table.
     * @param lowerBound Integer of the lower bound to calculate from
     * @param upperBound Integer of the upper bound to calculate from
     * @return Boolean "validInput"; handling an invalid input happens where this method is called.
     */
    static boolean numberRangeInformation(int lowerBound, int upperBound){
        boolean validInput = false;

        // Line below makes sure that the upper bound and lower bound are actually valid.
        if (upperBound > lowerBound && upperBound <= 100 && lowerBound >= 1){
        /*
         Limited to between 1 and 100 for my sake, prevents stupid number being chucked in.
         */
            validInput = true;

            // headers
            System.out.print("Value");
            System.out.print("\tSquare");
            System.out.print("\tCube");
            System.out.print("\tSquare Root");
            // \t puts things nicely in line.

            for (int i = lowerBound; i<= upperBound; i++){
                // information
                System.out.print("\n" + i);
                System.out.print("\t\t" + i*i);
                System.out.print("\t\t" + (i*i)*i);
                System.out.printf("\t\t%.2f", Math.sqrt(i));
            }
        }
        return validInput; /* returns this so that the function where it's called can tell the user what to do if
                              they've messed up somehow. */
    }

    /**
     * Shows the total, average, minimum and maximum of any number of integers that the user enters.
     */
    static void numbersStatistics(){
        int total = 0;
        float average = 0;
        int min = 0;
        int max = 0;

        boolean finished = false;

        int count = 0;
        Scanner inputScanner = new Scanner(System.in);

        while (!finished){ // continues while the user isn't finished putting numbers in
            System.out.println("Enter an integer, or enter -1 if you are finished:");
            String userInput = inputScanner.nextLine();

            if (userInput.equals("-1")){ // ends when user enters -1
                if (count > 0) {
                    finished = true;
                } else {
                    System.out.println("Please enter a number first."); // makes them enter a number before they quit
                }
            } else {
                try{
                    int number = Integer.parseInt(userInput);
                    count += 1;
                    total += number;
                    average = (average*(count - 1) + number)/count;

                    // statement below figures out if the new number is the maximum and/or minimum, or neither.
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
                } catch (NumberFormatException e) { // Makes sure input is a valid int.
                    System.out.println("That is not an integer. Please enter an integer.");
                }
            }
        }

        // Prints information after user has entered all the numbers they desire.
        System.out.println("Total: " + total);
        System.out.printf("Average: %.2f", average);
        System.out.println("\nMinimum value: " + min);
        System.out.println("Maximum value: " + max);
    }

    /**
     * Input validity check for the grade calculator. Ensures that the user enters an integer between 0 and 100.
     * If the user fails to enter a valid integer three times, -1 will be returned.
     * @return Integer "markInt", the mark that the user entered if valid, or -1 if the user failed to enter a valid integer.
     */
    static int checkPercentage(){

        Scanner markScanner = new Scanner(System.in);
        boolean valid = false;
        int failedAttempts = 0;
        int markInt = -1; // 0 is still a valid mark, -1 made the most sense.

        do{
            if (failedAttempts > 2){ // User cannot try more than three times in a row
                break;
            } else {
                System.out.println("Please enter your mark (percentage): ");
                String mark = markScanner.nextLine();

                try {
                    markInt = Integer.parseInt(mark);
                    if (markInt <= 100 && markInt >= 0) {
                        valid = true; // loop will now break
                    } else {
                        System.out.println("That is not valid. Please enter your mark (percentage):");
                        failedAttempts += 1;
                        markInt = -1; // Resets markInt to -1 since it was set to Integer.parseInt(mark) before.
                    }
                } catch(NumberFormatException e) { // This happens if the user doesn't enter a valid integer.
                    System.out.println("That is not valid. Please enter your mark (percentage):");
                    failedAttempts += 1;
                    markInt = -1; //  Resets markInt to -1, just in case.
                }
            }
        } while (!valid); // Loop will continue while the inputs have been invalid.
        return markInt;
    }

    /**
     * Method to exit the program through a menu option.
     */
    static void exit(){
        System.out.println("Goodbye.");
        System.exit(0); // Closes program like normal.
    }
}
