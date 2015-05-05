package test;

public class User {

    private String name;
    private int age;
    
    public User() {
        this("", 0);
    }
    
    public User(String name, int age) {
        setName(name);
        setAge(age);
    }
    
    public void growOneYear() {
        this.age += 1;
    }
    
    public void growTenYears() {
        this.age += 10;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
}
