package main.study.process;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return getGender() == human.getGender() &&
                Objects.equals(getLastName(), human.getLastName()) &&
                Objects.equals(getName(), human.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGender(), getLastName(), getName());
    }

}
