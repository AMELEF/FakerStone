package entity.Monsters;

import entity.Champion;
import entity.Entity;
import entity.EntityTypes;
import environment.Board;
import environment.Team;

import java.util.Scanner;

public class Clownmask extends Monster implements IMonster {

    public Clownmask(int id, Team team) {
        super(id, "Clownmask", 3, 1, team);
        this.setType(EntityTypes.MASCOT);
    }

    public void boostStrength(Entity target, Board board) {
        target.setStrength(target.getStrength()+1);
        log.info("["+this.getTeam().getName()+"] "+this.getName()+" boosted "+target.getName()+" : +"+this.getStrength()+"STR!");
    }

    public void boostHp(Entity target, Board board) {
        target.setHp(target.getHp()+1);
        log.info("["+this.getTeam().getName()+"] "+this.getName()+" heals "+target.getName()+" : +"+this.getStrength()+"HP!");
    }

    @Override
    public void action(Board board) {
        System.out.println("["+getPlayerName()+"] Clownmask will boost HP (+1) or Strength (+1).");
        System.out.println("[1] Boost HP");
        System.out.println("[2] Boost Strength");
        boolean flag = true;
        while (flag) {
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice == 1){
                Entity target = pickTargetByID(board);
                boostHp(target,board);
                flag = false;
            }
            if (choice == 2){
                Entity target = pickTargetByID(board);
                boostStrength(target,board);
                flag = false;
            }
        }
    }
}