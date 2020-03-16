package tournament;

import fighters.Fighter;
import java.util.Scanner;

public class Match {
    private Fighter fighterOne;
    private Fighter fighterTwo;
    private int fighterOneRounds;
    private int fighterTwoRounds;
    private int rounds;
    Fighter winner;
    Scanner input = new Scanner(System.in);



    public Match(Fighter fighterOne, Fighter fighterTwo) {
        this.fighterOne = fighterOne;
        this.fighterTwo = fighterTwo;
    }

    public Fighter getWinner() {
        return winner;
    }

    public void startMatch() {
        System.out.println("===================================================");
        System.out.println("Matchen mellan " + fighterOne.getName() + " och " + fighterTwo.getName() + "  har påbörjats!");
        System.out.println();
        matchRound();
    }

    public void matchRound() {

        rounds += 1;
        System.out.println("Runda " + rounds + " av 3");

        System.out.println("===================================================");

        // Display stats before fight.
        System.out.println(fighterOne.getName() + " har " + fighterOne.getHealth() + " i HP.");
        System.out.println(fighterTwo.getName() + " har " + fighterTwo.getHealth() + " i HP.");

        System.out.println("===================================================");

        // Attack 1
        System.out.println(fighterOne.getName() + " attackerar " + fighterTwo.getName());
        int attackValueOne = fighterOne.attack() - fighterTwo.defend();
        System.out.println(fighterTwo.getName() + " blev av med " + attackValueOne + " i HP. ");
        fighterTwo.setHealth(fighterTwo.getHealth()-attackValueOne);
        System.out.println(fighterTwo.getName() + " HP är: " +fighterTwo.getHealth());

        System.out.println("===================================================");

        // Attack 2
        System.out.println(fighterTwo.getName() + " attackerar " + fighterOne.getName());
        int attackValueTwo = fighterTwo.attack() - fighterOne.defend();
        System.out.println(fighterOne.getName() + " blev av med " + attackValueTwo + " i HP.");
        fighterOne.setHealth(fighterOne.getHealth()-attackValueTwo);
        System.out.println(fighterOne.getName() + " HP är: " +fighterOne.getHealth());

        System.out.println("===================================================");


        if(attackValueOne > attackValueTwo) {
            System.out.println(fighterOne.getName() + " Vann rundan!");
            fighterOneRounds += 1;
            System.out.println("===================================================");

        }

        if(attackValueTwo > attackValueOne) {
            System.out.println(fighterTwo.getName() + " Vann rundan!");
            fighterTwoRounds += 1;
            System.out.println("===================================================");

        }

        if(attackValueOne == attackValueTwo) {
            fighterTwoRounds += 1;
        }

        if(rounds == 3) {
            System.out.println("Matchen är slut!");
            System.out.println();
            if(fighterOneRounds >= 2) {
                System.out.println(fighterOne.getName() + " Vann!");
                System.out.println("Vinnarens motto: " + fighterOne.getMotto());
                System.out.println(fighterOne.getName() + "s HP återställs till 100 inför nästa match.");
                System.out.println("===================================================");
                fighterOne.setHealth(100);
                winner = fighterOne;
            }
            if(fighterTwoRounds >= 2) {
                System.out.println(fighterTwo.getName() + " Vann!");
                System.out.println(fighterTwo.getName() + " motto: " + fighterTwo.getMotto());
                System.out.println(fighterTwo.getName() + "s HP återställs till 100 inför nästa match.");
                System.out.println("===================================================");
                fighterTwo.setHealth(100);
                winner = fighterTwo;
            }
        }
        if(rounds != 3) {
            System.out.println("Tryck Enter för att starta nästa runda!");
            startNextRound();
            matchRound();
        }

    }

    public void startNextRound() {
        System.out.println();
        System.out.print("Tryck Enter för att gå vidare...");
        input.nextLine();
    }
}