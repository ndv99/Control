import java.util.Scanner;

public class Menu {

    public static void main(String[] args){
        Menu menu = new Menu();
        menu.processUserChoices();
    }

    public void displayMenu(){
        System.out.println("\nPlease select one of the following options:");
        System.out.println("\n1: Calculate grade from percentage");
        System.out.println("2: Number tool (Square, Cube, Root");
        System.out.println("3: Option Three");
        System.out.println("0: Exit");
    }

    public void processUserChoices(){
        boolean finished = false;
        Scanner choiceScanner = new Scanner(System.in);
        while(!finished) {
            displayMenu();
            String userChoice = choiceScanner.nextLine();
            switch (userChoice) {
                case "1":
                    Choice.calculateGrade();
                    break;
                case "2":
                    boolean validInput = false;
                    while (!validInput) {
                        Scanner intInputScanner = new Scanner(System.in);

                        System.out.println("Enter an integer between 1 and 99:");
                        int lowerBound = Integer.parseInt(intInputScanner.nextLine());
                        System.out.println("Enter an integer between " + (lowerBound + 1) + " and 100:");
                        int upperBound = Integer.parseInt(intInputScanner.nextLine());

                        validInput = Choice.numberInformation(lowerBound, upperBound);
                        if (!validInput){
                            System.out.println("That input is invalid, please try again.");
                        }
                    }
                    break;
                case "3":
                    Choice.choice3();
                    break;
                case "0":
                    Choice.exit();
                    finished = true;
                    break;
                default:
                    System.out.println("That input was invalid, please try again.");
                    break;
            }
        }
    }
}
