package entity;

import environment.Board;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Card {
    Logger log = LogManager.getLogger(Card.class);
    private int id;
    private String name;
    private Entity summonedEntity;

    public void playCard(Champion master, Board board) {
        // Implémentation pour jouer une carte
        log.info(master.getName() + " plays the card : " + this.getName() + ". " +"\n"+summonedEntity.getName() + " summoned. HP : " + summonedEntity.getHp()+ " STR : "+summonedEntity.getStrength());
        master.getTeam().addEntity(summonedEntity);
        board.summonEntity(summonedEntity);
        master.removeCardFromDeck(this);
    }

    public Card(int id, Entity summonedEntity) {
        this.id = id;
        this.summonedEntity = summonedEntity;
    }

    public String getName() {
        return summonedEntity.getName()+" Card";
    }

    public int getId() {
        return id;
    }

    public Entity getSummonedEntity() {
        return summonedEntity;
    }
}
