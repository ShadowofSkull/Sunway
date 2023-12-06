import game_mechanics.PokemonRoulette;
import game_mechanics.Spirit;

import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game {
    public static void main(String[] args) throws Exception {
        boolean isBattlePhase = false;
        boolean isPokemonRoulettePhase = true;
        if (isPokemonRoulettePhase) {
            PokemonRoulette.displayRoulette();
        }
        // Create a new JFrame
        JFrame frame = new JFrame();
        // Use frame to capture keyboard events
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                boolean spacePressed = (keyCode == KeyEvent.VK_SPACE);
                System.out.println(spacePressed);

                // will have to add extra conditions to check what phase the game is in to
                // determine what to do when space is pressed
                if (keyCode == KeyEvent.VK_SPACE && isBattlePhase) {
                    Spirit.increaseSpirit();
                    System.out.println(Spirit.getSpirit());
                }

            }
        });
        // Frame has to be visible to capture keyboard events
        frame.setVisible(true);

    }
}
