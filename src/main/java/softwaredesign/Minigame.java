package softwaredesign;

import java.util.Random;
import java.util.Scanner;


public class Minigame {
    int statChange = 0;
    int level = 1;
    String levelCode () {
        Random random = new Random();
        String code = "";

        for (int i = 0; i<level; i++) {
            int currInt = random.nextInt(36) + 48;
            if (currInt > 57) { currInt += 7; }
            code += Character.toString((char) currInt);
        }
        return code;
    }

    void countDown (int time) {
        for (int i = time; i >= 0; i--) {
            wait (1000);
            System.out.print(i + " ");
        }
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    boolean playlevel() {
        Scanner myObj = new Scanner(System.in);
        String secretCode = levelCode();

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

    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    public static void main() {
        Minigame myMinigame =  new Minigame();
        boolean levelPassed = true;
        while (levelPassed) {
            levelPassed = myMinigame.playlevel();
            myMinigame.level++;
        }
    }
}


