import fighters.AllFighters;
import tournament.Match;

public class Main {

    public static void main(String[] args) {
        AllFighters allFighters = new AllFighters();

        allFighters.populateAllfighters();
        Match match = new Match(allFighters.getIndividualfighter(3), allFighters.getIndividualfighter(5));
        match.matchMenu();



    }

}
