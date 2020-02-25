package tournament;

import fighters.Fighter;

import java.util.ArrayList;
import java.util.List;

public class Progress {

    private List<Fighter> semiList = new ArrayList<>();

    public List<Fighter> getSemiList() {
        return semiList;
    }

    public void setSemiList(Fighter semiFighter) {
        this.semiList.add(semiFighter);
    }
}
