package softwaredesign;

public class MedicineItem {
    private String name;
    private int healthPoints;

    public MedicineItem(String name, int healthPoints) {
        this.name = name;
        this.healthPoints = healthPoints;
    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }
}
