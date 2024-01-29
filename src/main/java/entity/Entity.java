package entity;

public class Entity {
    private int id;
    private String name;
    private int hp;
    private boolean targetable;
    private Team team;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isAlive() {
        return hp > 0;
    }
    public boolean isTargetable() {return targetable;}

    public Entity(int id, String name, int hp, Team team) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.team = team;
    }

    public void receiveAttack(int damage){
        // Implémentation pour la réception d'une attaque
        // Exemple: Réduit la santé du monstre attaqué par les dégâts reçus
        int newHp = this.getHp() - damage;
        this.setHp(newHp);
        System.out.println(this.getName() + " suffers an attack and loses " + damage +
                " health points. New monster health : " + this.getHp());
    }
}