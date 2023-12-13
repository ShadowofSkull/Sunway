package lab11;

public class TestAnimal {
    public static void main(String[] args) {
        Dog dog = new Dog("Barky", 4);
        dog.setMeter(10);
        dog.run();
        dog.setMeter(5);
        dog.eat();
        System.out.println(dog.toString());
        
    }
}
