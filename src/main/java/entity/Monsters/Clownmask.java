package entity.Monsters;

import entity.Entity;
import entity.Monsters.Profiles.Mascot;
import environment.Team;

public class Clownmask extends Monster implements Mascot {
    private int strengthBoost;
    private int healthBoost;

    public Clownmask(int id, String name, int health, int strength, int attackBoost, int healthBoost, Team team) {
        super(id, name, health, strength, team);
        this.strengthBoost = attackBoost;
        this.healthBoost = healthBoost;
    }

    /**
     * @param target
     * Action des mascottes, boost la force ou la défense du monstre ciblé
     */
    public void boostStrength(Monster target) {
        if (isAlive()) {
            // Boost the strength of the target
            target.boostStrength(strengthBoost);
            System.out.println(getName() + " boosts the strength of " + target.getName() +
                    " by " + strengthBoost + ". New strength of the target: " + target.getStrength());
        } else {
            System.out.println(getName() + " is defeated and cannot boost strength.");
        }
    }

    public void boostHp(Monster target) {
        if (isAlive()) {
            // Boost the health of the target
            target.boostHp(healthBoost);
            System.out.println(getName() + " boosts the health of " + target.getName() +
                    " by " + healthBoost + ". New health of the target: " + target.getHp());
        } else {
            System.out.println(getName() + " is defeated and cannot boost health.");
        }
    }
    @Override
    public void attack(Entity target) {
        System.out.println(this.getName() + " is a mascot and cannot attack.");
    }

    public int getAttackBoost() {
        return strengthBoost;
    }
    public int getHealthBoost() {
        return healthBoost;
    }
}