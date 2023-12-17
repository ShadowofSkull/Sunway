import Pokemon.Ally;
import game_mechanics.AttackRoulette;
import game_mechanics.Mash;
import game_mechanics.PokeballRoulette;

public class Game {
    public static void main(String[] args) throws Exception {
        Mash mash = new Mash();
        AttackRoulette attackRoulette = new AttackRoulette(mash);

        // while (isPokeballRoulettePhase) {
        // PokeballRoulette.displayRoulette();
        // isPokeballRoulettePhase = false;
        // }

        mash.setPhase("attackRoulette");

        while (mash.getPhase().equals("attackRoulette")) {
            attackRoulette.displayAttackAnimation();
        }

        mash.setPhase("choosePokemon");
    }

}
