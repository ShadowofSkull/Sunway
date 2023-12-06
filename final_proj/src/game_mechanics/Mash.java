package game_mechanics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Mash implements KeyListener {
    private PokemonRoulette pokemonRoulette;

    public Mash(PokemonRoulette pokemonRoulette) {
        this.pokemonRoulette = pokemonRoulette;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        boolean spacePressed = (keyCode == KeyEvent.VK_SPACE);

        if (keyCode == KeyEvent.VK_SPACE) {
            Spirit.increaseSpirit();
            System.out.println(Spirit.getSpirit());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }

}
