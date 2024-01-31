import entity.Champion;
import entity.Monsters.Cinderthing;
import entity.Monsters.Clownmask;
import entity.Monsters.Lightling;
import entity.Monsters.Monster;
import entity.SpecialAttacks.HolyWave;
import entity.SpecialAttacks.MagmaRage;
import environment.Board;
import environment.Team;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MonsterTest {

    @Test
    public void testMonsterKill() {
        Board board = new Board();
        Team blue = new Team();
        Team red = new Team();
        // Création d'un monstre et d'une cible
        Cinderthing killer = new Cinderthing(1, red);
        Clownmask victim = new Clownmask(3,blue);
        board.summonEntity(killer);
        board.summonEntity(victim);

        //Vérifie que les 2 monstres sont sur le plateau avant l'attaque
        assertEquals(2, board.getAliveEntities().size());

        // Le monstre attaque la cible
        killer.attack(victim, board);

        // Vérifie que la cible a perdu les points de vie attendus
        assertEquals(-1, victim.getHp());

        //Vérifie qu'il ne reste plus que le Cinderthing sur le plateau
        assertEquals(1, board.getAliveEntities().size());
    }

    @Test
    public void testMonsterAttack() {
        Board board = new Board();
        Team blue = new Team();
        Team red = new Team();
        // Création d'un monstre et d'une cible
        Champion targetChampion = new Champion(2, "Cible Test", 15, new HolyWave(), blue, new ArrayList<>());
        Cinderthing monster = new Cinderthing(1, red);

        // Le monstre attaque la cible
        monster.attack(targetChampion, board);

        // Vérifie que la cible a perdu les points de vie attendus
        assertEquals(11, targetChampion.getHp());
    }

    @Test
    public void testChampionSpecialAbility() {
        Board board = new Board();
        Team team1 = new Team();
        Team team2 = new Team();
        // Création de deux champions
        Champion champion1 = new Champion(1, "Champion 1", 30, new HolyWave(),team1 ,new ArrayList<>());
        Champion champion2 = new Champion(2, "Champion 2", 30, new HolyWave(),team2 ,new ArrayList<>());
        board.summonEntity(champion1);
        team1.addEntity(champion1);
        board.summonEntity(champion2);
        team2.addEntity(champion2);
        // Champion 1 utilise sa capacité spéciale (toute son équipe dont lui-même gagne 2HP)
        champion1.useSpecialAbility();

        // Vérifie que la santé de Champion 1 est augmentée, sans augmenter celle du champ2
        assertEquals(32, champion1.getHp());
        assertEquals(30, champion2.getHp());

    }

    @Test
    public void testMonsterHeal() {
        Board board = new Board();
        Team blue = new Team();
        // Création d'un monstre et d'une cible
        Champion targetChampion = new Champion(2, "Cible Test", 15, new HolyWave(), blue, new ArrayList<>());
        Lightling monster = new Lightling(1,blue);

        // Le monstre soigne la cible
        monster.heal(targetChampion, board);

        // Vérifie que la cible a été soignée de 2HP
        assertEquals(17, targetChampion.getHp());
    }

    @Test
    public void testMonsterBoostHp() {
        Team blue = new Team();
        Board board = new Board();
        // Création d'un monstre et d'une cible
        Champion targetChampion = new Champion(2, "Cible Test", 15, new HolyWave(), blue, new ArrayList<>());
        Clownmask monster = new Clownmask(1,blue);

        // Le monstre booste la cible de 1HP
        monster.boostHp(targetChampion, board);

        // Vérifie que la cible a gagné 1HP
        assertEquals(16, targetChampion.getHp());
    }

}
