package PokemonPack;

import java.util.Arrays;

public class Ally {
    private static Pokemon[] allyPokemons = new Pokemon[2];

    public static void choosePokemon(Pokemon pokemon) {
        allyPokemons[0] = Pokemon.getRandomPokemon();
        allyPokemons[1] = pokemon;
    }

    public static Pokemon[] getAllyPokemons() {
        return allyPokemons;
    }

    public static String toStringAllyPokemons() {
        return Arrays.toString(allyPokemons);
    }

    public static Pokemon[] displayPokemons() {
        System.out.println("Pick a pokemon by pressing 1-3 to choose: ");
        System.out.println("Please pick within 5 seconds");
        Pokemon pokemon1 = Pokemon.getRandomPokemon();
        Pokemon pokemon2 = Pokemon.getRandomPokemon();
        Pokemon pokemon3 = Pokemon.getRandomPokemon();
        System.out.println("1. " + pokemon1.getName());
        System.out.println("2. " + pokemon2.getName());
        System.out.println("3. " + pokemon3.getName());

        Pokemon[] pokemons = { pokemon1, pokemon2, pokemon3 };
        return pokemons;
    }


}
