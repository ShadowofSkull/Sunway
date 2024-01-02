public class CoolingAppliance extends Appliance{
    private int speed;

    public CoolingAppliance(String ID, String name) {
        super(ID, name);
        this.speed = 0;
    }

    public CoolingAppliance(String ID, String name, int speed) {
        super(ID, name);
        this.speed = speed;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        if (speed >= 0 && speed <= 5) {
            this.speed = speed;
        }
        else{
            System.out.println("Invalid speed");
        }
    }

    @Override
    public String toString() {
        String details = super.toString();
        return String.format("%s, Speed: %d", details, getSpeed());
    }
}
