package entity.SpecialAttacks;

import entity.Champion;
import entity.Entity;
import entity.Monsters.Monster;

public class MagmaRage extends SpecialAttacks implements ISpecialAttack{
    String name = "MagmaRage";
    int id = new AttackUniqueID().getUniqueAttackID();
    String lore = "Every monster in the caster's team get +1 Strength!";

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
        System.out.println("Magma Rage is casted! Every monster in the caster's team get +1 Strength!");
    }

    @Override
    public void use(Champion caster){
        for (Entity monster:caster.getTeam().getEntities()) {
            if (monster.getClass() != Champion.class){
                monster.setStrength(monster.getStrength()+1);
            }
        }
        printExplanation();
    }


}
