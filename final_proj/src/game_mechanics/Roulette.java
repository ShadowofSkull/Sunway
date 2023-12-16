package game_mechanics;

public class Roulette {
    private Mash mash;

    public Roulette(Mash mash) {
        this.mash = mash;
    }

    public void displayAnimation(String[] animationSlides) throws InterruptedException { // displays animation
        for (String slide : animationSlides) {
            clearConsole();
            if (mash.getPhase().equals("stopAttackRoulette")) {
                break;
            }
            System.out.println(slide);
            Thread.sleep(500);
        }
    }

    private void clearConsole() { // clears the console
        System.out.println("\033c");
    }

}