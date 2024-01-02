public class App {
    public static void main(String[] args) throws Exception {
        // Create a user
        User user = new User("John", "j@gmail.com", "123456");
        // Create a room
        Room room1 = new Room("R001", "Living Room");

        // Create appliances
        Appliance appliance1 = new LightingAppliance("A001", "Study Lamp");
        Appliance appliance2 = new CoolingAppliance("A002", "Fan");
        Appliance appliance3 = new Appliance("A003", "TV");

        // Add appliances to room
        room1.addAppliance(appliance1);
        room1.addAppliance(appliance2);
        room1.addAppliance(appliance3);
        // Add room to user
        user.addRoom(room1);

        // Display the initial rooms and appliances in the room under an user
        System.out.println("Initial state of all appliances");
        for (Room room : user.getRooms()) {
            room.displayAppliances();
        }

        // Turning on all appliances in all rooms under an user
        for (Room room : user.getRooms()) {
            for (Appliance appliance : room.getAppliances()) {
                appliance.changeStatus();
            }
        }

        // Adjust speed of fan
        ((CoolingAppliance) user.getRoom("R001").getAppliance("A002")).setSpeed(3);

        // Adjust the brightness of the lamp
        ((LightingAppliance) user.getRoom("R001").getAppliance("A001")).setBrightness(50);

        // Display the appliances details from all rooms under an user
        System.out.println("Updated state of all appliances");
        for (Room room : user.getRooms()) {
            room.displayAppliances();
        }

        // Additional features
        // Add another new room
        System.out.println("Add another new room");
        Room room2 = new Room("R002", "Bedroom");
        user.addRoom(room2);
        
        // Display rooms details under an user
        System.out.println("Rooms under an user");
        user.displayRooms();

        // Delete a room
        System.out.println("Delete a room");
        user.deleteRoom("R002");
        // Rooms that are left under an user
        System.out.println("Rooms under an user");
        user.displayRooms();

        // Delete an appliance
        System.out.println("Delete an appliance");
        user.getRoom("R001").deleteAppliance("A003");
        user.getRoom("R001").displayAppliances();

    }
}
