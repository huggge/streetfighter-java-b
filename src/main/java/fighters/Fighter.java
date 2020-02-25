package fighters;

public class Fighter extends IFighterMethods {

    private String name;
    private String motto;
    private int health;
    private int strength;
    private int speed;
    private int shield;
    private int level;
    private boolean alive;

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

    public int getStrength() {
        return strength;
    }

    public int getSpeed() {
        return speed;
    }

    public int getShield() {
        return shield;
    }

    public int getLevel() {
        return level;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }


    @Override
    public String toString() {
        return "Fightername: " + name + " Fighterhealth: " + health + " Motto: " + motto + " Strength: " + strength + " Speed: " + speed + " Shield: " + shield + " Level: " + level;
    }
}
