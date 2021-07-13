package Java_OOP;

public abstract class Student {

    private String id;
    private String firstName;
    private String lastName;
    private String age;
    private int units; 

    public Student(String id, String firstName, String lastName, String age, int units){
         this.id = id;
         this.firstName = firstName;
         this.lastName = lastName;
         this.age = age;
         this.units = units;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = id;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

   public abstract void printData();

   public abstract int computeFees();

}
    
