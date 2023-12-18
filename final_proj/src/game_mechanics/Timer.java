package game_mechanics;
public class Timer {
    private int milliseconds;
    private boolean timesUp;
    public Timer(int milliseconds) {
        this.milliseconds = milliseconds;
        timesUp = false;
    }

    public void startTimer() throws InterruptedException {
        Thread.sleep(milliseconds);
        timesUp = true;
    }

    public boolean isTimesUp() {
        return timesUp;
    }
}
