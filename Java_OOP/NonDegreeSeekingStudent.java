package Java_OOP;

public abstract class NonDegreeSeekingStudent extends Student{
    
    public NonDegreeSeekingStudent(String id, String firstName, String lastName, String age, int units){
        super(id, firstName, lastName, age, units);
    }

    public abstract void printData();
    
    public abstract int computeFees();

}
