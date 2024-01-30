package entity.SpecialAttacks;

import entity.Champion;
import entity.Entity;

public class HolyWave extends SpecialAttacks implements ISpecialAttack{
    String name = "HolyWave";
    int id = new AttackUniqueID().getUniqueAttackID();
    String lore = "Every monster in the caster's team get +2hp!";

    public String getName() {
        return name;
    }

    public String getLore() {
        return lore;
    }

    public int getId() {
        return id;
    }

    @Override
    public void printExplanation(){
        System.out.println("Holy Wave is casted! Every monster in the caster's team get +2hp!");
    }

    @Override
    public void use(Champion caster){
        for (Entity entity:caster.getTeam().getEntities()) {
            entity.setHp(entity.getHp()+2);
        }
        printExplanation();
    }
}
