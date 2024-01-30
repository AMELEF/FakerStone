package entity.SpecialAttacks;

public class AttackUniqueID {
    int id = 0;
    public int getUniqueAttackID(){
        id++;
        return id;
    }
}
