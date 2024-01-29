package entity;

public class Entity {
    private int id;
    private String name;
    private int hp;
    private boolean targetable;

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

    public Entity(int id, String name, int hp) {
        this.id = id;
        this.name = name;
        this.hp = hp;
    }

    public receiveAttack(int damage){
        if
    }
}