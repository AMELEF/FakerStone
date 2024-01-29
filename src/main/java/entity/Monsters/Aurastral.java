package entity.Monsters;

import entity.Entity;
import entity.Monsters.Profiles.Protector;
import environment.Team;

public class Aurastral extends Monster implements Protector {
    public Aurastral(int id, String name, int health, int attackDamage, Team team) {
        super(id, name, health, attackDamage,team);
    }

    @Override
    public void protect() {
        System.out.println(this.getName() + " protected its team. Enemy attacks are blocked this round.");
    }

    @Override
    public void attack(Entity target) {
        System.out.println(this.getName() + " is a protector and cannot attack.");
    }
}