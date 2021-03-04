package com.learnJava.streams;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsExample {

    public static void main(String[] args) {
        Predicate<Student> gpaPredicate = student -> student.getGradeLevel()>=3.9;

        Map<String, List<String>> studentMap = StudentDataBase.getAllStudents().stream(). //.parallelStream
                filter(gpaPredicate) // Stream<Student>
                .collect(Collectors.toMap(Student::getName, Student::getActivities));

        System.out.println("studentMap  : " + studentMap);

        //collects it to a list.
        List<String> namesList = StudentDataBase.getAllStudents().
                stream() // Stream<Student>
                .peek((System.out::println))
                .map(Student::getName) //<Stream<List<Activites>>
                .peek(System.out::println)
                .distinct() // removes duplicates
                .collect(Collectors.toList()); //collects it to a list.

        System.out.println("namesList  : " + namesList);
    }
}
