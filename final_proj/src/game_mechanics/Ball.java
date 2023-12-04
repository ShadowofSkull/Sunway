package game_mechanics;

public class Ball {
    private String type;
    private int catchChance;

    Ball(String type, int catchChance) {
        this.type = type;
        this.catchChance = catchChance;
    }

    public String getType() {
        return this.type;
    }

    public int getCatchChance() {
        return this.catchChance;
    }
}
