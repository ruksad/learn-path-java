package com.scarycoders.learn.logical.classes;

import java.util.Date;

public class ImmutableUserWithBuilder {
  private final String firstName;
  private final String lastName;
  private final String userName;
  private final String passWord;
  private final Date dateOfBirth;

  @Override
  public String toString() {
    return "ImmutableUserWithBuilder{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", userName='" + userName + '\'' +
        ", passWord='" + passWord + '\'' +
        ", dateOfBirth=" + dateOfBirth +
        '}';
  }

  private ImmutableUserWithBuilder(UserBuilder userBuilder) {
    this.firstName = userBuilder.firstName;
    this.lastName = userBuilder.lastName;
    this.userName = userBuilder.userName;
    this.passWord = userBuilder.passWord;
    this.dateOfBirth = userBuilder.dateOfBirth;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getUserName() {
    return userName;
  }

  public String getPassWord() {
    return passWord;
  }

  public Date getDateOfBirth() {
    return new Date(dateOfBirth.getTime());
  }

  public static class UserBuilder{
    private String firstName;
    private String lastName;
    private String userName;
    private String passWord;
    private Date dateOfBirth;
    public UserBuilder(String firstName,String lastName){
      this.firstName=firstName;
      this.lastName=lastName;
    }

    public UserBuilder userName(String firstName){
      this.userName=firstName;
      return this;
    }

    public UserBuilder passWord(String passWord){
      this.passWord=passWord;
      return this;
    }

    public UserBuilder dateOfBirth(Date date){
      this.dateOfBirth=new Date(date.getTime());
      return this;
    }

    public ImmutableUserWithBuilder buid(){
      return new ImmutableUserWithBuilder(this);
    }
  }
}

