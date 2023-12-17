import java.util.Random;

import Pokemon.Enemy;
import game_mechanics.Ball;
import game_mechanics.PokeballRoulette;

public class Catch {
    private static int hp;

    public static int getHp() {
        return hp;
    }

    public static void setHp(int hp) {
        Catch.hp = hp;
    }

    public static boolean pokemonCatchable() {
        // this.hp = Pokemon.getHP();
        // temp placeholder to get hp
        if (hp == 0)
            return true;
        return false;
    }

    public static void pokeballCaught() {
        int pokemonGrade = Enemy.getGrade();
        Ball pokeball = PokeballRoulette.getBallSelected();
        int ballGrade = pokeball.getCatchGrade();
        int catchChance = (int) (pokeball.getCatchChance() * 10);
        boolean allowCatch = false;
        
        Random rand = new Random();
        int randNum = rand.nextInt(10);
        // Chance system
        switch (catchChance) {
            case 1:
                if (randNum == 0)
                    allowCatch = true;
                break;
            case 3:
                for (int i = 0; i < 3; i++) {
                    if (randNum == i)
                        allowCatch = true;
                }
                break;
            case 5:
                for (int i = 0; i < 5; i++) {
                    if (randNum == i)
                        allowCatch = true;
                }
                break;
            case 9:
                for (int i = 0; i < 9; i++) {
                    if (randNum == i)
                        allowCatch = true;
                }
        
            default:
                System.out.println("Error in catch chance");
                break;
        }
        
        // comparing grade of enemy pokemon to grade of pokeball and chance
        if (pokemonGrade <= ballGrade && allowCatch) {
            System.out.println("Pokemon caught");
        } else {
            System.out.println("Pokemon not caught");
        }
    }
}
