package com.scarycoders.learn.design.pattern.interator.socialMediaIterator.socialMedia;

import com.scarycoders.learn.design.pattern.interator.socialMediaIterator.iterator.IteratorType;
import com.scarycoders.learn.design.pattern.interator.socialMediaIterator.iterator.FacebookIterator;
import com.scarycoders.learn.design.pattern.interator.socialMediaIterator.iterator.ProfileIterator;
import com.scarycoders.learn.design.pattern.interator.socialMediaIterator.model.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Facebook implements SocialNetwork{

    List<Profile> profiles;

    public Facebook(List<Profile> profiles){
        this.profiles = Objects.requireNonNullElseGet(profiles,ArrayList::new);
    }

    @Override
    public ProfileIterator createFriendsIterator(String email) {
        return new FacebookIterator(this, IteratorType.FRIENDS,email);
    }

    @Override
    public ProfileIterator createCoworkerIterator(String email) {
        return new FacebookIterator(this,IteratorType.COWORKERS,email);
    }

    @Override
    public Profile requestProfile(String profileEmail) {
        simulateNetworkLatencyForMs(200);
        System.out.println("Loading facebook profile for email: "+profileEmail+"....");
        return findProfile(profileEmail);
    }

    @Override
    public List<String> requestConnectionsOf(String profileEmail,IteratorType connectionType) {
        simulateNetworkLatencyForMs(200);
        System.out.println("Loading facebook profile connections for email: "+profileEmail+"....");
        return findProfile(profileEmail).getConnectionsMap().get(connectionType);
    }
    
    private Profile findProfile(String email){
        return profiles.stream().filter(x->x.getEmail().equals(email)).findFirst().orElseThrow();
    }
}
