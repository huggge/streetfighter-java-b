package tournament;

import fighters.Fighter;

import java.util.ArrayList;
import java.util.List;

public class Progress {


    private List<Fighter> semiList = new ArrayList<>();
    private List<Fighter> finalList = new ArrayList<>();

    public List<Fighter> getSemiList() {
        return semiList;
    }

    public List<Fighter> getFinalList() {
        return finalList;
    }

    public Fighter getIndividualsemiFighter(int i) {
        return semiList.get(i);
    }

    public Fighter getIndividualFinalFighter(int i) {
    return finalList.get(i);
    }


    public void setSemiList(Fighter fighter) {
        semiList.add(fighter);
    }

    public void setFinalList(Fighter fighter) {
        finalList.add(fighter);
    }
}
