package entity.Monsters;

import entity.Entity;
import entity.Monsters.Profiles.Protector;
import environment.Team;

public class Monster extends Entity {
    int id;
    String name;
    int hp;
    int strength;
    Team team;

    public int getStrength(){ return strength; }

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
        // Réduit la santé du monstre attaqué par les dégâts reçus
        if (this.isTargetable()) {
            int newHp = this.getHp() - damage;
            this.setHp(newHp);
            System.out.println(this.getName() + " suffers an attack and loses " + damage +
                    " hp. New monster health : " + this.getHp());
        }
    }

    public Monster(int id, String name, int hp, int strength, Team team) {
        super(id, name, hp, team);
        this.strength = strength;
    }
}
