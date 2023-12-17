package Pokemon;

public class Ally {
    private static Pokemon[] allyPokemons = new Pokemon[2];

    public static void choosePokemon(Pokemon pokemon) {
        allyPokemons[0] = RandomPokemon.getRandomPokemon();
        allyPokemons[1] = pokemon;
    }

    public static Pokemon[] getAllyPokemons() {
        return allyPokemons;
    }

    public static Pokemon[] displayPokemons() {
        System.out.println("Pick a pokemon by pressing 1-3 to choose: ");
        Pokemon pokemon1 = RandomPokemon.getRandomPokemon();
        Pokemon pokemon2 = RandomPokemon.getRandomPokemon();
        Pokemon pokemon3 = RandomPokemon.getRandomPokemon();
        System.out.println("1. " + pokemon1);
        System.out.println("2. " + pokemon2);
        System.out.println("3. " + pokemon3);

        Pokemon[] pokemons = { pokemon1, pokemon2, pokemon3 };
        return pokemons;
    }

}
