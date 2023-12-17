package Pokemon;

public class Enemy {
    private static Pokemon[] enemyPokemons = { RandomPokemon.getRandomPokemon(), RandomPokemon.getRandomPokemon() };

    public static Pokemon[] getEnemyPokemons() {
        return enemyPokemons;
    }

}
