package entity.Monsters;

import entity.Entity;
import entity.EntityTypes;
import environment.Board;
import environment.Team;

public class Cinderthing extends Monster implements IMonster {

    public Cinderthing(int id, Team team) {
        super(id, "Cinderthing", 8, 4, team);
        this.setType(EntityTypes.DAMAGER);
    }

    public void attack(Entity target, Board board){
        if (target.isTargetable()) {
            log.info("["+this.getTeam().getName()+"] "+this.getName()+" attacks "+target.getName()+" : -"+this.getStrength()+"HP!");
            target.receiveAttack(this.getStrength(),board);
        }
        else{
            log.info(this.getName()+" missed its attack !");
        }
    }

    @Override
    public void action(Board board) {
        System.out.println("["+getPlayerName()+"] Cinderthing will attack the target :");
        Entity target = pickTargetByID(board);
        attack(target, board);
    }
}
