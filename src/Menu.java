import java.util.Scanner;

public class Menu {

    public static void main(String[] args){
        Menu menu = new Menu();
        menu.processUserChoices();
    }

    public void displayMenu(){
        System.out.println("Please select one of the following options:");
        System.out.println("1: Option One");
        System.out.println("2: Option Two");
        System.out.println("3: Option Three");
        System.out.println("0: Exit");
    }

    public void processUserChoices(){
        boolean finished = false;

        while(!finished) {
            Scanner choiceScanner = new Scanner(System.in);
            displayMenu();
            String userChoice = choiceScanner.nextLine();
            switch (userChoice) {
                case "1":
                    Choice.choice1();
                    break;
                case "2":
                    Choice.choice2();
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
