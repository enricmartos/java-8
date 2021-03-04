package com.learnJava.optional;

import com.learnJava.data.Bike;
import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.Optional;

public class OptionalMapFlatMapExample {

        public static void optionalFilter() {
        Optional<Student> studentOptional = StudentDataBase.getOptionalStudent()
                .filter(student -> student.getGpa()>=4.3);

        studentOptional.ifPresent(System.out::println);
    }

    public static void optionalMap() {
        Optional<Student> studentOptional =  StudentDataBase.getOptionalStudent();

        if(studentOptional.isPresent()){
            Optional<String> nameOptional= studentOptional.
                    map(Student::getName);
            System.out.println("nameOptional : " + nameOptional);
        }
    }

    public static void optionalFlatMap() {
      Optional<Student> studentOptional =  StudentDataBase.getOptionalStudent();
      if(studentOptional.isPresent()){
          Optional<Bike> bikeOptional= studentOptional. // Optional<Student <Optional<Bike>>
                  flatMap(Student::getBike); // Optional<Bike>
          System.out.println("bikeOptional : " + bikeOptional);
      }
    }


    public static void main(String[] args) {
        optionalFilter();
        optionalMap();
        optionalFlatMap();
    }
}
