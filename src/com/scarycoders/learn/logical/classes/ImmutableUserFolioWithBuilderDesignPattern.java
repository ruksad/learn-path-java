package com.scarycoders.learn.logical.classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public final class ImmutableUserFolioWithBuilderDesignPattern {

  private final String jobName;
  private final String designation;
  private final Date joiningDate;
  private final List<User> user;

  private ImmutableUserFolioWithBuilderDesignPattern(ImmutableUserBuilder immutableUserBuilder) {
    this.jobName = immutableUserBuilder.jobName;
    this.designation = immutableUserBuilder.designation;
    this.joiningDate = immutableUserBuilder.joiningDate;
    this.user = immutableUserBuilder.user;
  }

  public String getJobName() {
    return jobName;
  }

  public Date getJoiningDate() {
    return new Date(this.joiningDate.getTime());
  }

  public List<User> getUser() {
    ArrayList<User> users = new ArrayList<>();
    this.user.forEach(x->{
      users.add((User) x.clone());
    });
    return users;
  }

  public String getDesignation() {
    return designation;
  }

  @Override
  public String toString() {
    return "ImmutableUserFolioWithBuilderDesignPattern{" +
        "jobName='" + jobName + '\'' +
        ", designation='" + designation + '\'' +
        ", joiningDate=" + joiningDate +
        ", user=" + user +
        '}';
  }

  public static class ImmutableUserBuilder {

    private String jobName;
    private String designation;
    private Date joiningDate;
    private List<User> user;

    public ImmutableUserBuilder(String jobName) {
      this.jobName = jobName;
    }

    public ImmutableUserBuilder joiningDate(Date date) {
      this.joiningDate = new Date(date.getTime());
      return this;
    }

    public ImmutableUserBuilder designation(String designation) {
      this.designation = designation;
      return this;
    }

    public ImmutableUserBuilder user(List<User> user) {
      this.user=user.stream().map(x->(User)x.clone()).collect(Collectors.toList());
      return this;
    }

    public ImmutableUserFolioWithBuilderDesignPattern build() {
      return new ImmutableUserFolioWithBuilderDesignPattern(this);
    }
  }

  public static void main(String[] args) {
    ArrayList<Qualification> qualifications = new ArrayList<>();
    qualifications.add(new Qualification("BE","B", new Date()));
    qualifications.add(new Qualification("BTech","A", new Date()));
    User use=new User("Ruksad","Siddiqui", java.sql.Date.valueOf(LocalDate.now().minusYears(1)),qualifications);
    ArrayList<User> users = new ArrayList<>();
    users.add(use);
    ImmutableUserFolioWithBuilderDesignPattern software_engineer = new ImmutableUserBuilder(
        "Software Engineer").designation("software engineer-2").joiningDate(new Date()).user(users)
        .build();
    System.out.println("orignal="+ software_engineer);
    qualifications.add(new Qualification("MCA","A+",new Date()));
    System.out.println("Updated="+ software_engineer);
  }
}

class User implements Cloneable {

  private String firstName;
  private String lastName;
  private Date birthDate;
  private List<Qualification> qualifications;

  public User(String firstName, String lastName, Date birthDate,
      List<Qualification> qualifications) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDate = birthDate;
    this.qualifications = this.deepCloneList(qualifications);
  }

  private List<Qualification> deepCloneList(List<Qualification> qualifications){
    ArrayList<Qualification> qualifications1 = new ArrayList<>();
    qualifications.forEach(x->{
      qualifications1.add((Qualification) x.clone());
    });
    return qualifications1;
  }


  public boolean equals(Object o) {
    if (o instanceof User && this.firstName == ((User) o).firstName) {
      return true;
    }
    return false;
  }

  public int hashCode() {
    return this.firstName.length() + this.lastName.length() + this.birthDate.getDate();
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public Date getBirthDate() {
    return new Date(this.birthDate.getTime());
  }

  public List<Qualification> getQualifications() {

    return this.deepCloneList(this.qualifications);
  }

  public Object clone() {
    User user = null;
    user = new User(this.firstName,this.lastName,this.getBirthDate(),this.getQualifications());
//    try {
//      user = (User) super.clone();
//    } catch (CloneNotSupportedException e) {
//
//    }
    return user;
  }

  @Override
  public String toString() {
    return "User{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", birthDate=" + birthDate +
        ", qualifications=" + qualifications +
        '}';
  }
}

class Qualification implements Cloneable {

  private String degree;
  private String grade;
  private Date passOutDate;

  public Qualification(String degree,String grade,Date passOutDate){
    this.degree=degree;
    this.passOutDate=new Date(passOutDate.getTime());
    this.grade=grade;
  }

  public Object clone() {
    Qualification qualification = null;
    qualification=new Qualification(this.getDegree(),this.getGrade(),this.getPassOutDate());
    /*try {
      qualification = (Qualification) super.clone();
    } catch (CloneNotSupportedException e) {

    }*/
    return qualification;
  }

  public String getDegree() {
    return degree;
  }

  public String getGrade() {
    return grade;
  }

  public Date getPassOutDate() {
    return new Date(this.passOutDate.getTime());
  }

  @Override
  public String toString() {
    return "Qualification{" +
        "degree='" + degree + '\'' +
        ", grade='" + grade + '\'' +
        ", passOutDate=" + passOutDate +
        '}';
  }
}

