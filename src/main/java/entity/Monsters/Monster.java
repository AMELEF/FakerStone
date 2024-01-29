package entity.Monsters;

import entity.Entity;

public class Monster extends Entity {
    int id;
    String name;
    int hp;
    int strength;

    @Override
    public void attack(Entity target) {
        // Implémentation pour l'attaque d'un monstre
        // Exemple: Réduit la santé de la cible par les dégâts d'attaque du monstre
        int newHp = target.getHp() - this.attackDamage;
        target.setHp(newHp);
        System.out.println(this.getName() + " attaque " + target.getName() +
                " et lui inflige " + this.attackDamage + " dégâts. Nouvelle santé de la cible : " + target.getHp());
    }

    @Override
    public void receiveAttack(int damage) {
        // Implémentation pour la réception d'une attaque
        // Exemple: Réduit la santé du monstre attaqué par les dégâts reçus
        int newHp = this.getHp() - damage;
        this.setHp(newHp);
        System.out.println(this.getName() + " subit une attaque et perd " + damage +
                " points de santé. Nouvelle santé du monstre : " + this.getHp());
    }

    public Monster(int id, String name, int hp, int strength) {
        super(id, name, hp);
        this.strength = strength;
    }
}
