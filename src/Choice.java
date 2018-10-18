import java.util.Scanner;

public class Choice {

    public static void calculateGrade(int markInt){
        if (markInt > 69) {
            System.out.println("You got an A.");
        } else if (markInt > 59 && markInt <= 69) {
            System.out.println("You got a B.");
        } else if (markInt > 49 && markInt <= 59) {
            System.out.println("You got a C.");
        } else if (markInt > 39 && markInt <= 49) {
            System.out.println("You got a D.");
        } else if (markInt < 40) {
            System.out.println("You got an E.");
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

    public static int checkPercentage(){

        Scanner markScanner = new Scanner(System.in);
        boolean valid = false;
        int markInt = -1;
        do{
            System.out.println("Please enter your mark (percentage): ");
            String mark = markScanner.nextLine();
            try {
                markInt = Integer.parseInt(mark);
                if (markInt <= 100 && markInt >= 0) {
                    valid = true;
                    return markInt;
                } else {
                    System.out.println("That is not valid. Please enter your mark (percentage):");
                }
            } catch(NumberFormatException e){
                System.out.println("That is not valid. Please enter your mark (percentage):");
            }
        } while (!valid);
        return markInt;
    }

    public static void exit(){
        System.out.println("Goodbye.");
        System.exit(0);
    }
}
