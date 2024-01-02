import java.util.ArrayList;

public class User {
    private String name;
    private String email;
    private String password;
    private ArrayList<Room> rooms;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.rooms = new ArrayList<Room>();
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Room> getRooms() {
        return this.rooms;
    }

    public Room getRoom(String ID){
        for (int i = 0; i < this.rooms.size(); i++) {
            if (this.rooms.get(i).getID().equals(ID)) {
                return this.rooms.get(i);
            }
        }
        System.out.println("Room not found");
        return null;
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
        System.out.println("Room added");
    }

    public void deleteRoom(String ID){
        for (int i = 0; i < this.rooms.size(); i++) {
            if (this.rooms.get(i).getID().equals(ID)) {
                this.rooms.remove(i);
                System.out.println("Room deleted");
                return;
            }
        }
        System.out.println("Room not found");
    }

    public void displayRooms(){
        if (this.rooms.size() == 0) {
            System.out.println("No rooms found");
            return;
        }
        for (Room room: this.rooms) {
            System.out.println(room);
        }
        System.out.println();
    }

    @Override
    public String toString(){
        return String.format("Name: %s, Email: %s, Password: %s, Rooms: %s", getName(), getEmail(), getPassword(), getRooms());
    }


}
