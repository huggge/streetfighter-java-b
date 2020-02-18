package fighters;

import names.GetNames;
import names.NameList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class AllFighters {

    GetNames getNames = new GetNames();
    Random rand = new Random();
    private List<Fighter> allFightersList = new ArrayList<>();

    public void setFighterListHealth(int id, int hp) {
        allFightersList.get(id).setHealth(hp);
    }

    public List<Fighter> getAllFightersList() {
        return allFightersList;
    }

    public Fighter getIndividualfighter(int i) {
        return allFightersList.get(i);
    }


    public void populateAllfighters() {
        getNames.getHTTP();
        List<NameList> nameList = getNames.getNameList();
        for(int i = 1; i<9; i++) {
            allFightersList.add(new Fighter(nameList.get(i).toString(), randomizeMotto(), randomizeInteger(), randomizeInteger(), randomizeInteger(), randomizeInteger()));
        }
    }

    public String randomizeMotto() {
        List<String> mottos = new ArrayList<>();
        mottos.add("I am the greatest");
        mottos.add("No one can stop me!");
        mottos.add("Mouhahaha!");
        mottos.add("Hihi!");
        mottos.add("I am the devil");
        mottos.add("Evil i am");
        mottos.add("I am a fighter lol");
        mottos.add("Hello everybody");
        int i = rand.nextInt(8);
        return mottos.get(i);
    }

    public int randomizeInteger() {
        return rand.nextInt(8);
    }

}
