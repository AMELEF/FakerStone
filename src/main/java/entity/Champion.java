package entity;

import entity.Monsters.Monster;
import entity.SpecialAttacks.SpecialAttacks;
import environment.Board;
import environment.Team;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class Champion extends Entity{
    private SpecialAttacks specialAbility;
    private ArrayList<Card> deck;

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public void removeCardFromDeck(Card card){
        this.getDeck().remove(card);
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public Champion(int id, String name, int hp, SpecialAttacks specialAbility, Team team, ArrayList<Card> deck) {
        super(id, name, hp, team);
        this.specialAbility = specialAbility;
        this.deck = deck;
        this.setType(EntityTypes.CHAMPION);
    }

    public SpecialAttacks getSpecialAbility() {
        return specialAbility;
    }

    public void useSpecialAbility(){
        this.getSpecialAbility().use(this);
    }

    public void useCardMenu(Board board){
        System.out.println(this.getName() + " has " + this.getDeck().size() + " cards :");
        for (int i = 0; i < this.getDeck().size(); i++){
            Card card = this.getDeck().get(i);
            System.out.println("[" + (i+1) + "] " +"("+card.getSummonedEntity().getType()+")" +card.getName()+ " : "+card.getSummonedEntity().getHp()+"HP "+card.getSummonedEntity().getStrength()+" STR");
        }
        int choice = cardChoice();
        this.getDeck().get(choice-1).playCard(this, board);
    }
    public static int cardChoice() {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("Choose the card you want to play : ");

        selection = input.nextInt();
        return selection;
    }

    public void playTurn(Board board){
        System.out.println(this.getName() +" - Select what you want to do : ");
        System.out.println("[1] Use Card");
        System.out.println("[2] Use Special Ability");
        Scanner scanner = new Scanner(System.in);

        boolean flag = false;
        while (!flag) {
            int choice =0;
            String userInput = scanner.nextLine();
            try{
                choice = Integer.parseInt(userInput);
            }
            catch(NumberFormatException e){
                System.err.println("Please enter valid number");
            }
            if (choice == 1) {
                if (this.getDeck().size()>0) {
                    useCardMenu(board);
                    flag = true;
                }
                else{
                    log.info("No card left !");
                    System.out.println(this.getName() +" - Select what you want to do : ");
                    System.out.println("[1] Use Card");
                    System.out.println("[2] Use Special Ability");
                }
            } else if (choice == 2) {
                useSpecialAbility();
                flag = true;
            } else {
                log.error("Please enter 1 or 2. The other inputs are not acceptable !");
                System.out.println(this.getName() +" - Select what you want to do : ");
                System.out.println("[1] Use Card");
                System.out.println("[2] Use Special Ability");
            }
        }

        ArrayList<Entity> entityTeam = this.getTeam().getEntities();

        //Chaque monstre dans l'équipe joue son tour
        for (Entity entity : entityTeam) {
            if (entity.getType() != EntityTypes.CHAMPION && this.getTeam().hasChampion() && this.getTeam().hasChampion()) {
                entity.action(board);
                board.printEntities();
            }
        }
    }

}
