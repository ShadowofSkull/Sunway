package game_mechanics;

public class PokeballRoulette {
    private static Ball[] balls = { new Ball("Normalball", 0.1, 1), new Ball("Greatball", 0.3, 2), new Ball("Ultraball", 0.5, 3),
            new Ball("Masterball", 0.9, 4) };

    private static Ball ballSelected;

    public static Ball getBallSelected() {
        return ballSelected;
    }

    public static void setBallSelected(Ball ballSelected) {
        PokeballRoulette.ballSelected = ballSelected;
    }
    
    public static void displayRoulette() throws InterruptedException {

        System.out.println("Press space to stop the roulette");

        for (int i = 0; i < balls.length; i++) {
            setBallSelected(balls[i]);
            System.out.println(ballSelected);
          
            Thread.sleep(500);


        }
    }

}
