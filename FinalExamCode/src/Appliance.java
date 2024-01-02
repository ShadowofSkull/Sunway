public class Appliance {
    private String ID;
    private String name;
    private boolean status;

    public Appliance(String ID, String name) {
        this.ID = ID;
        this.name = name;
        this.status = false;
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

    public boolean getStatus() {
        return this.status;
    }

    public void changeStatus() {
        this.status = !this.status;
    }


    @Override
    public String toString() {
        return String.format("ID: %s, Name: %s, Status: %s", getID(), getName(), getStatus() == true ? "Active" : "Non-Active");
    }
    

}
