package Pokemon;

import java.util.Random;

public class RandomPokemon {
    // can be implement in pokemon class or extend pokemon
    private static Pokemon[] pokemons = { new Pokemon("Charmander", 100, 100, 100, 100, 100, 100, 100, 100, 100, 100),
            new Pokemon("Squirtle", 100, 100, 100, 100, 100, 100, 100, 100, 100, 100),
            new Pokemon("Bulbasaur", 100, 100, 100, 100, 100, 100, 100, 100, 100, 100) };

    public static Pokemon getRandomPokemon() {
        Random rand = new Random();
        int randNum = rand.nextInt(3);
        return pokemons[randNum];
    }

}
