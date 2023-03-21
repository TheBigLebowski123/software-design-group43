package softwaredesign;

public class ToyItem {
    private String name;
    private int happinessPoints;
    private int healthPoints;

    public ToyItem(String name, int happinessPoints, int healthPoints) {
        this.name = name;
        this.happinessPoints = happinessPoints;
        this.healthPoints = healthPoints;
    }

    public String getName() {
        return name;
    }

    public int getHappinessPoints() {
        return happinessPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }
}
