package lab11;

public class Dog {
    private String name;
    private int leg;
    private int meter;

    Dog(String nm, int lg)
    {
        name = nm;
        leg = lg;
        meter = 0;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLeg() {
        return this.leg;
    }

    public void setLeg(int leg) {
        this.leg = leg;
    }

    public int getMeter() {
        return this.meter;
    }

    public void setMeter(int meter) {
        this.meter = meter;
    }

    public void run()
    {
        System.out.println(name + " ran " + meter + " meters.");
    }

    public void eat()
    {
        System.out.println(name + " ate " + meter + " kilograms of food.");
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", leg='" + getLeg() + "'" +
            ", meter='" + getMeter() + "'" +
            "}";
    }

    
}
