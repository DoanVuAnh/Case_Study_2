
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static sun.security.pkcs11.wrapper.Functions.getId;

public class StudentManager implements Serializable {
    public static Scanner scanner = new Scanner(System.in);
    private List<Student> studentList;
    private StudentDao studentDao;

    public StudentManager() {
        studentList = new ArrayList<>();
        studentDao = new StudentDao();
        studentList = studentDao.read();
        resetStaticINDEX();

    }

    public void addStudent() {
//        int id = (studentList.size() > 0) ? (studentList.size() + 1) : 1;
        System.out.println("student id = " );
        String name = inputName();
        int age = inputAge();
        String address = inputAddress();
        float gpaMaths = inputGpaMaths();
        float gpaPhysics = inputGpaPhysics();
        float gpaChemistry = inputGpaChemistry();
//        float gpa = inputGpa();
        studentList.add(new Student(name, age, address,gpaMaths,gpaPhysics,gpaChemistry));
        studentDao.write(studentList);
    }

    public void editStudent(int id) {
        boolean isExisted = false;
        int size = studentList.size();
        for (int i = 0; i < size; i++) {
            if (studentList.get(i).getId() == id) {
                isExisted = true;
                studentList.get(i).setName(inputName());
                studentList.get(i).setAge(inputAge());
                studentList.get(i).setAddress(inputAddress());
                studentList.get(i).setGpaMaths(inputGpaMaths());
                studentList.get(i).setGpaPhysics(inputGpaPhysics());
                studentList.get(i).setGpaChemistry(inputGpaChemistry());
                studentList.get(i).setupGPA();
                studentList.get(i).setupRank();
                break;
            }
        }
        if (!isExisted) {
            System.out.printf("id = %d not existed.\n", id);
        } else {
            studentDao.write(studentList);
        }
    }

    public void deleteStudent(int id) {
        Student student = null;
        int size = studentList.size();
        for (int i = 0; i < size; i++) {
            if (studentList.get(i).getId() == id) {
                student = studentList.get(i);
                break;
            }
        }
        if (student != null) {
            studentList.remove(student);
            studentDao.write(studentList);
        } else {
            System.out.printf("id = %d not existed.\n", id);
        }
    }

    public void sortStudentByGPA(int choice) {
        if (choice == 1) {
            Collections.sort(studentList, new SortStudentGetSmallerByGPA());
            displayListStudent();
        }
        if (choice == 2){
            Collections.sort(studentList, new SortStudentGetBiggerByGPA());
            displayListStudent();
        }
        }


    public void sortStudentByName() {
        Collections.sort(studentList, new SortStudentByName());
    }

    public void displayByName(){
        System.out.println("Enter character you want search: ");
        String search = scanner.nextLine();

        int count = 0;
        for (Student s : studentList){
            if (s.getName().contains(search)){
                System.out.println("List student have name contains: ");
                System.out.println(s);
                count ++;
            }
        } if (count == 0){
            System.out.println("No student's name on the list");
        }
    }
    public void displayListStudent() {
        System.out.printf("%10s | ","ID");
        System.out.printf("%20s | ","Name");
        System.out.printf("%5s | ", "Age");
        System.out.printf("%20s | ", "Address");
        System.out.printf("%15s |", "Maths");
        System.out.printf("%15s |", "Physics");
        System.out.printf("%15s |", "Chemistry");
        System.out.printf("%15s |", "Gpa");
        System.out.printf("%10s%n", "Rank");



        for (Student student : studentList) {
            System.out.format("%10d | ", student.getId());
            System.out.format("%20s | ", student.getName());
            System.out.format("%5d | ", student.getAge());
            System.out.format("%20s | ", student.getAddress());
            System.out.format("%15f |", student.getGpaMaths());
            System.out.format("%15f |", student.getGpaPhysics());
            System.out.format("%15f |", student.getGpaChemistry());
            System.out.format("%15f |", student.getGpa());
            System.out.format("%10s%n", student.getRank());

        }
  }

    public int inputId() {
        System.out.print("Input student id: ");
        while (true) {
            try {
                int id = Integer.parseInt((scanner.nextLine()));
                return id;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input student id again: ");
            }
        }
    }

    private String inputName() {
        System.out.println("Input student name: ");
        return scanner.nextLine();
    }

    private int inputAge() {
        System.out.println("Input student Age: ");
        while (true) {
            try {
                int age = Integer.parseInt((scanner.nextLine()));
                if (age < 0 || age > 100) {
                    throw new NumberFormatException();
                }
                return age;
            } catch (NumberFormatException ex) {
                System.out.print("Invalid! Input student age again: ");
            }

        }
    }

    private String inputAddress() {
        System.out.println("Input student address: ");
        String add = scanner.nextLine();
        return add;
    }

    private float inputGpaMaths(){
        System.out.println("Input student gpa Maths: ");
        while (true) {
            try {
                float gpa = Float.parseFloat((scanner.nextLine()));
                if (gpa < 0.0 || gpa > 10.0) {
                    throw new NumberFormatException();
                }
                return gpa;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input student gpa again: ");
            }
        }
    }

    private float inputGpaPhysics(){
        System.out.println("Input student gpa Physics: ");
        while (true) {
            try {
                float gpa = Float.parseFloat((scanner.nextLine()));
                if (gpa < 0.0 || gpa > 10.0) {
                    throw new NumberFormatException();
                }
                return gpa;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input student gpa again: ");
            }
        }
    }

    private float inputGpaChemistry(){
        System.out.println("Input student gpa Chemistry: ");
        while (true) {
            try {
                float gpa = Float.parseFloat((scanner.nextLine()));
                if (gpa < 0.0 || gpa > 10.0) {
                    throw new NumberFormatException();
                }
                return gpa;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input student gpa again: ");
            }
        }
    }

    private void resetStaticINDEX(){
        if(!studentList.isEmpty()){
            Student.INDEX = Long.valueOf(studentList.get(studentList.size()-1).getId());
        }
    }

    private float inputGpa() {
        System.out.print("Input student gpa: ");
        while (true) {
            try {
                float gpa = Float.parseFloat((scanner.nextLine()));
                if (gpa < 0.0 || gpa > 10.0) {
                    throw new NumberFormatException();
                }
                return gpa;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input student gpa again: ");
            }
        }
    }
}
