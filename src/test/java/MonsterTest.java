import entity.Champion;
import entity.Monsters.Monster;
import environment.Team;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MonsterTest {
    @Test
    public void testMonsterAttack() {
        Team blue = new Team("blue");
        // Création d'un monstre et d'une cible
        Champion targetChampion = new Champion(2, "Cible Test", 15, "Capacité Test", blue, new ArrayList<>());
        blue.setChampion(targetChampion);
        Monster monster = new Monster(1, "Monstre Test", 10, 3,blue);

        // Le monstre attaque la cible
        monster.attack(targetChampion);

        // Vérifie que la cible a perdu les points de vie attendus
        assertEquals(12, targetChampion.getHp());
    }

    @Test
    public void testChampionSpecialAbility() {
        Team team1 = new Team("Team 1");
        Team team2 = new Team("Team 2");
        // Création de deux champions
        Champion champion1 = new Champion(1, "Champion 1", 30, "Capacité spéciale 1",team1 ,new ArrayList<>());
        Champion champion2 = new Champion(2, "Champion 2", 30, "Capacité spéciale 2",team2 ,new ArrayList<>());

        team1.setChampion(champion1);
        team2.setChampion(champion2);

        // Champion 1 utilise sa capacité spéciale sur Champion 2
        champion1.useSpecialAbility(champion2);

        // Vérifie que la santé de Champion 2 est réduite
        assertEquals(15, champion2.getHp());

    }

}
