package com.scarycoders.learn.language.functionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class DriverClass {

    public static void main(String[] args) {
        final ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(111, "John", 81.0, "Mathematics"));
        students.add(new Student(222, "Harsha", 79.5, "History"));
        students.add(new Student(333, "Ruth", 87.2, "Computers"));
        students.add(new Student(444, "Aroma", 63.2, "Mathematics"));
        students.add(new Student(555, "Zade", 83.5, "Computers"));
        students.add(new Student(666, "Xing", 58.5, "Geography"));
        students.add(new Student(777, "Richards", 72.6, "Banking"));
        students.add(new Student(888, "Sunil", 86.7, "History"));
        students.add(new Student(999, "Jordan", 58.6, "Finance"));
        students.add(new Student(101010, "Chris", 89.8, "Computers"));
        BiPredicate<Student,Student> studentPredicate= (s1,s2)->Objects.equals(s1,s2);
        Consumer<Student> consumer=(s1)-> System.out.println(s1.toString());
        Supplier<Integer> supplier=()-> students.size();
        Function<List<Student>, Double> function=(a)->a.stream().mapToDouble(Student::getPercentage).average().getAsDouble();

        System.out.println("Bi predicate result object comparison  = "+studentPredicate.test(students.get(0),students.get(1)));
        System.out.println("Consumer result as object to string = ");
        consumer.accept(students.get(3));
        System.out.println("Supplier result as list size = "+supplier.get());
        System.out.println("Function result as average = "+ function.apply(students));
    }
}
