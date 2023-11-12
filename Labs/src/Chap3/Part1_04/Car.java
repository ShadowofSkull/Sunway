package Chap3.Part1_04;


public class Car {
    //4
    private String brand;
    private String colour;
    private int engine_size;
    private int speed;

    //5
    public Car(){
        this.brand = "NA";
        this.colour = "NA";
        this.engine_size = 0;
        this.speed = 0;
    }

    public Car(String brand, String colour, int engine_size, int speed){
        this.brand = brand;
        this.colour = colour;
        this.engine_size = engine_size;
        this.speed = speed;
    }

    public String toString(){
        return String.format("The car with brand %s, color %s, engine size %s is running at speed %s", this.brand, this.colour, this.engine_size, this.speed);
    }

    public void accelerate(){
        this.speed++;
    }

    public void decelerate(){
        this.speed--;
    }

    public void stop(){
        this.speed = 0;
    }

    public String getBrand(){
        return this.brand;
    }

    public void setBrand(String b){
        this.brand = b;
    }

    public String getColour(){
        return this.colour;
    }

    public void setColour(String c){
        this.colour = c;
    }

    public int getEngine_size(){
        return this.engine_size;
    }

    public void setEngine_size(int e){
        this.engine_size = e;
    }

    public int getSpeed(){
        return this.speed;
    }

    public void setSpeed(int s){
        this.speed = s;
    }
    

}
