package game_mechanics;

public class Attack{
    private AttackRoulette attackRoulette;
    private Mash mash;

    public Attack(AttackRoulette attackRoulette, Mash mash) {
        this.attackRoulette = attackRoulette;
        this.mash = mash;
    }

    public void attack() throws InterruptedException{
        while (mash.getPhase().equals("attackRoulette")) {
            attackRoulette.displayAttackAnimation();
        }
        mash.setPhase("spirit");
        Thread.sleep(2000);
        mash.setPhase("");
        System.out.println("Spirit: " + Spirit.getSpirit());
    }
}
