package student;

import java.util.Scanner;

public class StudentMenu {
    public static Scanner scanner = new Scanner(System.in);
    StudentManager studentManager = new StudentManager();

//    public void menuOutsite(){
//        String choose = null;
//        boolean exit = false;
//        LogIn logIn = new LogIn();
//
//        do{
//            System.out.println("1. Đăng ký");
//            System.out.println("2. Đăng nhập");
//            System.out.println("3. Đăng nhập tài khoản AD");
//            System.out.println("Nhập sự lựa chọn");
//
//            choose = scanner.nextLine();
//            switch (choose) {
//                case "1":
//
//                    break;
//                case "2":
//
//                    break;
//                case  "3":
//                    logIn.logInAcc();
//                    break;
//        }  if (exit) {
//                break;
//            }
//    } while (choose != null);
//    }

    public void menuAdmin() {
        String choose = null;
        boolean exit = false;

        int studentId;
        do {
            System.out.println("┌-----------MENU--------------┐");
            System.out.println("│▶ 1. Add student.            │");
            System.out.println("│▶ 2. Edit student by id.     │");
            System.out.println("│▶ 3. Delete student by id.   │");
            System.out.println("│▶ 4. Sort student by gpa.    │");
            System.out.println("│▶ 5. Sort student by name.   │");
            System.out.println("│▶ 6. Display student by name.│");
            System.out.println("│▶ 7. Display student.        │");
            System.out.println("│▶ 0. Exit.                   │");
            System.out.println("└-----------------------------┘");
            System.out.print("Please choose:");



            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    studentManager.addStudent();
                    break;
                case "2":
                    studentId = studentManager.inputId();
                    studentManager.editStudent(studentId);
                    break;
                case "3":
                    studentId = studentManager.inputId();
                    studentManager.deleteStudent(studentId);
                    break;
                case "4":
                    menuGPA();
                    break;

                case "5":
                    studentManager.sortStudentByName();
                    studentManager.displayListStudent();
                    break;
                case "6":
                    studentManager.displayByName();
                    break;
                case "7":
                    studentManager.displayListStudent();
                    break;
                case "0":
                    System.out.println("Exited!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid! Please choose action in below menu:");
            }
            if (exit) {
                break;
            }

        } while (choose != null);
    }

    public void menuAccount(){
        String choose = null;
        boolean exit = false;

//        int studentId;
        do {
            System.out.println("┌-----------MENU--------------┐");
            System.out.println("│▶ 1. Sort student by gpa.    │");
            System.out.println("│▶ 2. Sort student by name.   │");
            System.out.println("│▶ 3. Display student by name.│");
            System.out.println("│▶ 4. Display student.        │");
            System.out.println("│▶ 0. Exit.                   │");
            System.out.println("└-----------------------------┘");
            System.out.print("Please choose: ");


            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    menuGPA();
                    break;

                case "2":
                    studentManager.sortStudentByName();
                    studentManager.displayListStudent();
                    break;
                case "3":
                    studentManager.displayByName();
                    break;
                case "4":
                    studentManager.displayListStudent();
                    break;
                case "0":
                    System.out.println("Exited!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid! Please choose action in below menu:");
            }
            if (exit) {
                break;
            }

        } while (choose != null);
    }

    public void menuGPA() {
        do {
            System.out.println("┌--------------MENU--------------------┐");
            System.out.println("│▶ 1. Grade point average is decreasing│");
            System.out.println("│▶ 2. Grade point average increasing   │");
            System.out.println("│▶ 0. Exit                             │");
            System.out.println("└--------------------------------------┘");
            System.out.print("Please choose: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 0) {
                break;
            }
            studentManager.sortStudentByGPA(choice);
        }
            while (true) ;
    }
}