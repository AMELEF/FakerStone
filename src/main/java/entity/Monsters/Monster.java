package entity.Monsters;

import entity.Entity;
import entity.EntityTypes;
import environment.Board;
import environment.Team;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Monster extends Entity {
    Logger log = LogManager.getLogger(Monster.class);

    public Entity pickTargetByID(Board board){
        System.out.println("Select a target (enter ID):");
        board.printEntities();
        Scanner scanner = new Scanner(System.in);
        int targetId = scanner.nextInt();
        for (Entity entity : board.getAliveEntities()) {
            if (entity.getId() == targetId){
                return entity;
            }
        }
        System.out.println("No Entity found with this ID");
        return pickTargetByID(board);
    }

    public Monster(int id, String name, int hp, int strength, Team team) {
        super(id, name, hp, team);
        this.setStrength(strength);
    }
}
