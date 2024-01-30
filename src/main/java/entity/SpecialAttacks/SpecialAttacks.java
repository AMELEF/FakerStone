package entity.SpecialAttacks;

import entity.Champion;

public abstract class SpecialAttacks{
    String name;

    public String getName() {
        return name;
    }

    public String getLore() {
        return lore;
    }

    String lore;
    int id;

    public void use(Champion caster){}
}
