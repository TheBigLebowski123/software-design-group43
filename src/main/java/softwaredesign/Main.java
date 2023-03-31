package softwaredesign;

import javax.swing.*;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tamagotchi!");

        // create a new tamagotchi
        System.out.print("Enter a name for your tamagotchi: ");
        String name = scanner.nextLine();

        Tamagotchi tamagotchi = Tamagotchi.getInstance(name);
        tamagotchi.inventory.addFoodItem();
        tamagotchi.inventory.addToyItem();
        tamagotchi.inventory.addMedicineItem();


        while (tamagotchi.isAlive()) {

            System.out.println("What do you want to do?");
            System.out.println("1. Feed");
            System.out.println("2. Play");
            System.out.println("3. Heal");
            System.out.println("4. Update");
            System.out.println("5. Quit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // feed tamagotchi
                    System.out.println("What do you want to feed your tamagotchi?(please Enter the Number associated with food)");
                    for (int i = 0; i < tamagotchi.inventory.getFoodItems().size(); i++) {
                        FoodItem currItem = tamagotchi.inventory.getFoodItems().get(i);
                        System.out.println((i + 1) + ". " + currItem.getName() + " Nutrition: " + currItem.getNutritionPoints());
                    }
                    int foodChoice = scanner.nextInt();
                    tamagotchi.feed(tamagotchi.inventory.getFoodItems().get(foodChoice-1));
                    break;
                case 2:
                    // play with tamagotchi
                    System.out.println("What do you want to play with your tamagotchi?");
                    for (int i = 0; i < tamagotchi.inventory.getToyItems().size(); i++) {
                        ToyItem currItem =  tamagotchi.inventory.getToyItems().get(i);
                        System.out.println((i + 1) + ". " + currItem.getName() + "Increase Health: +"+ currItem.getHealthPoints());
                    }
                    int toyChoice = scanner.nextInt();
                    tamagotchi.play(tamagotchi.inventory.getToyItems().get(toyChoice - 1));
                    break;
                case 3:
                    // heal tamagotchi
                    System.out.println("What do you want to heal your tamagotchi with?");
                    for (int i = 0; i < tamagotchi.inventory.getMedicineItems().size(); i++) {
                        MedicineItem currItem= tamagotchi.inventory.getMedicineItems().get(i);
                        System.out.println((i + 1) + ". " + currItem.getName());
                    }
                    int medicineChoice = scanner.nextInt();
                    tamagotchi.heal(tamagotchi.inventory.getMedicineItems().get(medicineChoice - 1));
                    break;

                case 4:
                    System.out.println("These are the current statistics of your tamagotchi:");
                    tamagotchi.stateHandler("");
                    break;
                case 5:
                    // quit game
                    System.out.println("Quitting game...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            // update tamagotchi state
        }
    }
}
