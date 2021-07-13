package Java_OOP;

public class DegreeSeekingStudentWFA extends DegreeSeekingStudent {
    
    private int FAPerTerm;

    public DegreeSeekingStudentWFA(String id, String firstName, String lastName, String age, int units, String major, String standing, int FAPerTerm){
        super(id, firstName, lastName, age, units, major, standing);
        this.FAPerTerm = FAPerTerm;
    }

    public int getFAPerTerm() {
        return FAPerTerm;
    }

    public void setFAPerTerm(int FAPerTerm) {
        this.FAPerTerm = FAPerTerm;
    }

    @Override
    public void printData() {
        System.out.println("ID number: " + getId() + 
                           "\nName: " + getFirstName() + " " + getLastName() + 
                           "\nAge: " + getAge() + 
                           "\n" + 
                           "\n" + getFirstName() + " is a degree-seeking student enrolled in " + getUnits() + " credits" + 
                           "\n" + getFirstName() + " receives " + FAPerTerm + " in financial assistance per term" + 
                           "\n" + getFirstName() + "`s major is " + getMajor() + 
                           "\n" + getFirstName() + "`s academic standing is " + getStanding());
    }

    @Override
    public int computeFees() {
        int fees = 3450;
        if (getUnits() < 12) {
            fees = 100 + 50 + 275 * getUnits();
        }

        fees -= FAPerTerm;

        if (fees < 0) {
            fees = 0;
        }

        return fees;
    }


}
