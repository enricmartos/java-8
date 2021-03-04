package com.learnJava.optional;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.Optional;

public class OptionalExample {

    public static String getStudentNameNull() {
        // Student student = StudentDataBase.studentSupplier.get();
        Student student = null;
        if (student != null) {
            return student.getName();
        } else {
            return null;
        }
    }

    public static Optional<String> getStudentNameOptionalWithMap() {
        Optional<Student> student = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        //Optional<Student> student = Optional.ofNullable(null); // Optional<Student> student Optional.empty()

        return student.map(Student::getName); // don't get confused this with streams map method. Both are different.
    }

    public static Optional<String> getStudentNameOptional() {
        Optional<Student> student = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        //Optional<Student> student = Optional.ofNullable(null);

        if (student.isPresent()) {
            return student.map(Student::getName); // don't get confused this with streams map method. Both are different.
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        // WITH NULL
        String name = getStudentNameNull();
        if (name != null)
            System.out.println("Length of the student name : " + name.length());
        else
            System.out.println("Name is returned as null.");

        // WITH OPTIONAL
        if (getStudentNameOptional().isPresent()) {
            System.out.println(getStudentNameOptional().get());
        } else {
            System.out.println("Name is returned as empty.");
        }


    }
}
