import java.util.Scanner;

/**
 * Contains methods to create a menu with four options.
 *
 * @author Nick De Villiers
 * @version 1.0
 */
public class Menu {
    // All methods in this class (except main) are private, since there is no need for them to be public.

    /**
     * Main method. Creates an instance of Menu and calls processUserChoices.
     *
     * @param args args
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.processUserChoices();
    }

    /**
     * Displays the menu.
     */
    private void displayMenu() {
        System.out.println("\nPlease select one of the following options:");
        System.out.println("\n1: Calculate grade from percentage");
        System.out.println("2: Number tool (Square, Cube, Root)");
        System.out.println("3: Numbers statistics");
        System.out.println("0: Exit");
    }

    /**
     * Processes the user's input from the menu. Options are:
     * 1 - Lets them calculate a grade from a percentage.
     * 2 - Takes them to a tool to show the square, cube, and root of every integer between a user-specified lower and upper bound.
     * 3 - Shows them the total, average, maximum, and minimum of a set of numbers given by the user.
     */
    private void processUserChoices() {
        boolean finished = false; // set to true when the user wants to exit to break the loop
        Scanner choiceScanner = new Scanner(System.in);
        while (!finished) { // keeps going while the user hasn't chosen to exit
            displayMenu();
            String userChoice = choiceScanner.nextLine();
            switch (userChoice) { // Originally wrote an 'if' but IntelliJ said to use a 'switch' here.
                case "1": // User chooses option 1
                    int markInt = Choice.checkPercentage();
                    if (markInt == -1) { // -1 value indicates three failed attempts to enter a valid number.
                        System.out.println("You have entered an invalid number three times. Aborting to main menu.");
                        break;
                    } else {
                        Choice.calculateGrade(markInt);
                    }
                    break;
                case "2": // User chooses option 2
                    boolean validInput = false;
                    while (!validInput) { // Loop is broken if user's input is valid.
                        Scanner intInputScanner = new Scanner(System.in);

                        // Told the user to keep it between 1 and 100 so that they don't enter stupid numbers.
                        System.out.println("Enter an integer between 1 and 99:");
                        // If lower bound is 100, upper bound can't also be 100
                        int lowerBound = Integer.parseInt(intInputScanner.nextLine());

                        System.out.println("Enter an integer between " + (lowerBound + 1) + " and 100:");
                        // Tells them to enter a number higher than the lower bound
                        int upperBound = Integer.parseInt(intInputScanner.nextLine());

                        validInput = Choice.numberRangeInformation(lowerBound, upperBound);
                        if (!validInput) { // Catches an invalid input.
                            System.out.println("That input is invalid, please try again.");
                        }
                    }
                    break;
                case "3": // User chooses option 3
                    Choice.numbersStatistics();
                    break;
                case "0": // User chooses to exit
                    Choice.exit();
                    finished = true; // Big while loop that this is in will now break.
                    break;
                default:
                    System.out.println("That input was invalid, please try again.");
                    break;
            }
        }
    }
}
