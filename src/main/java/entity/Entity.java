package entity;

import environment.Board;
import environment.Team;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Entity {
    private int id;
    private EntityTypes type;
    private String name;
    private int hp;

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public EntityTypes getType() {
        return type;
    }

    private int strength;

    public void setType(EntityTypes type) {
        this.type = type;
    }

    private boolean targetable = true;
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

    public void setTargetable(boolean targetable){
        this.targetable = targetable;
    }

    public Entity(int id, String name, int hp, Team team) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.team = team;
    }


    public Team getTeam() {
        return team;
    }

    public String getPlayerName(){
        return team.getPlayerName();
    }

    public String getTeamName() {
        return team.getName();
    }

    public void receiveAttack(int damage, Board board) {
        // Implémentation pour la réception d'une attaque
        // Exemple: Réduit la santé du monstre attaqué par les dégâts reçus
        int newHp = this.getHp() - damage;
        this.setHp(newHp);
        System.out.println("["+getPlayerName()+"] "+this.getName() + " suffers an attack and loses " + damage +
                "HP. New health : " + this.getHp());
        if (this.getHp() <= 0) {
            System.out.println(this.getName() + " has fainted !");
            //Si le protecteur meurt, les alliés redeviennent ciblables
            if(this.getType()==EntityTypes.PROTECTOR){
                for (Entity entity: getTeam().getEntities()) {
                    entity.setTargetable(true);
                }
            }
            board.kill(this);
        }
    }

    public void action(Board board){
    }
}