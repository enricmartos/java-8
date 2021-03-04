package com.learnJava.streams;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.function.Predicate;

public class StreamsFilterMapReduceExample {

    static Predicate<Student> gradeLevel = (student -> student.getGradeLevel() == 2.0);

    private static int noOfNoteBooks(){

        return StudentDataBase.getAllStudents().stream()
                .filter(gradeLevel)
                .map((Student::getNoteBooks))
                .reduce(0,Integer::sum);
    }

    public static void main(String[] args) {
        System.out.println("Total No of NoteBooks are : " + noOfNoteBooks());
    }
}
