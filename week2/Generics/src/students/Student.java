package students;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student {

    private String name;
    private int grade;
    
    Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getGrade() {
        return grade;
    }
    
    public void setGrade(int grade) {
        this.grade = grade;
    }
    
    @Override
    public String toString() {
        return "(" + name.toString() + ", " + grade + ")";
    }
    
    public static void sortStudents(List<Student> list) {
        Collections.sort(list, new Comparator<Object>() {

            @Override
            public int compare(Object o1, Object o2) {
                Student st1 = (Student) o1;
                Student st2 = (Student) o2;
                int compareGrades = st1.getGrade() - st2.getGrade();
                //System.out.println(compareStrings);
                if (compareGrades == 0) {
                    return st1.getName().compareTo(st2.getName());
                }
                
                return compareGrades;
            }

        });
    }
    
    public static void main(String[] args) {
        List<Student> list = new ArrayList<Student>();
        list.add(new Student("Angel", 4));
        list.add(new Student("Pesho", 2));
        list.add(new Student("Angel", 2));
        list.add(new Student("Toshko", 5));
        list.add(new Student("Titko", 3));
        
        sortStudents(list);
        
        for (Student student : list) {
            System.out.println(student);
        }
        
    }
    
}
