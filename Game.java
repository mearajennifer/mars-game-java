/*
A text-based Mars adventure game
*/

import java.util.concurrent.TimeUnit;

public class Game {
    public static void main(String[] args) {
        System.out.println("The game is about to start...");
        bootingUp();


    }

    // method to simulate booting up the game
    public static void bootingUp() {
        long timeToSleep = 2L;
        TimeUnit time = TimeUnit.SECONDS;
        try {
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
}