package lab10;

public class Employee extends Date{
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Date hireDate;

    public Employee(String firstName, String lastName, Date birthDate, Date hireDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
    }

    
    /** 
     * @return String
     */
    public String getFirstName() {
        return firstName;
    }

    
    /** 
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    /** 
     * @return String
     */
    public String getLastName() {
        return lastName;
    }

    
    /** 
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    /** 
     * @return Date
     */
    public Date getBirthDate() {
        return birthDate;
    }

    
    /** 
     * @param birthDate
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    
    /** 
     * @return Date
     */
    public Date getHireDate() {
        return hireDate;
    }

    
    /** 
     * @param hireDate
     */
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
    
    /** 
     * @return String
     */
    public String toString(){
        return String.format("Employee with first name %s and last name %s has birthday on %s and was hired on %s", firstName, lastName, birthDate.toString(), hireDate.toString());
    }
}
