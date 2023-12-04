package lab08;

public class Date {
    private int day;
    private int month;
    private int year;
    private String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private int[] monthDays = {31,28,31,30,31,30,31,31,30,31,30,31};

    
    Date(){
        this.day = 1;
        this.month = 1;
        this.year = 2012;
    }

    Date(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    Date(String monthStr, int day, int year){
        convertFromMonthName(monthStr);
        this.day = day;
        this.year = year;
    }

    Date(int daysInYear, int year){
        this.year = year;
        convertFromDayOfYear(daysInYear);
    }
    
    public void setDay(int day) {
        if(day < 0){
            System.out.println("Invalid day");
            return;
        }
        int MAX_DAY = daysInMonth(this.month);
        if (day > MAX_DAY){
            System.out.println("Invalid day");
            return;
        }
        this.day = day;
    }
    
    public void setMonth(int month) {
        if (month < 1 || month > 12){
            System.out.println("Invalid month");
            return;
        }
        this.month = month;
    }
    
    public void setYear(int year) {
        if (year < 1900 || year > 2100){
            System.out.println("Invalid year");
            return;
        }
        this.year = year;
    }
    
    public String toString() {
        return day + "/" + month + "/" + year;
    }

    public String toMonthNameDateString() {
        return monthNames[month-1] + " " + day + ", " + year;
    }

    public String toDayDateString() {
        int daysInYear = convertToDayOfYear();
        return daysInYear + " " + year;        
    }

    public void convertFromMonthName(String monthStr){
        for (int i = 0; i < monthNames.length; i++) {
            if (monthStr.equals(monthNames[i])){
                this.month = i + 1;
                return;
            }
        }
        System.out.println("Invalid month name");
        this.month = 1;
    }

    public void convertFromDayOfYear(int ddd){
        if(ddd >= 1 && ddd <= 365){
            int i = 0;
            while (ddd > monthDays[i]){
                ddd -= monthDays[i];
                i++;
            }
            this.month = i + 1;
            this.day = ddd;
            return;
        }
        else{
            this.day = 1;
            this.month = 1;
        }
    }

    public int convertToDayOfYear(){
        int ddd = day;
        for (int i = 1; i < this.month; i++) {
            ddd += daysInMonth(i);
        }
        return ddd;
    }

    public int daysInMonth(int month){
        if (leapYear() && month == 2){
            return 29;
        }
        return monthDays[month-1];
        
    }

    public boolean leapYear(){
        if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){
            return true;
        }
        return false;
    }
}
