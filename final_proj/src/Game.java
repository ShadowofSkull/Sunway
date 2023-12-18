import PokemonPack.Ally;
import PokemonPack.Enemy;
import PokemonPack.Pokemon;
import game_mechanics.Attack;
import game_mechanics.AttackRoulette;
import game_mechanics.Mash;
import game_mechanics.PokeballRoulette;

public class Game {
    public static void main(String[] args) throws Exception {
        // Class to track keyboard input
        Mash mash = new Mash();

        // Choose one out of three pokemons
        mash.setPhase("choosePokemon");
        Pokemon[] pokemons = Ally.displayPokemons();
        mash.setPokemons(pokemons);

        // Force pick for player after 5 seconds
        Thread.sleep(5000);
        if (Ally.getAllyPokemons().length != 2){
            Ally.choosePokemon(pokemons[0]);
        }
            

        // Display enemy pokemons
        System.out.println(Enemy.toStringEnemyPokemons());
        // Display ally pokemons
        System.out.println(Ally.toStringAllyPokemons());
        Thread.sleep(5000);
        // Battle phase
        // Attack phase
        // Attack roulette require mash to be passed in to determine when to stop the
        // roulette display
        // AttackRoulette attackRoulette = new AttackRoulette(mash);
        mash.setPhase("attackRoulette");
        // while (mash.getPhase().equals("attackRoulette")) {

        //     attackRoulette.displayAttackAnimation();
        // }
        // // Spirit phase
        // mash.setPhase("spirit");
        // Thread.sleep(2000);
        // mash.setPhase("");
        Attack attack = new Attack(new AttackRoulette(mash), mash);
        attack.attack();
        // Defense phase

        // Catch phase

        // Pokeball roulette

    }

}
