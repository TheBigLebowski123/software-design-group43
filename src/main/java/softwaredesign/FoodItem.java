package softwaredesign;

public class FoodItem {
    private String name;
    private int nutritionPoints;
   
    private int healthPoints;

    public FoodItem(String name, int nutritionPoints, int healthPoints) {
        this.name = name;
        this.nutritionPoints = nutritionPoints;
       
        this.healthPoints = healthPoints;
    }

    public String getName() {
        return name;
    }

    public int getNutritionPoints() {
        return nutritionPoints;
    }

 

   public int getHealthPoints() {
        return healthPoints;
    }
}
