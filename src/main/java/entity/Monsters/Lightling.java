package entity.Monsters;


import entity.Entity;
import entity.EntityTypes;
import environment.Board;
import environment.Team;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Lightling extends Monster implements IMonster {
    Logger log = LogManager.getLogger(Lightling.class);

    public Lightling(int id, Team team) {
        super(id, "Lightling", 6, 2, team);
        this.setType(EntityTypes.HEALER);
    }

    public void heal(Entity target, Board board){
        target.setHp(target.getHp()+getStrength());
        log.info("["+this.getTeam().getName()+"] "+this.getName()+" heals "+target.getName()+" : +"+this.getStrength()+"HP!");
    }

    @Override
    public void action(Board board) {
        System.out.println("["+getPlayerName()+"] Lightling will heal the target :");
        Entity target = pickTargetByID(board);
        heal(target,board);
    }


}
