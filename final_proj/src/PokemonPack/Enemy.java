package PokemonPack;

import java.util.Arrays;

public class Enemy {
    private static Pokemon[] enemyPokemons = { Pokemon.getRandomPokemon(), Pokemon.getRandomPokemon() };

    public static Pokemon[] getEnemyPokemons() {
        return enemyPokemons;
    }

    public static String toStringEnemyPokemons() {
        return Arrays.toString(enemyPokemons);
    }
}
