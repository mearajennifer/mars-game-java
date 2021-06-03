/*
A text-based Mars adventure game
*/

import java.util.concurrent.TimeUnit;
import java.util.Scanner;


public class Game {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        bootingUp();

        String playerName = getPlayerName(input);

        introduceGame(playerName, input);        

    }

    // method to simulate booting up the game
    public static void bootingUp() {
        long timeToSleep = 2L;
        TimeUnit time = TimeUnit.SECONDS;
        try {
            System.out.println("The game is about to start...");
            time.sleep(timeToSleep);
            System.out.println("Booting up...");
            time.sleep(timeToSleep);
            System.out.println("...");
            time.sleep(timeToSleep);
            System.out.println("...");
            time.sleep(timeToSleep);
            System.out.println("...");
            time.sleep(timeToSleep);
            System.out.println("Ready!\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    // method to get user name
    public static String getPlayerName(Scanner input) {
        System.out.println("Hi, space adventurer! What is your name?");
        System.out.print("> ");
        String playerName = input.next();
        return playerName;
    }

    // method to introduce game and get player excitement
    public static void introduceGame(String playerName, Scanner input) {
        System.out.println(String.format("\nHi, %s --- Welcome to The Mars Adventure Game!", playerName));
        System.out.println("Yesterday, you received a call from your good friend at NASA.");
        System.out.println("They need someone to go to Mars this weekend, and you've been chosen.\n");

        System.out.println("Are you excited? Type Y or N");

        while (true) {
            System.out.print("> ");
            String excitement = input.next();
            excitement = excitement.toUpperCase();

            if (excitement.equals("Y")) {
                System.out.println("I knew you'd say that. It's so cool that you're going to Mars!");
                break;
            } else if (excitement.equals("N")) {
                System.out.println("No? Well, don't worry! I'm sure you'll be ready by the end of the game.");
                break;
            } else {
                System.out.println("Please only answer with 'Y' or 'N'!");
            }

        }
    }
}