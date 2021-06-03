/*
A text-based Mars adventure game
*/

import java.util.concurrent.TimeUnit;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Game {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long delayNextSection = 1L;
        TimeUnit time = TimeUnit.SECONDS;

        bootingUp();

        try {
            String playerName = getPlayerName(input);
            time.sleep(delayNextSection);

            introduceGame(playerName, input);
            time.sleep(delayNextSection);

            int numSuitcases = askNumSuitcases(input);
            time.sleep(delayNextSection);

            String[] animalFriend = askAnimalFriend(input);
            time.sleep(delayNextSection);
        
            String decorChoice = getDesign(input);
            System.out.println(decorChoice);
            time.sleep(delayNextSection);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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

    // method to introduce game and ask player excitement
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

    // method to query user about # of suitcases
    public static int askNumSuitcases(Scanner input) {
        System.out.println("\nIt's time to pack for your trip to Mars.");
        System.out.println("How many suitcases do you plan to bring?");
        int suitcases;
        
        while (true) {
            System.out.print("> ");
            try {
                suitcases = input.nextInt();
                break;
            } catch(InputMismatchException e){
                String bad_input = input.next();
                System.out.println("Please enter a whole number!");
                continue;
            }
        }

        if (suitcases > 2) {
            System.out.println("That's way too many. You'll have to pack more lightly.");
            System.out.println("Please try to fit your stuff into 2 suitcases.");
        } else if (suitcases == 2) {
            System.out.println("That's perfect!");
        } else if (suitcases < 2) {
            System.out.println("Wow, you really know how to pack lightly!");
        }

        return suitcases;
    }

    public static String[] askAnimalFriend(Scanner input) {
        System.out.println("\nYou're allowed to bring one companion animal with you.");
        System.out.println("What kind of companion animal would you like to bring?");
        System.out.print("> ");
        String animalKind = input.next();
        System.out.println("What is your companion's name?");
        System.out.print("> ");
        String animalName = input.next();
        System.out.println(String.format("Cool, so you're bringing %s the %s.", animalName, animalKind));

        String[] animal = {animalName, animalKind};
        return animal;

    }

    public static String getDesign(Scanner input) {
        System.out.println("\nNASA has an interior design team offering to outfit your space ship.");
        System.out.println("You have a couple of options for the decor:");
        System.out.println("\nYour options are:");
        System.out.println(" A Sleek, modern minimalism");
        System.out.println(" B Retro/vintage space age");
        System.out.println(" C SF hippie chic");
        System.out.println("Which decor would you like? Choose A, B, or C.");
        String decor;

        while (true) {
            System.out.print("> ");
            decor = input.next();

            try {
                decor = decor.toUpperCase();
            } catch(InputMismatchException e) {
                System.out.println("Please only enter 'A', 'B', or 'C'!");
                continue;
            }

            if (decor.equals("A") || decor.equals("B") || decor.equals("C")) {
                break;
            } else {
                System.out.println("Please only enter 'A', 'B', or 'C'!");
                continue;
            }
        }
        return decor;
    }


}