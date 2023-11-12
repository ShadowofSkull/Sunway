package Chap3.Part1_04;

import java.util.ArrayList;

public class cartest {
    
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car("Ford", "black", 5, 100);
        ArrayList<Car> carArr = new ArrayList<Car>();
        // System.out.println(car1);
        //12
        carArr.add(car1);
        carArr.add(car2);
        for(int i = 0; i < carArr.size(); i++){
            System.out.println(carArr.get(i));
        }
        //8-9
        // System.out.println(car1.getBrand());
        // System.out.println(car2.getBrand());
        // System.out.println(car2.getColour());
        // System.out.println(car2.getEngine_size());
        // System.out.println(car2.getSpeed());
        // car2.setBrand("Toyota");
        // System.out.println(car2.getBrand());
        // car2.decelerate();
        // System.out.println(car2.getSpeed());
        // car2.accelerate();
        // System.out.println(car2.getSpeed());
        // car2.stop();
        // System.out.println(car2.getSpeed());
        //7
        // System.out.println(car2.toString());
    }
}
