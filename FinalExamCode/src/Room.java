import java.util.ArrayList;

public class Room{
    private String ID;
    private String name;
    private ArrayList<Appliance> appliances;

    public Room(String ID, String name) {
        this.ID = ID;
        this.name = name;
        this.appliances = new ArrayList<Appliance>();
    }

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Appliance> getAppliances() {
        return this.appliances;
    }

    public Appliance getAppliance(String ID){
        for (int i = 0; i < this.appliances.size(); i++) {
            if (this.appliances.get(i).getID().equals(ID)) {
                return this.appliances.get(i);
            }
        }
        System.out.println("Appliance not found");
        return null;
    }

    public void addAppliance(Appliance appliance) {
        this.appliances.add(appliance);
        System.out.println("Appliance added");
    }
    
    public void deleteAppliance(String ID){
        for (int i = 0; i < this.appliances.size(); i++) {
            if (this.appliances.get(i).getID().equals(ID)) {
                this.appliances.remove(i);
                System.out.println("Appliance deleted");
                return;
            }
        }
        System.out.println("Appliance not found");
    }

    public void displayAppliances(){
        if (this.appliances.size() == 0) {
            System.out.println("No appliances found");
            return;
        }
        System.out.println(this);
        for (Appliance appliance: this.appliances) {
            System.out.println(appliance);
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Name: %s, No. of Appliances: %d", getID(), getName(), getAppliances().size());
    }
}