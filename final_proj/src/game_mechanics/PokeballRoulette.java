package game_mechanics;

public class PokeballRoulette {
    private static Ball[] balls = { new Ball("Normalball", 1), new Ball("Greatball", 2), new Ball("Ultraball", 3),
            new Ball("Masterball", 4) };

    private static String ballSelected;

    public static Ball[] getBalls() {
        return balls;
    }

    public static String getBallSelected() {
        return ballSelected;
    }

    public static void setBallSelected(String ballSelected) {
        PokeballRoulette.ballSelected = ballSelected;
    }
    
    public static void displayRoulette() throws InterruptedException {

        System.out.println("Press space to stop the roulette");

        for (int i = 0; i < balls.length; i++) {
            setBallSelected(balls[i].getType());
            System.out.println(ballSelected);
          
            Thread.sleep(500);


        }
    }

}
