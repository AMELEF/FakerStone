package entity;

import environment.Team;

import java.util.ArrayList;

public class Champion extends Entity{
    private String specialAbility;
    private ArrayList<Card> deck;

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public Champion(int id, String name, int hp, String specialAbility, Team team, ArrayList<Card> deck) {
        super(id, name, hp, team);
        this.specialAbility = specialAbility;
        this.deck = deck;
    }

    public String getSpecialAbility() {
        return specialAbility;
    }

    public void useSpecialAbility(Entity target){
        // Implémentation de la capacité spéciale
        // Exemple: Réduit de moitié la santé de la cible
        int newHp = target.getHp() / 2;
        target.setHp(newHp);
        System.out.println(this.getName() + " uses his special ability on " + target.getName() +
                ". New health : " + target.getHp());
    }

}
