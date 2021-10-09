package com.scarycoders.learn.logical.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class StudentPriority {

  private Queue q=new PriorityQueue<>();
  //Comparator<Student> cmp=Comparator.comparing(Student::getCGPA)
  private static Comparator<Student> cmp=Comparator.comparingDouble(Student::getCGPA)
      .thenComparing(Student::getName).thenComparingInt(Student::getID);
  private static Comparator<Student> cmp1=new Comparator<Student>() {
    @Override
    public int compare(Student o1, Student o2) {
      if (o1.getCGPA() == o2.getCGPA()) {
        if(o1.getName().equals(o2.getName())) {
          return Integer.compare(o2.getID(), o1.getID());
        } else {
          return o1.getName().compareTo(o2.getName());
        }
      }
      return Double.compare(o2.getCGPA(), o1.getCGPA());
    }
  };

      public static List<Student> priorities(List<String> event){
        Queue<Student> q=new PriorityQueue(event.size(),cmp);

        for(String s:event){
          String[] split = s.split(" ");
          if(split[0].equals("ENTER")){
            Student student = new Student(split[1],Double.parseDouble(split[2]),Integer.parseInt(split[3]));
            q.add(student);
          }else{
            if(!q.isEmpty())
            q.poll();
          }
        }
        ArrayList<Student> students = new ArrayList<>();
        while(!q.isEmpty()){
          students.add(q.poll());
        }
        return students;
      }

  public static void main(String[] args) {
    String[] string={
        "ENTER John 3.75 50",
        "ENTER Mark 3.8 24",
        "ENTER Shafaet 3.7 35",
        "SERVED",
        "SERVED",
        "ENTER Samiha 3.85 36",
        "SERVED",
        "ENTER Ashley 3.9 42",
        "ENTER Maria 3.6 46",
        "ENTER Anik 3.95 49",
        "ENTER Dan 3.95 50",
        "SERVED"};
    List<Student> priorities = priorities(Arrays.asList(string));
    System.out.println(priorities);
  }
}



class Student{
  private Integer id;
  private String name;
  private Double cgpa;
  public Student(String name,Double cgpa,Integer id){
    this.id=id;
    this.name=name;
    this.cgpa=cgpa;
  }
  public int getID() {
    return id;
  }

  public String getName() {
    return name;
  }

  public double getCGPA() {
    return cgpa;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("Student{");
    sb.append("id=").append(id);
    sb.append(", name='").append(name).append('\'');
    sb.append(", cgpa=").append(cgpa);
    sb.append('}');
    return sb.toString();
  }
}