import game_mechanics.AttackRoulette;
import game_mechanics.Mash;
import game_mechanics.PokeballRoulette;

public class Game {
    public static void main(String[] args) throws Exception {
        Mash mash = new Mash(); 
        AttackRoulette attackRoulette = new AttackRoulette(mash);
        boolean isBattlePhase = false;
        boolean isPokeballRoulettePhase = true;
        // mash.setPhase("stopPokeballRoulette");
        // while (isPokeballRoulettePhase) {
        // PokeballRoulette.displayRoulette();
        // isPokeballRoulettePhase = false;
        // }
        // mash.setPhase("spirit");
        // timer
        // try {
        // Thread.sleep(2000);
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }
        // mash.setPhase("battle");
        mash.setPhase("attackRoulette");

        while (mash.getPhase().equals("attackRoulette")) {
            attackRoulette.displayAttackAnimation();
        }
    }

}
