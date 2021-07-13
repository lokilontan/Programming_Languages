package Java_OOP;

public class DegreeSeekingStudent extends Student{
    
    private String major;
    private String standing;

    public DegreeSeekingStudent(String id, String firstName, String lastName, String age, int units, String major, String standing) {
        super(id, firstName, lastName, age, units);
        this.major = major;
        this.standing = standing;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getStanding() {
        return standing;
    }

    public void setStanding(String standing) {
        this.standing = standing;
    }

    @Override
    public void printData() {
        System.out.println("ID number: " + getId() + 
                           "\nName: " + getFirstName() + " " + getLastName() + 
                           "\nAge: " + getAge() + 
                           "\n" + 
                           "\n" + getFirstName() + " is a degree-seeking student enrolled in " + getUnits() + " credits" + 
                           "\n" + getFirstName() + " does not receive financial assistance" + 
                           "\n" + getFirstName() + "`s major is " + major + 
                           "\n" + getFirstName() + "`s academic standing is " + standing);
    }

    @Override
    public int computeFees() {
        int fees = 3450;
        if (getUnits() < 12) {
            fees = 100 + 50 + 275 * getUnits();
        }
        return fees;
    }
}
