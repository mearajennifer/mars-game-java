/*
A text-based Mars adventure game
*/

import java.util.concurrent.TimeUnit;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Game {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        long delay = 2L;
        TimeUnit time = TimeUnit.SECONDS;

        try {
            bootingUp(time, delay);

            String playerName = getPlayerName(input);

            introduceGame(playerName, input);
            time.sleep(delay);

            int numSuitcases = askNumSuitcases(input);
            time.sleep(delay);

            String[] animalFriend = askAnimalFriend(input);
            time.sleep(delay);
        
            String decorChoice = getDesign(input);

            lastMessage(playerName, numSuitcases, animalFriend, decorChoice);

            System.out.println("press ENTER to continue");
            scanner.nextLine();

            blastOff(time, playerName, animalFriend);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    // method to simulate booting up the game
    public static void bootingUp(TimeUnit time, long timeToSleep) {
        
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
        System.out.println("Your options are:");
        System.out.println(" A Sleek, modern minimalism");
        System.out.println(" B Retro/vintage space age");
        System.out.println(" C SF hippie chic");
        System.out.println("Which decor would you like? Choose A, B, or C.");
        String decorChoice;
        String decor;

        while (true) {
            System.out.print("> ");
            decorChoice = input.next();

            try {
                decorChoice = decorChoice.toUpperCase();
            } catch(InputMismatchException e) {
                System.out.println("Please only enter 'A', 'B', or 'C'!");
                continue;
            }

            if (decorChoice.equals("A")) {
                decor = "modern";
                break;
            } else if (decorChoice.equals("B")) {
                decor = "retro";
                break;
            } else if (decorChoice.equals("C")) {
                decor = "hippie";
                break;
            } else {
                System.out.println("Please only enter 'A', 'B', or 'C'!");
                continue;
            }
        }
        return decor;
    }

    public static void lastMessage(String playerName, int numSuitcases, String[]animalFriend, String decorChoice) {
        System.out.println("\nI can see it now:");
        System.out.println(String.format("%s and %s surfing the celestial abyss...", playerName, animalFriend[0]));
        System.out.println(String.format("with all their gear in %d suitcases...", numSuitcases));

        if (numSuitcases > 2) {
            System.out.println("Ahem, I mean 2 suitcases, right???");
            System.out.println("...");
        }

        System.out.println(String.format("in a %s spaceship...\n", decorChoice));    
    }

    public static void blastOff(TimeUnit time, String playerName, String[] animalFriend) {
        System.out.println(String.format("%s -- the day is here!", playerName));
        System.out.println(String.format("You crawl into the spaceship with %s...", animalFriend[0]));

        long countdown = 1L;
        long wait = 4L;

        try {
            time.sleep(wait);
            System.out.println("Brace for blast off!");
            time.sleep(countdown);
            System.out.println("5...");
            time.sleep(countdown);
            System.out.println("4...");
            time.sleep(countdown);
            System.out.println("3...");
            time.sleep(countdown);
            System.out.println("2...");
            time.sleep(countdown);
            System.out.println("1...");
            time.sleep(countdown);
            System.out.println("*** BLAST OFF ***");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }

}