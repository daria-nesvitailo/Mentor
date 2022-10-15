package main.study.process;

import main.exceptions.StudentNotFoundException;

import java.util.List;
import java.util.Objects;

public class Group {

    private String groupName;
    private List<Student> students;

    public Group(String groupName) {
        super();
        this.groupName = groupName;
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
        Student foundStudent = null;
        for (Student student : this.students) {
            if (student != null && student.getLastName().equals(lastName)) {
                System.out.println("Student with last name " + lastName + " is found in group " + this.groupName + ": "
                        + student.toString());
                foundStudent = student;
            }
        }
        if (foundStudent == null) {
            throw new StudentNotFoundException(
                    "Student with last name " + lastName + " is not found in group " + this.groupName);
        }

        return foundStudent;
    }

    public boolean hasEqualStudent(Student student){
        for (Student studentInArr : this.students) {
            if (student.equals(studentInArr)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;
        Group group = (Group) o;
        return Objects.equals(getGroupName(), group.getGroupName()) &&
                Objects.equals(getStudents(), group.getStudents());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGroupName(), getStudents());
    }

}
