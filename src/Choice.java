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

    public static void choice2(){
        System.out.println("Method choice two exectuted.");
    }

    public static void choice3(){
        System.out.println("Method choice three exectuted.");
    }

    public static void exit(){
        System.out.println("Goodbye.");
        System.exit(0);
    }
}
