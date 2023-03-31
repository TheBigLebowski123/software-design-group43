package softwaredesign;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<FoodItem> foodItems;
    private List<ToyItem> toyItems;
    private List<MedicineItem> medicineItems;

    public Inventory() {
        this.foodItems = new ArrayList<>();
        this.toyItems = new ArrayList<>();
        this.medicineItems = new ArrayList<>();
    }

    public void addFoodItem() {// we can also call this function inside tamagotchi class
        FoodItem Apple;
        Apple = new FoodItem("Apple",30,30);
        foodItems.add(Apple);

        FoodItem chickenSandwich;
        chickenSandwich = new FoodItem("ChickenSandwich",50,50);
        foodItems.add(chickenSandwich);;
    }

    public void addToyItem() {
        ToyItem minigame;
        minigame = new ToyItem("Memory Game", 20, 10);
        toyItems.add(minigame);
    }

    public void addMedicineItem() {
        MedicineItem item1;
        item1 = new MedicineItem("Aspirin", 15);
        medicineItems.add(item1);

        MedicineItem item2;
        item2 = new MedicineItem("Ibuprofyn", 20);
        medicineItems.add(item2);

    }

    public void removeFoodItem(FoodItem item) {
        foodItems.remove(item);
    }

    public void removeToyItem(ToyItem item) {
        toyItems.remove(item);
    }

    public void removeMedicineItem(MedicineItem item) {
        medicineItems.remove(item);
    }

    public List<FoodItem> getFoodItems() {return foodItems;}

    public List<ToyItem> getToyItems() {
        return toyItems;
    }

    public List<MedicineItem> getMedicineItems() {
        return medicineItems;
    }

    @Override//we don't need this instead : add each of the for loops inside its own function or create a function
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Food items:\n");
        for (FoodItem item : foodItems) {
            sb.append("- ").append(item).append("\n");
        }
        sb.append("Toy items:\n");
        for (ToyItem item : toyItems) {
            sb.append("- ").append(item).append("\n");
        }
        sb.append("Medicine items:\n");
        for (MedicineItem item : medicineItems) {
            sb.append("- ").append(item).append("\n");
        }
        return sb.toString();
    }
}
