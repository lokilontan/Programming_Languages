package Java_OOP;

public class SeniorCitizen extends NonDegreeSeekingStudent {

    public SeniorCitizen(String id, String firstName, String lastName, String age, int units) throws Exception{
        super(id, firstName, lastName, age, units);
        if (Integer.parseInt(age) < 65) {
            throw new Exception("Senior Citizen has to be 65 or older");
        } 
    }

    @Override
    public void printData() {
        System.out.println("ID number: " + getId() + 
                           "\nName: " + getFirstName() + " " + getLastName() + 
                           "\nAge: " + getAge() + 
                           "\n" + 
                           "\n" + getFirstName() + " is a non-degree-seeking \"Senior Citizen\" student enrolled in " + getUnits() + " credits" + 
                           "\n" + getFirstName() + " does not receive financial assistance");
    }

    @Override
    public int computeFees() {
        int fees = 0;

        if ( getUnits() > 0 ) {
            fees = 100;
        }

        if (getUnits() > 6) {
            fees += (getUnits()-6) * 50;
        }

        return fees;
    }

    
}
