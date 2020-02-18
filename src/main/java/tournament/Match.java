package tournament;

import fighters.AllFighters;
import fighters.Fighter;

import java.util.Random;

public class Match {
    AllFighters allFighters = new AllFighters();
    Fighter fighterOne;
    Fighter fighterTwo;
    int winner;
    int looser;
    int rounds;

    public Match(Fighter fighterOne, Fighter fighterTwo) {
        this.fighterOne = fighterOne;
        this.fighterTwo = fighterTwo;
    }

    public void startMatch() {
        System.out.println(
                "Matchen mellan " + fighterOne.getName() + " och " + fighterTwo.getName() + " har startats!");

        System.out.println("Ett mynt har singlats för att avgöra vem som börjar.");
        if (flipTheCoin()) {
            System.out.println(fighterOne.getName() + " Börjar!");
        } else {
            System.out.println(fighterTwo.getName() + " Börjar!");

        }

    }


    public boolean flipTheCoin() {
        Random rand = new Random();
        return rand.nextBoolean();
    }

}