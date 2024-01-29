package entity.Monsters;

import entity.Entity;
import entity.Monsters.Profiles.Damager;

public class Cinderthing extends Monster implements Damager {

    public Cinderthing(int id, String name, int hp, int strength) {
        super(id, name, hp, strength);
    }

    @Override
    public void attack(Entity target) {
        if (target.isTargetable()) {
            target.receiveAttack(strength);
        }
        else{
            System.out.println(target.getName()+" is not targetable !");
        }
    }
}
