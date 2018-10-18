import java.util.Scanner;

public class Menu {

    public void displayMenu(){
        System.out.println("Please select one of the following options:");
        System.out.println("1: Option One");
        System.out.println("2: Option Two");
        System.out.println("3: Option Three");
        System.out.println("0: Exit");
    }

    public void processUserChoices(){
        Scanner userChoice = new Scanner(System.in);
        displayMenu();
        if(userChoice.equals("1")){
            Choice.choice1();
        } else if(userChoice.equals("2")){
            Choice.choice2();
        } else if(userChoice.equals("3")){
            Choice.choice3();
        } else if(userChoice.equals("")){
            Choice.exit();
        } else {
            System.out.println("That choice was shite, try again ya dumb cunt");
        }
    }
}
