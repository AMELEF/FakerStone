package environment;

import entity.Entity;
import entity.Monsters.Monster;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

public class Board {
    Logger log = LogManager.getLogger(Board.class);
    private ArrayList<Entity> aliveEntities = new ArrayList<>();

    public ArrayList<Entity> getAliveEntities() {
        return aliveEntities;
    }

    public void kill(Entity entity){
        entity.getTeam().removeEntity(entity);
        aliveEntities.remove(entity);
    }

    public void printEntities(){
        try{
            aliveEntities.sort(Comparator.comparing(Entity::getTeamName));
        }
        catch (NullPointerException e){
        }
        System.out.println("---------------------------------------------------");
        System.out.println("ID");
        for (Entity entity:aliveEntities) {
            if(entity.getId()<10){
                System.out.print("0");
            }
            System.out.println(entity.getId()+" * ["+entity.getTeam().getName()+"] "+entity.getName()+" : "+entity.getHp()+"HP "+entity.getStrength()+"STR Targetable : "+entity.isTargetable());
        }
        System.out.println("---------------------------------------------------");
    }

    public void summonEntity(Entity entity){
        log.info("["+entity.getTeamName()+"] "+entity.getName()+" has appeared on the board");
        aliveEntities.add(entity);
    }

}
