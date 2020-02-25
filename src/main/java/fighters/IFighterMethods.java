package fighters;

import java.util.Random;

public abstract class IFighterMethods {

    Random rand = new Random();

//    All fighters must have these methods.
    public int attack() {
        return getAttackValue();
    }
    public int defend() {
        return getDefendValue();
    }

    private int getAttackValue() {
        int i = rand.nextInt(6);
        switch (i) {
            case 0:
                return 24;
            case 1:
                return 36;
            case 2:
                return 44;
            case 3:
                return 27;
            case 4:
                return 38;
            case 5:
                return 32;
        }
         return 0;
    }

    private int getDefendValue() {
        int i = rand.nextInt(6);
        switch (i) {
            case 0:
                return 3;
            case 1:
                return 12;
            case 2:
                return 6;
            case 3:
                return 7;
            case 4:
                return 18;
            case 5:
                return 16;
        }
        return 0;
    }
}
