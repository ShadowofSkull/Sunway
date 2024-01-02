public class LightingAppliance extends Appliance{
    private int brightness;

    public LightingAppliance(String ID, String name) {
        super(ID, name);
        this.brightness = 0;
    }

    public LightingAppliance(String ID, String name, int brightness) {
        super(ID, name);
        this.brightness = brightness;
    }

    public int getBrightness() {
        return this.brightness;
    }

    public void setBrightness(int brightness) {
        if (brightness >= 0 && brightness <= 100) {
            this.brightness = brightness;
        }
        else{
            System.out.println("Invalid brightness");
        }
    }

    @Override
    public String toString() {
        String details = super.toString();
        return String.format("%s, Brightness: %d%%", details, getBrightness());
    }
}
