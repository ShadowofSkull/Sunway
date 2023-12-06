package game_mechanics;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class PokemonRoulette {
    private static Ball[] balls = { new Ball("Normalball", 1), new Ball("Greatball", 2), new Ball("Ultraball", 3),
            new Ball("Masterball", 4) };

    public static Ball[] getBalls() {
        return balls;
    }

    public static String displayRoulette() {

        System.out.println("Press space to stop the roulette");
        String ballName = "";
        while (!spacePressed) {
            for (int i = 0; i < balls.length; i++) {
                ballName = balls[i].getType();
                System.out.println(ballName);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return ballName;

    }

    public static void main(String[] args) {
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
