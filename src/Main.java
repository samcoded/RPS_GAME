import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] choices = {"R", "P", "S"};
        String[] choicesFull = {"Rock", "Paper", "Scissors"};
        boolean userContinue = true;
        int userScore = 0;
        int cpuScore = 0;
        String userName = "User";

        System.out.print(">> What is your name? (Leave empty for default: User) ");
        String userNameInput = scanner.nextLine();
        if(!userNameInput.isEmpty()) userName = userNameInput;
        String userInputFull = "";
        String userInput = "";
        boolean playStop = true;

        while (playStop) {

        while (userContinue) {
            System.out.print(">> Select one (R=Rock, P=Paper, S=Scissors): ");
            userInput = scanner.nextLine();
            userInput = userInput.toUpperCase();

            for (int i = 0; i < choices.length; i++) {
                if (choices[i].equals(userInput)) {
                    userInputFull = choicesFull[i];
                    userContinue = false;
                }
            }
            if(userContinue){
                System.out.println(">> Enter a valid input");
            }
        }

        Random random = new Random();
        int randValue = random.nextInt(2);
        String cpuChoice = choices[randValue];
        String cpuChoiceFull = choicesFull[randValue];


        System.out.printf("%s %s - %s CPU \n", userName, userInputFull, cpuChoiceFull);

          /*
        ROCK beat SCISSORS,
        SCISSORS beat PAPER,
        PAPER beat ROCK
         */

        if (cpuChoice.equals(userInput)) {
            System.out.println("Tie");
            userContinue = true;
            continue; //restart and make selection
        } else if (userInput.equals("R") && cpuChoice.equals("S")) {
            System.out.println(userName +" wins");
            userScore++;
        } else if (userInput.equals("S") && cpuChoice.equals("P")) {
            System.out.println(userName +" wins");
            userScore++;
        } else if (userInput.equals("P") && cpuChoice.equals("R")) {
            System.out.println(userName +" wins");
            userScore++;
        } else {
            System.out.println("CPU wins");
            cpuScore++;
        }
            System.out.printf("CURRENT SCORE: %s %d - %d CPU \n", userName, userScore, cpuScore);

            System.out.print(">> Select one (C=Continue, ANY OTHER KEY TO QUIT): ");
            String userOpt = scanner.nextLine();
            userOpt = userOpt.toUpperCase();

            if (!userOpt.equals("C")){
                playStop = false; // end game
                System.out.printf("FINAL SCORE: %s %d - %d CPU \n", userName, userScore, cpuScore);
                String msg ;
                if (userScore>cpuScore){
                    msg = userName + " wins overall. HURRAY";
                } else if (cpuScore>userScore) {
                    msg = "CPU wins overall. Sad! Try Again";
                } else {
                    msg = "Overall tie!";
                }
                System.out.println(msg);
                System.out.println("Thank you for playing.");

            } else {
                userContinue = true;
            }

    }

    }
}