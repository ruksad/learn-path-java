package com.scarycoders.learn.language.functionalInterface;

import java.util.Objects;

public class Student {
    private int id;
    private String name;
    private String specialization;
    private double percentage;

    public Student(int id, String name, double percentage, String specialization)
    {
        this.id = id;

        this.name = name;

        this.percentage = percentage;

        this.specialization = specialization;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Student student = (Student) o;
        return id == student.id && Double.compare(student.percentage, percentage) == 0 && Objects
                .equals(name, student.name) && Objects.equals(specialization, student.specialization);
    }

    @Override public int hashCode() {
        return Objects.hash(id, name, specialization, percentage);
    }

    @Override public String toString() {
        return "Student{" + "id=" + id + ", name='" + name + '\'' + ", specialization='" + specialization + '\''
                + ", percentage=" + percentage + '}';
    }
}
