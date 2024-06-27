import entity.Student;
import src.StudentManager;

import java.io.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("----Enter choice number----");
                System.out.println("1: Add student");
                System.out.println("2: Show list students");
                System.out.println("3: Delete students");
                System.out.println("4: Update students");
                System.out.println("5: Exit");
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 5) {
                    break;
                }
                switch (choice) {
                    case 1:
                        StudentManager.addStudent();
                        break;
                    case 2:
                        StudentManager.showListStudent();
                        break;
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
