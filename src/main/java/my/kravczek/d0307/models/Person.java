package my.kravczek.d0307.models;

import javax.validation.constraints.*;

public class Person {
    private int id;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 8, message = "lenght word should be min=2 and max=4")
    private String name;
    @Min(value = 1, message = "lenght word min=1")
    @Max(value = 30, message = "Field 'age'  more 6")
    private int age;
//    @NotEmpty(message = "Email should not be empty")
//    @Email(message = "Email should be valid")
    private String email;

    public Person() {
    }

    public Person(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
