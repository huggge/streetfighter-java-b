package tournament;

import fighters.AllFighters;
import fighters.Fighter;

import java.util.Random;
import java.util.Scanner;

public class Match {
    AllFighters allFighters = new AllFighters();
    Fighter fighterOne;
    Fighter fighterTwo;
    int winner;
    int looser;
    int rounds;
    Scanner input = new Scanner(System.in);


    public Match(Fighter fighterOne, Fighter fighterTwo) {
        this.fighterOne = fighterOne;
        this.fighterTwo = fighterTwo;
    }

    public void matchMenu() {
        System.out.println("1. Starta match.");
        System.out.println("2. Gör något annat.");
        int menuChoice = input.nextInt();
        switch(menuChoice) {
            case 1:
                startMatch();
            case 2:

        }

    }


    public void startMatch() {
        System.out.println("Matchen mellan " + fighterOne.getName() + " och " + fighterTwo.getName() + "  har påbörjats!");
        System.out.println("Runda 1 av 3!");
        System.out.println("aj " + fighterOne.getName() + " blev slagen :(");
        System.out.println("1. För att starta nästa runda");
                if(input.nextInt() == 1) {
                    matchRound();
                    nextRound();
                }
    }

    public void matchRound() {
//        Någon typ av randomfunktion för attackerna och defense metoderna.
        System.out.println("FIGHTING pågår osv aj aj aj");
    }

    public void nextRound() {
//        Metod för att starta nästa runda (max 3).
        System.out.println("aj ajaj ajj ny runda etc bla bla");

    }

    public boolean flipTheCoin() {
//      Någon slags randomizer för matcherna.
        Random rand = new Random();
        return rand.nextBoolean();
    }

    public void doSomethingElse() {
        System.out.println("gör ngt annat");
    }


}