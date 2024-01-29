package entity.Monsters;

import entity.Entity;

public class Protector extends Monster{
    public Protector(int id, String name, int health, int attackDamage) {
        super(id, name, health, attackDamage);
    }

    // Méthode spécifique aux protecteurs pour empêcher les attaques
    public void protect() {
        System.out.println(this.getName() + " protected its champion. Enemy attacks are blocked this round.");
    }

    @Override
    public void attack(Entity target) {
        System.out.println(this.getName() + " is a protector and cannot attack.");
    }
}
