import entity.Card;
import entity.Champion;
import entity.Entity;
import entity.EntityTypes;
import entity.Monsters.*;
import entity.SpecialAttacks.HolyWave;
import entity.SpecialAttacks.SpecialAbilitySelector;
import entity.SpecialAttacks.SpecialAttacks;
import environment.Board;
import environment.Team;
import environment.UniqueIdentifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.Appender;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


import static environment.ConsoleColors.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Logger log = LogManager.getLogger(Main.class);

        log.info("FLINOIS André-Mathys et ZHU Yuzhe");

        //Unique Identifier
        UniqueIdentifier idGenerator = new UniqueIdentifier();

        //Création des équipes
        Team p1Team = new Team();
        Team p2Team = new Team();

        //Ability Selector
        SpecialAbilitySelector abilitySelector = new SpecialAbilitySelector();

        //Création du plateau
        Board board = new Board();

        //Initialisation des decks
        ArrayList<Card> p1Deck = new ArrayList<>();
        ArrayList<Card> p2Deck = new ArrayList<>();

        //Création des champions
        Scanner scanner = new Scanner(System.in);
        System.out.println(BLUE+"-- Player 1 Building --");
        System.out.println("Player 1 Name : ");
        String player1Name = scanner.nextLine();
        System.out.println(player1Name+" picks its special ability : ");
        SpecialAttacks player1Ability = abilitySelector.pickAbility();
        Champion player1 = new Champion(idGenerator.getUniqueID(),player1Name,30, player1Ability, p1Team, p1Deck);
        p1Team.addEntity(player1);
        board.summonEntity(player1);

        System.out.println(RESET+RED+"-- Player 2 Building --");
        System.out.println("Player 2 Name: ");
        String player2Name = scanner.nextLine();
        System.out.println(player2Name+" picks its special ability : ");
        SpecialAttacks player2Ability = abilitySelector.pickAbility();
        Champion player2 = new Champion(idGenerator.getUniqueID(),player2Name,30, player2Ability, p2Team, p2Deck);
        p2Team.addEntity(player2);
        board.summonEntity(player2);

        //Création des cartes
        Card aurastralCard1 = new Card(idGenerator.getUniqueID(), new Aurastral(idGenerator.getUniqueID(),p1Team));
        Card cinderthingCard1 = new Card(idGenerator.getUniqueID(), new Cinderthing(idGenerator.getUniqueID(), p1Team));
        Card clownmaskCard1 = new Card(idGenerator.getUniqueID(), new Clownmask(idGenerator.getUniqueID(), p1Team));
        Card lightlingCard1 = new Card(idGenerator.getUniqueID(), new Lightling(idGenerator.getUniqueID(), p1Team));

        Card aurastralCard2 = new Card(idGenerator.getUniqueID(), new Aurastral(idGenerator.getUniqueID(),p2Team));
        Card cinderthingCard2 = new Card(idGenerator.getUniqueID(), new Cinderthing(idGenerator.getUniqueID(), p2Team));
        Card clownmaskCard2 = new Card(idGenerator.getUniqueID(), new Clownmask(idGenerator.getUniqueID(), p2Team));
        Card lightlingCard2 = new Card(idGenerator.getUniqueID(), new Lightling(idGenerator.getUniqueID(), p2Team));

        //Remplissage du deck du champion 1
        p1Deck.add(aurastralCard1);
        p1Deck.add(cinderthingCard1);
        p1Deck.add(clownmaskCard1);
        p1Deck.add(lightlingCard1);
        //Remplissage du deck du champion 2
        p2Deck.add(aurastralCard2);
        p2Deck.add(cinderthingCard2);
        p2Deck.add(clownmaskCard2);
        p2Deck.add(lightlingCard2);


        int turn = 1;
        String winner="";

        log.info(RESET+"---- GAME STARTED ----");
        while (player1.getHp() > 0 && player2.getHp() > 0 ){
            log.info("---- [TURN "+ turn +"] ----");

            //Tour du joueur 1
            if (p1Team.hasChampion() && p2Team.hasChampion()) {
                log.info(BLUE+"[TURN " + turn + "] : " + player1Name + "'s turn begins");
                board.printEntities();
                player1.playTurn(board);
                log.info(RESET);
            }

            //Tour du joueur 2
            if (p1Team.hasChampion() && p2Team.hasChampion()) {
                log.info(RED+"[TURN " + turn + "] : " + player2Name + "'s turn begins");
                board.printEntities();
                player2.playTurn(board);
                log.info(RESET);
            }
            turn ++;
        }
        //Détermination du vainqueur
        if (!player1.isAlive() && !player2.isAlive()) winner = "EVEN!";
        else if(!player1.isAlive()) winner = player2Name;
        else if (!player2.isAlive()) winner = player1Name;

        log.info(YELLOW_BOLD_BRIGHT+"Winner is : "+winner);
        board.printEntities();
    }
}
