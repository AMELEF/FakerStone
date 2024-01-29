package entity;

public class Card {
    private int id;
    private String name;
    private Entity summonedEntity;

    public void playCard(Champion champion, Entity target) {
        // Implémentation pour jouer une carte

        System.out.println(champion.getName() + " joue la carte " + this.name + ". " +
                summonedEntity.getName() + " invoqué. Nouvelle santé de la cible : " + target.getHp());
    }

    public Card(int id, String name, Entity summonedEntity) {
        this.id = id;
        this.name = name;
        this.summonedEntity = summonedEntity;
    }
}
