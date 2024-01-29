package entity;

public class Card {
    private int id;
    private String name;
    private Entity summonedEntity;

    public void playCard(Champion master, Entity target) {
        // Implémentation pour jouer une carte

        System.out.println(master.getName() + " plays the card : " + this.name + ". " +"\n"+summonedEntity.getName() + " summoned. HP : " + summonedEntity.getHp());
    }

    public Card(int id, String name, Entity summonedEntity) {
        this.id = id;
        this.name = name;
        this.summonedEntity = summonedEntity;
    }
}
