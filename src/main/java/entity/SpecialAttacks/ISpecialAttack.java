package entity.SpecialAttacks;

import entity.Champion;

public interface ISpecialAttack {
    void printExplanation();
    void use(Champion caster);
}
