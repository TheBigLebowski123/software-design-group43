package softwaredesign;

import java.util.Random;
import java.util.Scanner;


public class Minigame {
    private int happinessIncrease = 0;
    private int healthIncrease = 0;
    private int level = 1;



    public int getHappinessIncrease() { return happinessIncrease; }
    public int getHealthIncrease() { return healthIncrease; }


    private String levelCode () {
        Random random = new Random();
        String code = "";

        for (int i = 0; i<level; i++) {
            int currInt = random.nextInt(36) + 48;
            if (currInt > 57) { currInt += 7; }
            code += Character.toString((char) currInt);
        }
        return code;
    }

    private void countDown (int time) {
        for (int i = time; i >= 0; i--) {
            wait (1000);
            System.out.print(i + " ");
        }
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public boolean playLevel() {
        Scanner myObj = new Scanner(System.in);
        String secretCode = levelCode();

        happinessIncrease += 2;
        healthIncrease += 1;

        if (level == 1) { System.out.println("Your tamagotchi is playing secret code!"); }
        System.out.println("Level " + level + "!");
        wait (1000);
        System.out.println("Memorize the following secret code: " + secretCode);
        countDown(2+level);

        System.out.println("What was the secret code?");
        String userInput = myObj.nextLine();

        if (userInput.equals(secretCode)) {
            System.out.println("Correct!");
            return true;
        }
        else {
            System.out.println("Incorrect!");
            return false;
        }
    }

    private static void wait(int ms) {
        try {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    public void playGame() {
        while (playLevel()) {
            level++;
        }
    }
}

