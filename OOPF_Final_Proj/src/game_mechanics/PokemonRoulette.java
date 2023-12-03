package game_mechanics;

import java.awt.event.KeyEvent;

public class PokemonRoulette {
    private static Ball[] balls = { new Ball("Normalball", 1), new Ball("Greatball", 2), new Ball("Ultraball", 3),
            new Ball("Masterball", 4) };

    public static Ball[] getBalls() {
        return balls;
    }

    public static void displayRoulette(int keyCode) {
        System.out.printf("%s %s %s %s", balls[0].getType(), balls[1].getType(), balls[2].getType(),
                balls[3].getType() );

        while (true) {
            String space = "";
            if (space == "    ")
                space = "";
            
            System.out.printf("%s*", space);
            if (keyCode == KeyEvent.VK_SPACE)
                System.out.println("test");
        }

        

    }

    public static void main(String[] args) {

    }
}
