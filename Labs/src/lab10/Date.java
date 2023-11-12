package lab10;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(){
        this.day = 1;
        this.month = 1;
        this.year = 2000;
    }

    public Date(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }


    /** 
     * @return int
     */
    public int getMonth() {
        return month;
    }

    
    /** 
     * @param month
     */
    public void setMonth(int month) {
        this.month = month;
    }

    
    /** 
     * @return int
     */
    public int getYear() {
        return year;
    }

    
    /** 
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }

    
    /** 
     * @return String
     */
    public String toString(){
        return String.format("%02d/%02d/%04d", this.day, this.month, this.year);
    }
    
}
