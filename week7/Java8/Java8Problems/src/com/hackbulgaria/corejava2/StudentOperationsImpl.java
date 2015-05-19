package com.hackbulgaria.corejava2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.hackbulgaria.corejava2.data.Gender;
import com.hackbulgaria.corejava2.data.Student;

public class StudentOperationsImpl implements StudentOperations {

    private List<Student> students;

    public StudentOperationsImpl(List<Student> students) {
        this.students = students;
    }

    @Override
    public double getAverageMark() {
        return students.stream().map(Student::getGrade).reduce((a, b) -> a + b).get() / students.size();
    }

    @Override
    public List<Student> getAllPassing() {
        return students.stream().filter(s -> s.getGrade() > 3.0f).collect(Collectors.toList());
    }

    @Override
    public List<Student> getAllFailing() {
        return students.stream().filter(s -> s.getGrade() < 3.0f).collect(Collectors.toList());
    }

    @Override
    public Map<Boolean, List<Student>> splitStudentsByMarks(float splitMark) {
        // TODO
        Map<String, Double> map = students.stream().collect(Collectors.toMap(p -> p.getName(), p -> p.getGrade()));
        System.out.println(map);
        return null;
    }

    @Override
    public List<Student> orderByMarkDescending() {
        return students.stream().sorted(Comparator.comparing(Student::getGrade).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> orderByMarkAscending() {
        return students.stream().sorted(Comparator.comparing(Student::getGrade)).collect(Collectors.toList());
    }

    @Override
    public List<Student> getStudentsWithLowestMarks() {
        double min = students.stream().min(Comparator.comparing(Student::getGrade)).get().getGrade();
        return students.stream().filter(s -> s.getGrade() == min).collect(Collectors.toList());
    }

    @Override
    public List<Student> getStudentsWithHighestMarks() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<Integer, List<Double>> getMarksDistributionByAge() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<Gender, Double> getAverageMarkByGender() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<Double, Integer> getMarksDistribution() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getEmailToHeader() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<Gender, Map<Integer, List<Student>>> splitStudentMarksByGenderAndThenByAge() {
        // TODO Auto-generated method stub
        return null;
    }

}
