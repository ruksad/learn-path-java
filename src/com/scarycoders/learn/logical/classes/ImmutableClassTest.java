package com.scarycoders.learn.logical.classes;


import com.scarycoders.learn.logical.classes.ImmutableUserWithBuilder.UserBuilder;
import java.util.Date;

public class ImmutableClassTest {

  public static void main(String[] args) {
    UserBuilder userBuilder = new UserBuilder("Ruksad", "Siddiqui").dateOfBirth(new Date());
    ImmutableUserWithBuilder buid = userBuilder.buid();
    System.out.println(buid);

  }
}
