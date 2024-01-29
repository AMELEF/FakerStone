package entity.Monsters;

import entity.Champion;
import entity.Entity;
import entity.Monsters.Profiles.Damager;
import environment.Team;

public class Cinderthing extends Monster implements Damager {

    public Cinderthing(int id, String name, int hp, int strength, Team team) {
        super(id, name, hp, strength, team);
    }

    @Override
    public void attack(Entity target) {
        if (target.isTargetable()) {
            target.receiveAttack(this.strength);
        }
        else{
            System.out.println(target.getName()+" is not targetable !");
        }
    }
}
