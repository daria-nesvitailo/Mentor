package main.study.process;

import main.exceptions.GroupOverflowException;
import main.exceptions.StudentNotFoundException;

import java.util.Arrays;
import java.util.Comparator;

public class Group {

    private String groupName;
    private Student[] students = new Student[10];

    public Group(String groupName, Student[] studens) {
        super();
        this.groupName = groupName;
        this.students = students;

    }

    public Group() {
        super();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Student[] getStudens() {
        return students;
    }

    public void setStudens(Student[] studens) {
        this.students = studens;
    }

    public void addStudent(Student student) throws GroupOverflowException {
        for (int i = 0; i < this.students.length; i++) {

            if (this.students[i] != null && i == this.students.length - 1) {
                throw new GroupOverflowException("Student " + student.getName() + " " + student.getLastName()
                        + " can't be added to the group " + this.groupName + ". Group is full!");
            } else if (this.students[i] == null) {
                student.setGroupName(this.groupName);
                this.students[i] = student;
                System.out.println("Group: " + this.groupName + " | ID: " + student.getId() + " | Student " + student.getName() + " " + student.getLastName());
                break;
            }
        }
    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
        Student foundStudent = null;
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i] != null && this.students[i].getLastName().equals(lastName)) {
                System.out.println("Student with last name " + lastName + " is found in group " + this.groupName + ": "
                        + this.students[i].toString());
                foundStudent = this.students[i];
            }
        }
        if (foundStudent == null) {
            throw new StudentNotFoundException(
                    "Student with last name " + lastName + " is not found in group " + this.groupName);
        }
        return foundStudent;

    }

    public boolean removeStudentByID(int id) {
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i] != null && this.students[i].getId() == id) {
                System.out.println("Student " + this.students[i].getName() + " " + this.students[i].getLastName() +  " with student card id " + id + " is removed from group " + this.groupName);
                this.students[i] = null;
                return true;
            }
        }

        return false;

    }

    public void SortStudentsByLastName() {
        Arrays.sort(students, Comparator.nullsFirst(new SortStudentsByLastName()));
        for (int i = 0; i < students.length; i++) {
            System.out.println();
        }

    }
}
