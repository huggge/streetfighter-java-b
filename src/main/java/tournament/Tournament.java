package tournament;

import db.DatabaseConnection;
import fighters.AllFighters;
import fighters.Fighter;

import java.util.Scanner;


public class Tournament {
    AllFighters allFighters = new AllFighters();
    Progress progress = new Progress();
    private Scanner input = new Scanner(System.in);

    public void initiateTournament() {
        allFighters.populateAllfighters();
        allFighters.shuffleSeed();
        displaySeed();
        startGroupFights();
    }

    public void displaySeed() {

        System.out.println("Välkommen till Fighter Tournament!");
        System.out.println();
        System.out.println("Här är lottningen!");
        System.out.println("Match 1: " + allFighters.getIndividualfighter(0).getName() + " möter " + allFighters.getIndividualfighter(1).getName());
        System.out.println("Match 2: " + allFighters.getIndividualfighter(2).getName() + " möter " + allFighters.getIndividualfighter(3).getName());
        System.out.println("Match 3: " + allFighters.getIndividualfighter(4).getName() + " möter " + allFighters.getIndividualfighter(5).getName());
        System.out.println("Match 4: " + allFighters.getIndividualfighter(6).getName() + " möter " + allFighters.getIndividualfighter(7).getName());
        System.out.println("===================================================");
    }

    public void startNextRound() {
        System.out.println();
        System.out.print("Tryck Enter för att gå vidare...");
        input.nextLine();
    }

    public void startGroupFights() {
        System.out.println("STARTAR KVARTSFINALEN!");
        for (int i = 0; i < 8; i += 2) {
            startNextRound();
            Match match = new Match(allFighters.getIndividualfighter(i), allFighters.getIndividualfighter(i + 1));
            match.startMatch();
            listSemiFinalists(match);
        }
        startNextRound();
        startSemiFights();
    }

    public void startSemiFights() {
        System.out.println();
        System.out.println("STARTAR SEMIFINALEN!");
        for (int i = 0; i < 4; i += 2) {
            startNextRound();
            Match match = new Match(progress.getIndividualsemiFighter(i), progress.getIndividualsemiFighter(i + 1));
            match.startMatch();
            listFinalists(match);
        }
        startNextRound();
        startFinalFight();
    }

    public void startFinalFight() {
        System.out.println("STARTAR FINALEN!");
        System.out.println();
        startNextRound();
        Match match = new Match(progress.getIndividualFinalFighter(0), progress.getIndividualFinalFighter(1));
        match.startMatch();
        System.out.println("===================================================");
        System.out.println("VINNARE AV TURNERINGEN ÄR: " + match.getWinner().getName().toUpperCase() + "! grattis hihi.");
        addToDb(match.getWinner().getName());
    }

    public void listSemiFinalists(Match match) {
        System.out.println("===================================================");
        System.out.println("Fighters som är vidare till semifinalen: ");
        System.out.println("----------------------------------------");
        progress.setSemiList(match.getWinner());
        for (Fighter f : progress.getSemiList()) {
            System.out.println(f);
        }
        System.out.println("----------------------------------------");
        System.out.println("===================================================");
    }

    public void listFinalists(Match match) {
        System.out.println("===================================================");
        System.out.println("Fighters som är vidare till finalen: ");
        System.out.println("-----------------------------------");
        progress.setFinalList(match.getWinner());
        for (Fighter f : progress.getFinalList()) {
            System.out.println(f);
        }
        System.out.println("----------------------------------------");
        System.out.println("===================================================");
    }

    public void addToDb(String winner) {
        DatabaseConnection dbconn = DatabaseConnection.getInstance();
        dbconn.insertWinner(winner);
        System.out.println("Vinnaren har lagts till i vinnardatabasen.");
    }

}
