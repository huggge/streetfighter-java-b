package tournament;

import fighters.AllFighters;
import fighters.Fighter;

import java.util.Scanner;


public class Tournament {
    AllFighters allFighters = new AllFighters();

    Progress progress = new Progress();
    private Scanner input = new Scanner(System.in);

    public void displaySeed() {
        allFighters.populateAllfighters();
        allFighters.shuffleSeed();
        System.out.println("Här är lottningen!");
        System.out.println("Match 1: " + allFighters.getIndividualfighter(0).getName() + " möter " + allFighters.getIndividualfighter(1).getName());
        System.out.println("Match 2: " + allFighters.getIndividualfighter(2).getName() + " möter " + allFighters.getIndividualfighter(3).getName());
        System.out.println("Match 3: " + allFighters.getIndividualfighter(4).getName() + " möter " + allFighters.getIndividualfighter(5).getName());
        System.out.println("Match 4: " + allFighters.getIndividualfighter(6).getName() + " möter " + allFighters.getIndividualfighter(7).getName());
        System.out.println("Tryck Enter för att starta turneringen.");
            input.nextLine();
            startFights();

    }

    public void startFights() {
        for(int i = 0; i < 8; i+=2) {
            Match match = new Match(allFighters.getIndividualfighter(i), allFighters.getIndividualfighter(i+1));
            match.startMatch();
            progress.setSemiList(match.getWinner());
            for(Fighter f:progress.getSemiList()){
                System.out.println(f);
            }
        }


    }

    public void nextFight() {
//    Create the finalgame.
    }


}
