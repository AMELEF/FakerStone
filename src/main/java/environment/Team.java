package environment;

import entity.Entity;
import entity.EntityTypes;

import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<Entity> entities = new ArrayList<>();

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    private void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }
    public void addEntity(Entity entity){
        this.entities.add(entity);
    }

    public void removeEntity(Entity entity){
        this.entities.remove(entity);
    }

    public String getName() {
        return getPlayerName();
    }

    public String getPlayerName(){
        for (Entity entity:entities) {
            if(entity.getType() == EntityTypes.CHAMPION){
                return entity.getName();
            }
        }
        return null;
    }


    public boolean hasProtector(){
        for (Entity entity:entities) {
            if(entity.getType() == EntityTypes.PROTECTOR){
                return true;
            }
        }
        return false;
    }

    public boolean hasChampion(){
        for (Entity entity:entities) {
            if(entity.getType() == EntityTypes.CHAMPION){
                return true;
            }
        }
        return false;
    }
}
