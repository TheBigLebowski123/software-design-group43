package softwaredesign;

import javax.swing.*;
import java.util.ArrayList;
import java.util.TimerTask;

public class Tamagotchi {

    private static Tamagotchi instance = null;
    private String name;
    private int age;
    private int weight;
    private int hunger;
    private int happiness;
    private int health;
    private boolean isAlive;
    public Inventory inventory;
    java.util.Timer timer = new java.util.Timer();


// we can add a case that when a tamagotchi gets to for example age 20 some more foods will be added to the foodinvent
    public Tamagotchi(String name) {
        this.name = name;
        this.age = 0;
        this.weight = 10;
        this.hunger = 5;
        this.happiness = 5;
        this.health = 5;
        this.isAlive = true;
        this.inventory = new Inventory();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                stateHandler("");
            }
        };
        timer.schedule(task, 0, 60000);
    }


    public static Tamagotchi getInstance(String name){
        if(instance == null){
            instance = new Tamagotchi(name);
        }
        return instance;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public int getHunger() {
        return hunger;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return isAlive;
    }


    public void feed(FoodItem foodItem) {
        if (isAlive()) {
            hunger += foodItem.getNutritionPoints();

            stateHandler("You fed " + getName() + ".");
        } else {
            stateHandler(getName() + " is no longer alive. You cannot feed it anymore.");
        }
    }

    public void play(ToyItem toyItem) {
        if (isAlive()) {
            Minigame myMinigame =  new Minigame();
            myMinigame.playGame();
            happiness += myMinigame.getHappinessIncrease();
            health += myMinigame.getHealthIncrease();

            stateHandler("You played with " + getName() + ".");

            java.util.Timer timer = new java.util.Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    stateHandler("");
                }
            };
            timer.schedule(task, 0, 60000);
        } else {
            stateHandler(getName() + " is no longer alive. You cannot play with it anymore.");
        }
    }

    public void heal(MedicineItem medicineItem) {
        if (isAlive()) {
            health += medicineItem.getHealthPoints();
            stateHandler("You healed " + getName() + ".");
        } else {
            stateHandler(getName() + " is no longer alive. You cannot heal it anymore.");
        }
    }

    public void stateHandler(String message) {
        //update the state every 1 min and only output the state on request + if the hunger or any stat goes to the deathzone then output and warn the player
        if (hunger <= 0 || happiness <= 0 || health <= 0) {
            isAlive = false;
        }
        if (!isAlive){
            System.out.println("Game over. " + name + " is no longer alive.");
            timer.cancel();
            System.exit(0);
        }
        else if (isAlive && message == "") {
            age += 1;
            hunger -= 2;
            weight += 1;
            happiness -= 1;
            if (hunger < 0) {
                health += 2*hunger;
            }
            if (weight > 100) {
                health -= weight-100;
            }
            if (happiness <= 0 || happiness >= 50) {
                health += happiness;
            }
            if (age > 100) {
                health -= age-100;
            }

            System.out.println(message);
            System.out.println("Age: " + getAge() + " Weight: " + getWeight() + " Hunger: "
                    + getHunger() + " Happiness: " + getHappiness() + " Health: " + getHealth());
        }
        else{
            System.out.println(message);
            System.out.println("Age: " + getAge() + " Weight: " + getWeight() + " Hunger: "
                    + getHunger() + " Happiness: " + getHappiness() + " Health: " + getHealth());
        }
    }
}
