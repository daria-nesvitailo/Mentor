package main.study.process;

public class Student extends Human {

    private int id;
    private String groupName;

    public Student(Gender gender, String name, String lastName, int id, String groupName) {
        super(gender, name, lastName);
        this.id = id;
        this.groupName = groupName;
    }

    public Student() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return super.toString() + ", id = " + id + ", groupName = " + groupName;
    }

}

