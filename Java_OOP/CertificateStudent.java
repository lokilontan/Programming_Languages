package Java_OOP;

public class CertificateStudent extends NonDegreeSeekingStudent {

    private String major;

    public CertificateStudent(String id, String firstName, String lastName, String age, int units, String major) {
        super(id, firstName, lastName, age, units);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public void printData() {
        System.out.println("ID number: " + getId() + 
                           "\nName: " + getFirstName() + " " + getLastName() + 
                           "\nAge: " + getAge() + 
                           "\n" + 
                           "\n" + getFirstName() + " is a non-degree-seeking \"Certificate Student\" enrolled in " + getUnits() + " credits" + 
                           "\n" + getFirstName() + " does not receive financial assistance" + 
                           "\n" + getFirstName() + "`s major is " + getMajor());
    }

    @Override
    public int computeFees() {
        int fees = 0;

        if ( getUnits() > 0 ) {
            fees = 700;
            fees += getUnits() * 300;
        }

        return fees;
    }

    
    
}
