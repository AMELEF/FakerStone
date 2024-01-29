package environment;

import entity.Champion;
import entity.Monsters.Monster;

import java.util.ArrayList;

public class Team {
    private String name;
    private Champion champion;
    private ArrayList<Monster> monsters;

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    private void setMonsters(ArrayList<Monster> monsters) {
        this.monsters = monsters;
    }
    public void addMonster(Monster monster){
        this.monsters.add(monster);
    }

    public void removeMonster(Monster monster){
        this.monsters.remove(monster);
    }

    public void setChampion(Champion champion) {
        this.champion = champion;
    }

    public Team(String name) {
        this.name = name;
    }

}
