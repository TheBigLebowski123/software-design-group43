public class FoodItem {
    private String name;
    private int nutritionPoints;
    //private int weightPoints;
    //private int happinessPoints;
    private int healthPoints;

    public FoodItem(String name, int nutritionPoints, int healthPoints) {
        this.name = name;
        this.nutritionPoints = nutritionPoints;
        //this.weightPoints = weightPoints;
        //this.happinessPoints = happinessPoints;
        this.healthPoints = healthPoints;
    }

    public String getName() {
        return name;
    }

    public int getNutritionPoints() {
        return nutritionPoints;
    }

  /*  public int getWeightPoints() {
        return weightPoints;
    }

    public int getHappinessPoints() {
        return happinessPoints;
    }*/

   public int getHealthPoints() {
        return healthPoints;
    }
}
