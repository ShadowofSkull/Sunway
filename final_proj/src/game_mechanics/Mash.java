package game_mechanics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;


public class Mash extends JFrame implements KeyListener {
    
    private String phase = "";

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

        if (spacePressed && phase.equals("stopPokeballRoulette")) {
            System.out.println(PokeballRoulette.getBallSelected());
            
        } 
        if (spacePressed && phase.equals("battle")) {
            System.out.println("battle");
        } 
        if (spacePressed && phase.equals("spirit")) {
            Spirit.increaseSpirit();
            System.out.println(Spirit.getSpirit());
        }
        if (spacePressed && phase.equals("attackRoulette")) {
            setPhase("stopAttackRoulette");
        }

    }

}
