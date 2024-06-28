package src;

import entity.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    private static String filePath = "src/data.txt";
    private static File myFile = new File(filePath);
    private static Scanner scanner = new Scanner(System.in);
    public StudentManager(){}

    public static void addStudent() throws IOException {
        FileWriter fileWriter = new FileWriter(myFile, true);
        BufferedWriter bufferedWriter  = new BufferedWriter(fileWriter);
        System.out.println("----------Enter student information------");
        System.out.println("Enter id: ");
        String id = scanner.nextLine();
        System.out.println("Enter name: ");
        String name = scanner.nextLine();

        Student s = new Student(Integer.parseInt(id), name);
        String dataStudent = s.getId() + "," + s.getName();
        // luu vao file
        bufferedWriter.write(dataStudent);
        bufferedWriter.newLine();
        // dong file lai va du data luu lai
        bufferedWriter.close();
    }

    public static void showListStudent() throws IOException {
        FileReader fileReader = new FileReader(myFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            // chuyen String ve array su dung split()
            String[] data = line.split(",");
            int idStudent = Integer.parseInt(data[0]);
            String nameStudent = data[1];
            Student s1 = new Student(idStudent, nameStudent);
            System.out.println(s1);
        }
        bufferedReader.close();
    }

    public static void deleteStudent() throws Exception {
        // code xoa student
        System.out.println("Enter id student delete: ");
        int idStudentDelete = Integer.parseInt(scanner.nextLine());
        System.out.println(idStudentDelete);
        // tao 1 list students du lieu doc tu file
        List<Student> students = new ArrayList<Student>();
        // read data from file
        FileReader fileReader = new FileReader(myFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            String[] text = line.split(",");
            int id = Integer.parseInt(text[0]);
            String name = text[1];
            Student student = new Student(id, name);
            students.add(student);
        }
        Student studentDelete = null;
        // delete student trong list students
        for (Student item: students) {
            if (item.getId() == idStudentDelete) {
                studentDelete = item;
                break;
            }
        }

        if (studentDelete == null) {
            throw new Exception("Student deleted not found");
        }

        students.remove(studentDelete);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(myFile));
        // write data to file after delete
        for (Student student: students) {
            String dataStudent = student.getId() + "," + student.getName();
            bufferedWriter.write(dataStudent);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}
