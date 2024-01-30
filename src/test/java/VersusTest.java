import entity.Card;
import entity.Champion;
import entity.Entity;
import entity.EntityTypes;
import entity.Monsters.Aurastral;
import entity.Monsters.Cinderthing;
import entity.Monsters.Clownmask;
import entity.Monsters.Lightling;
import entity.SpecialAttacks.HolyWave;
import entity.SpecialAttacks.MagmaRage;
import entity.SpecialAttacks.SpecialAbilitySelector;
import entity.SpecialAttacks.SpecialAttacks;
import environment.Board;
import environment.Team;
import environment.UniqueIdentifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

public class VersusTest {

    @Test
    public void versusTest(){
        Logger log = LogManager.getLogger(VersusTest.class);
        log.info("Versus Test");
        String winner="";

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
        System.out.println("-- Création Joueur 1 --");
        String player1Name = "P1";
        log.info(player1Name+" picks Magma Rage");
        SpecialAttacks player1Ability = new MagmaRage();
        Champion player1 = new Champion(idGenerator.getUniqueID(),player1Name,30, player1Ability, p1Team, p1Deck);
        p1Team.addEntity(player1);
        board.summonEntity(player1);

        System.out.println("-- Création Joueur 2 --");
        String player2Name = "P2";
        log.info(player2Name+" picks Holy Wave");
        SpecialAttacks player2Ability = new HolyWave();
        Champion player2 = new Champion(idGenerator.getUniqueID(),player2Name,1, player2Ability, p2Team, p2Deck);
        p2Team.addEntity(player2);
        board.summonEntity(player2);

        //Création des cartes
        Card cinderthingCard1 = new Card(idGenerator.getUniqueID(), new Cinderthing(idGenerator.getUniqueID(), p1Team));

        //Remplissage du deck du champion 1
        p1Deck.add(cinderthingCard1);

        int turn = 1;
        log.info("---- GAME STARTED ----");
        while (p1Team.hasChampion() && p2Team.hasChampion()){
            log.info("---- [TURN "+ turn +"] ----");
            log.info("[TURN "+ turn +"] : "+player1Name + "'s turn begins");
            board.printEntities();
            log.info(player1Name+ " hits "+ player2Name+ " in the face ! \n -99HP !");
            player2.receiveAttack(99,board);

            if (p1Team.hasChampion() && p2Team.hasChampion()) {
                log.info("[TURN " + turn + "] : " + player2Name + "'s turn begins");
                board.printEntities();
                player2.playTurn(board);
                for (Entity entity : p2Team.getEntities()) {
                    if (entity.getType() != EntityTypes.CHAMPION && p1Team.hasChampion() && p2Team.hasChampion()) {
                        entity.action(board);
                        board.printEntities();
                    }
                }
            }
            else{
                if (player1.getHp()<0 && player2.getHp()<0) winner = "EVEN!";
                if (player1.getHp()<0) winner = player2Name;
                if (player2.getHp()<0) winner = player1Name;
            }
            board.printEntities();
            turn ++;
        }
        log.info("Winner is : "+winner);

        assertEquals("P1",winner);
    }
}
