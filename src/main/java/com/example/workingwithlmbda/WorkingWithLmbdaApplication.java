package com.example.workingwithlmbda;

import com.example.workingwithlmbda.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class WorkingWithLmbdaApplication {

    public static void main(String[] args) {
        Student student1 = new Student("S1","A1" , 19,8.3);
        Student student2 = new Student("S2","A2" , 19,18.3);
        Student student3 = new Student("S3","A3" , 21,20);

        //add to list
        List<Student> students = new ArrayList<Student>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

        System.out.println("sort : ");
        students.sort((s1,s2)-> (int) (s1.getGrade() - s2.getGrade()));
        for (Student student : students) {
            System.out.println(student.getFirstName());
        }

        System.out.println("reversed sort : ");
        Comparator<Student> comparator = Comparator.comparing(Student::getGrade);
        comparator = comparator.reversed();
        students.sort(comparator);
        for (Student student : students) {
            System.out.println(student.getFirstName());
        }

        //partitioning By grade more than 10
        System.out.println("partitioning By grade more than 10 : ");
        Map<Boolean , List<Student>> greaterThan10 = students.stream().collect(Collectors.partitioningBy(s->s.getGrade()>10));
        System.out.println(greaterThan10);

        //group by age
        System.out.println("group by age : ");
        Map<Integer , List<Student>> groupByAge = students.stream().collect(Collectors.groupingBy(Student::getAge));
        System.out.println(groupByAge);

        //average of grades
        System.out.println("average of grades: ");
        double averageGrade = students.stream().mapToDouble(Student::getGrade).average().getAsDouble();
        System.out.println(averageGrade);

        //average of grades with filter
        System.out.println("average of grades with filter :");
        double averageGrade2 = students.stream().filter(s->s.getGrade()>18).mapToDouble(Student::getGrade).average().getAsDouble();
        System.out.println(averageGrade2);

    }

}
