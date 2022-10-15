package main;

import main.exceptions.GroupOverflowException;
import main.exceptions.StudentNotFoundException;
import main.study.process.Gender;
import main.study.process.Group;
import main.study.process.SortStudentsByLastName;
import main.study.process.Student;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Group group1 = new Group("GroupA");
        Group groupNew = new Group();

        Student student1 = new Student(Gender.Male, "Sergey", "Bahchidgi", 111, group1.getGroupName());
        Student student2 = new Student(Gender.Female, "Anastasiya", "Sayapina", 112, group1.getGroupName());
        Student student3 = new Student(Gender.Male, "Anton", "Sykorskiy", 113, group1.getGroupName());
        Student student4 = new Student(Gender.Female, "Anna", "Botnar", 114, group1.getGroupName());
        Student student5 = new Student(Gender.Female, "Ludmila", "Lisova", 115, group1.getGroupName());
        Student student6 = new Student(Gender.Male, "Volodymyr", "Bojchenko", 116, group1.getGroupName());
        Student student7 = new Student(Gender.Female, "Miroslava", "Lubota", 117, group1.getGroupName());
        Student student8 = new Student(Gender.Male, "Andriy", "Bashtov", 118, group1.getGroupName());
        Student student9 = new Student(Gender.Female, "Elena", "Yasnova", 119, group1.getGroupName());
        Student student10 = new Student(Gender.Male, "Mikhail", "Krasnov", 120, group1.getGroupName());

        populateStudents(group1, student1, student2, student3, student4, student5, student6, student7, student8, student9, student10);
//

        int indexOf = group1.getStudents().indexOf(student8);
        group1.getStudents().remove(indexOf);
        group1.getStudents().remove(student7);


        // todo
//        final List<Student> studentList = Arrays.asList(group1.getStudens());
//        studentList.get(0);
//        studentList.add(new Student());

        System.out.println("---------------------");

        Scanner sc1 = addNewStudent(group1, groupNew);

        System.out.println("---------------------");

        System.out.println("Enter group name to search student: ");
        String groupToSearch = sc1.nextLine();

        if (groupToSearch.equalsIgnoreCase(group1.getGroupName())) {
            searchStudent(group1, sc1);

            System.out.println("---------------------");

//            removeStudent(group1, sc1);
        } else if (groupToSearch.equalsIgnoreCase(groupNew.getGroupName())) {
            searchStudent(groupNew, sc1);

            System.out.println("---------------------");

//            removeStudent(groupNew, sc1);
        } else {
            System.out.println("Group doesn't exist");
        }

        System.out.println("---------------------");

        sortStudent(student1, student2, student3, student4, student5, student6, student7, student8, student9);
    }

    private static void sortStudent(Student student1, Student student2, Student student3, Student student4, Student student5,
                                    Student student6, Student student7, Student student8, Student student9) {
        Student[] students = new Student[]{student1, student2, student3, student4, student5, student6, student7, student8, student9};
        Arrays.sort(students, Comparator.nullsFirst(new SortStudentsByLastName()));
        System.out.println("Sorted students: ");
        System.out.println(" ");

        for (Student student : students) {
            System.out.println(student.getLastName());
        }

        List<Student> studentList = Arrays.asList(students);
    }

    private static void searchStudent(Group group, Scanner sc1) {
        System.out.println("Enter surname to search student: ");
        String surname = sc1.nextLine();
        try {
            group.searchStudentByLastName(surname);
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Scanner addNewStudent(Group group1, Group newGroup) {
        Student student11 = new Student();
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Input student Name: ");
        student11.setName(sc.nextLine());
        System.out.println("Input student Surname: ");
        student11.setLastName(sc.nextLine());
        System.out.println("Input student Id: ");
        student11.setId(sc.nextInt());

        System.out.println("Input student gender: ");
        System.out.println("1 - Male, 2 - Female");

        int gender = sc.nextInt();
        if (gender == 1) {
            student11.setGender(Gender.Male);
        } else if (gender == 2) {
            student11.setGender(Gender.Female);
        } else {
            System.out.println("Error");
        }
        System.out.println("Enter groupname");
        String groupName = sc1.nextLine();
        if (group1.getGroupName().equalsIgnoreCase(groupName)) {
            group1.getStudents().add(student11);
            student11.setGroupName(group1.getGroupName());
        } else {
            newGroup.setGroupName(groupName);
            //                newGroup.addStudent(student11);
            student11.setGroupName(groupName);
        }


        return sc1;
    }

    private static void populateStudents(Group group1, Student student1, Student student2, Student student3, Student student4, Student student5, Student student6, Student student7, Student student8, Student student9, Student student10) {
        //            group1.addStudent(student1);
//            group1.addStudent(student2);
//            group1.addStudent(student3);
//            group1.addStudent(student4);
//            group1.addStudent(student5);
//            group1.addStudent(student6);
//            group1.addStudent(student7);
//            group1.addStudent(student8);
//            group1.addStudent(student9);
//            group1.addStudent(student10);

        boolean b = group1.hasEqualStudent(student10);
        System.out.println(b);
    }
}
