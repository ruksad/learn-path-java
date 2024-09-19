package com.scarycoders.learn.design.pattern.interator.socialMediaIterator.socialMedia;

import com.scarycoders.learn.design.pattern.interator.socialMediaIterator.iterator.IteratorType;
import com.scarycoders.learn.design.pattern.interator.socialMediaIterator.iterator.LinkedInIterator;
import com.scarycoders.learn.design.pattern.interator.socialMediaIterator.iterator.ProfileIterator;
import com.scarycoders.learn.design.pattern.interator.socialMediaIterator.model.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LinkedIn implements SocialNetwork{
    List<Profile> profiles;

    public LinkedIn(List<Profile> profiles){
        this.profiles = Objects.requireNonNullElseGet(profiles, ArrayList::new);
    }

    @Override
    public ProfileIterator createFriendsIterator(String email) {
        return new LinkedInIterator(this, IteratorType.FRIENDS,email);
    }

    @Override
    public ProfileIterator createCoworkerIterator(String email) {
        return new LinkedInIterator(this, IteratorType.COWORKERS,email);
    }

    @Override
    public Profile requestProfile(String profileEmail) {
        simulateNetworkLatencyForMs(200);
        System.out.println("Loading LinkedIn profile for email: "+profileEmail+"....");
        return findProfile(profileEmail);
    }

    @Override
    public List<String> requestConnectionsOf(String profileEmail, IteratorType connectionType) {
        simulateNetworkLatencyForMs(200);
        System.out.println("Loading LinkedIn profile connections for email: "+profileEmail+"....");
        return findProfile(profileEmail).getConnectionsMap().get(connectionType);
    }

    private Profile findProfile(String email){
        return profiles.stream().filter(x->x.getEmail().equals(email)).findFirst().orElseThrow();
    }
}
