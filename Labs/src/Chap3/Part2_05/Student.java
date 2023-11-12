package Chap3.Part2_05;

public class Student {
    private String name;
    private int semester;
    private String course;

    Student(String name, int semester, String course){
        this.name = name;
        this.semester = semester;
        this.course = course;
    }

    public String toString(){
        return String.format("Student with name %s studies course %s in semester %s", name, course, semester);
    }

    public void checkEligibility(){
        if(this.semester >= 4 && this.semester <= 6){
            System.out.printf("Student with name %s studies course %s in semester %s", name, course, semester);
            System.out.println(" is eligible to get credit exemption");
            return;
        }
        System.out.printf("Student with name %s studies course %s in semester %s", name, course, semester);
        System.out.println(" is not eligible to get credit exemption");
    }

    public String getName() {
        return name;
    }

    public int getSemester() {
        return semester;
    }

    public String getCourse() {
        return course;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
