package game_mechanics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

import PokemonPack.Ally;
import PokemonPack.Pokemon;

public class Mash extends JFrame implements KeyListener {

    private String phase = "";
    private Pokemon[] pokemons;

    public Mash() {
        this.setVisible(true);
        this.addKeyListener(this);
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public void setPokemons(Pokemon[] pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // method not needed
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // method not needed
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        boolean spacePressed = (keyCode == KeyEvent.VK_SPACE);

        if (phase.equals("choosePokemon")) {

            if (keyCode == KeyEvent.VK_1) {
                System.out.println("Picked 1, Game loading please wait");
                Ally.choosePokemon(pokemons[0]);
                setPhase("battle");
            }
            if (keyCode == KeyEvent.VK_2) {
                System.out.println("Picked 2, Game loading please wait");
                Ally.choosePokemon(pokemons[1]);
                setPhase("battle");
            }
            if (keyCode == KeyEvent.VK_3) {
                System.out.println("Picked 3, Game loading please wait");
                Ally.choosePokemon(pokemons[2]);
                setPhase("battle");
            }

        }
        if (spacePressed && phase.equals("battle")) {
            System.out.println("battle");
        }

        if (spacePressed && phase.equals("attackRoulette")) {
            setPhase("stopAttackRoulette");
        }

        if (phase.equals("spirit")) {
            Timer timer = new Timer(2000);
            try {
                timer.startTimer();
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            if (spacePressed && (!timer.isTimesUp())) {
                Spirit.increaseSpirit();
                System.out.println(Spirit.getSpirit());
            }
            if (timer.isTimesUp())
                System.out.println("Times up");
        }
        if (spacePressed && phase.equals("stopPokeballRoulette")) {
            System.out.println(PokeballRoulette.getBallSelected());
        }

    }

}
