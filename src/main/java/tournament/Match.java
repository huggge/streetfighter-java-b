package tournament;

import fighters.AllFighters;
import fighters.Fighter;

import java.util.Random;
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
        System.out.println("Tryck Enter för att starta matchen");
        input.nextLine();
        System.out.println("Matchen mellan " + fighterOne.getName() + " och " + fighterTwo.getName() + "  har påbörjats!");
        System.out.println();
        matchRound();
    }

    public void matchRound() {

        rounds += 1;
        System.out.println("Runda " + rounds + " av 3");

        // Display stats before fight.
        System.out.println(fighterOne.getName() + " har " + fighterOne.getHealth() + " i hp.");
        System.out.println(fighterTwo.getName() + " har " + fighterTwo.getHealth() + " i hp.");

        // Attack 1
        System.out.println(fighterOne.getName() + " attackerar " + fighterTwo.getName());
        int attackValueOne = fighterOne.attack() - fighterTwo.defend();
        System.out.println(fighterTwo.getName() + " blev av med " + attackValueOne + " i liv. ");
        fighterTwo.setHealth(fighterTwo.getHealth()-attackValueOne);
        System.out.println(fighterTwo.getName() + " hp är: " +fighterTwo.getHealth());



        // Attack 2
        System.out.println(fighterTwo.getName() + " attackerar " + fighterOne.getName());
        int attackValueTwo = fighterTwo.attack() - fighterOne.defend();
        System.out.println(fighterOne.getName() + " blev av med " + attackValueTwo + " i liv.");
        fighterOne.setHealth(fighterOne.getHealth()-attackValueTwo);
        System.out.println(fighterOne.getName() + " hp är: " +fighterOne.getHealth());


        if(attackValueOne > attackValueTwo) {
            System.out.println(fighterOne.getName() + " Vann rundan!");
            fighterOneRounds += 1;
        }

        if(attackValueTwo > attackValueOne) {
            System.out.println(fighterTwo.getName() + " Vann rundan!");
            fighterTwoRounds += 1;
        }

        if(rounds == 3) {
            System.out.println("Matchen är slut!");
            if(fighterOneRounds >= 2) {
                System.out.println(fighterOne.getName() + " Vann!");
                System.out.println("Vinnarens motto: " + fighterOne.getMotto());
                winner = fighterOne;
            }
            if(fighterTwoRounds >= 2) {
                System.out.println(fighterTwo.getName() + " Vann!");
                System.out.println("Vinnarens motto: " +fighterTwo.getMotto());
                winner = fighterTwo;
            }
        }
        if(rounds != 3) {
            System.out.println("Tryck Enter för att starta nästa runda!");
            input.nextLine();
            matchRound();
        }

    }
}