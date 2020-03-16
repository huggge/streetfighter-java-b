package fighters;

public class Fighter extends IFighterMethods {

    private String name;
    private String motto;
    private int health;
    private int strength;
    private int speed;
    private int shield;
    private int level;

    public Fighter(String name, String motto, int strength, int speed, int shield, int level) {
        this.name = name;
        this.motto = motto;
        this.health = 100;
        this.strength = strength;
        this.speed = speed;
        this.shield = shield;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public String getMotto() {
        return motto;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return name + " med mottot: " + motto + "!";
    }
}
