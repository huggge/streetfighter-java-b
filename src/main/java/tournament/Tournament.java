package tournament;

import db.DatabaseConnection;
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
        System.out.println("===================================================");
        startFights();

    }

    public void startNextRound() {
        System.out.println();
        System.out.println("Tryck Enter för att starta nästa omgång.");
        input.nextLine();
    }

    public void startFights() {
        for (int i = 0; i < 8; i += 2) {
            startNextRound();
            Match match = new Match(allFighters.getIndividualfighter(i), allFighters.getIndividualfighter(i + 1));
            match.startMatch();
            System.out.println();
            System.out.println("===================================================");
            System.out.println("Fighters som är vidare till nästa omgång: ");
            System.out.println("----------------------------------------");
            progress.setSemiList(match.getWinner());
            for (Fighter f : progress.getSemiList()) {
                System.out.println(f);
            }
            System.out.println("===================================================");

        }

        startNextRound();
        System.out.println("Startar SEMIFINALEN!!!");
        for (int i = 0; i < 4; i += 2) {
            Match match = new Match(progress.getIndividualsemiFighter(i), progress.getIndividualsemiFighter(i + 1));
            match.startMatch();
            System.out.println("===================================================");
            System.out.println("Fighters som är vidare till finalen: ");
            System.out.println("-----------------------------------");

            progress.setFinalList(match.getWinner());
            for (Fighter f : progress.getFinalList()) {
                System.out.println(f);
            }

            startNextRound();

        }

//        Final
        System.out.println("Startar FINALEN!!!");
        Match match = new Match(progress.getIndividualFinalFighter(0), progress.getIndividualFinalFighter(1));
        match.startMatch();
        System.out.println("===================================================");
        System.out.println("Vinnaren av turneringen är: " + match.getWinner().getName());
        addToDb(match.getWinner().getName());
    }

    public void addToDb(String winner) {
        DatabaseConnection dbconn = DatabaseConnection.getInstance();
        dbconn.insertWinner(winner);
        System.out.println("Vinnaren har lagts till i vinnardatabasen.");
    }

}
