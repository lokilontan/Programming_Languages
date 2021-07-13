package Java_OOP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static ArrayList<Student> students;

    public static void main(String[] args) {

        students = new ArrayList<Student>();

        if (args.length == 0) {
            interactive();
        } else if (args.length == 1) {
            ArrayList<String> studentsData = new ArrayList<String>();
            try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (!line.isEmpty()) {
                        studentsData.add(line);
                    }
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                System.exit(1);
            }
            batch(studentsData);
        } else {
            System.out.println("Wrong number of arguments!");
            System.exit(1);
        }

        // REPORT 1
        System.out.println("===========================REPORT 1===========================");
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).getId() + ", " + students.get(i).getFirstName() + " "
                    + students.get(i).getLastName() + ": $" + students.get(i).computeFees());
        }

        // REPORT 2
        System.out.println();
        System.out.println("===========================REPORT 2===========================");

        int degreeFees = 0;
        int degreeFAFees = 0;
        int certificateFees = 0;
        int seniorFees = 0;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i) instanceof DegreeSeekingStudentWFA) {
                degreeFAFees += students.get(i).computeFees();
            }
            if ((students.get(i) instanceof DegreeSeekingStudent)
                    && !(students.get(i) instanceof DegreeSeekingStudentWFA)) {
                degreeFees += students.get(i).computeFees();
            }
            if (students.get(i) instanceof SeniorCitizen) {
                seniorFees += students.get(i).computeFees();
            }
            if (students.get(i) instanceof CertificateStudent) {
                certificateFees += students.get(i).computeFees();
            }
        }
        System.out.println("Summary of student fees assessed:" +
                           "\n\nDegree-seeking students without financial assistance: $" + degreeFees +
                           "\nDegree-seeking students with financial assistance: $" + degreeFAFees +
                           "\nCertificate students: $" + certificateFees +
                           "\nSenior citizens: $" + seniorFees + 
                           "\n\nTotal fees assessed: $" + (degreeFees+degreeFAFees+certificateFees+seniorFees));

    }

    public static void interactive() {
        // TODO
    }

    public static void batch(ArrayList<String> studentsData) {

        ArrayList<String> studentInfo;
        for (int i = 0; i < studentsData.size(); i++) {
            studentInfo = new ArrayList<>(Arrays.asList(studentsData.get(i).split(";")));
            addStudent(studentInfo);
        }

    }

    // This method should test for the data to be correct,
    // but we were told that the input file will hold only correct and legal data
    private static void addStudent(ArrayList<String> studentInfo) {

        HashMap<String, String> majors = new HashMap<String, String>();
        majors.put("S", "Gaming Science");
        majors.put("M", "Hotel Management");
        majors.put("A", "Lounge Arts");
        majors.put("E", "Beverage Engineering");

        HashMap<String, String> standings = new HashMap<String, String>();
        standings.put("G", "Good");
        standings.put("W", "Warning");
        standings.put("P", "Probation");

        try {
            // Degree seekers
            if (studentInfo.get(5).equals("Y")) {

                // With financial assistance
                if (studentInfo.get(8).equals("Y")) {
                    Student newStudent = new DegreeSeekingStudentWFA(studentInfo.get(0), studentInfo.get(1),
                            studentInfo.get(2), studentInfo.get(3), Integer.parseInt(studentInfo.get(4)),
                            majors.get(studentInfo.get(6)), standings.get(studentInfo.get(7)),
                            Integer.parseInt(studentInfo.get(9)));
                    students.add(newStudent);

                    // Without financial assistance
                } else if (studentInfo.get(8).equals("N")) {
                    Student newStudent = new DegreeSeekingStudent(studentInfo.get(0), studentInfo.get(1),
                            studentInfo.get(2), studentInfo.get(3), Integer.parseInt(studentInfo.get(4)),
                            majors.get(studentInfo.get(6)), standings.get(studentInfo.get(7)));
                    students.add(newStudent);
                } else {
                    throw new Exception("Unknown data @ financial assistance");
                }

                // Non-degree seekers
            } else if (studentInfo.get(5).equals("N")) {

                // Certificate student
                if (studentInfo.get(6).equals("C")) {
                    Student newStudent = new CertificateStudent(studentInfo.get(0), studentInfo.get(1),
                            studentInfo.get(2), studentInfo.get(3), Integer.parseInt(studentInfo.get(4)),
                            majors.get(studentInfo.get(7)));
                    students.add(newStudent);

                    // Senior citizen
                } else if (studentInfo.get(6).equals("S")) {
                    Student newStudent = new SeniorCitizen(studentInfo.get(0), studentInfo.get(1), studentInfo.get(2),
                            studentInfo.get(3), Integer.parseInt(studentInfo.get(4)));
                    students.add(newStudent);

                } else {
                    throw new Exception("Unknown data @ certificate/senior");
                }

            } else {
                throw new Exception("Unknown data @ non/degree-seeking");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

}
