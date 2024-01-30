package entity.Monsters;

import entity.Entity;
import entity.EntityTypes;
import environment.Board;
import environment.Team;

public class Aurastral extends Monster implements IMonster {
    public Aurastral(int id, Team team) {
        super(id, "Aurastral", 6, 3,team);
        this.setType(EntityTypes.PROTECTOR);
    }

    @Override
    public void action(Board board) {
        System.out.println("["+getPlayerName()+"]"+this.getName() + " made other members of its team untargetable. Enemy attacks cannot focus them.");
        for (Entity entity: getTeam().getEntities()) {
            if (entity.getType() != EntityTypes.PROTECTOR){
                entity.setTargetable(false);
            }
        }
    }
}