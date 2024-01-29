package entity.Monsters;


import entity.Entity;
import entity.Monsters.Profiles.Healer;
import environment.Team;

public class Lightling extends Monster implements Healer {
    @Override
    public void attack(Entity target) {
        System.out.println(this.getName() + " is a healer and cannot attack.");
    }

    public Lightling(int id, String name, int health, int strength, Team team) {
        super(id, name, health, strength, team);
    }

    public void heal(Entity target) {
        if (isAlive()) {
            int newHp = target.getHp() + strength;
            target.setHp(newHp);
            System.out.println(getName() + " heals " + target.getName() +
                    " by " + strength + " points. New health of the target: " + target.getHp());
        } else {
            System.out.println(getName() + " is defeated and cannot heal.");
        }
    }


}
