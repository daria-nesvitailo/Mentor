package main.study.process;

public class Human {
    private Gender gender;
    private String lastName;
    private String name;

    public Human(Gender gender, String name, String lastName) {
        super();
        this.gender = gender;
        this.name = name;
        this.lastName = lastName;
    }

    public Human() {
        super();

    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "gender = " + gender + ", name= " + name + ", lastName = " + lastName;
    }


}
