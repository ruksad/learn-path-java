package com.scarycoders.learn.design.pattern.interator.socialMediaIterator.iterator;

import com.scarycoders.learn.design.pattern.interator.socialMediaIterator.model.Profile;
import com.scarycoders.learn.design.pattern.interator.socialMediaIterator.socialMedia.SocialNetwork;

import java.util.ArrayList;
import java.util.List;

public class LinkedInIterator implements ProfileIterator{

    private SocialNetwork linkedIn;
    private IteratorType type;
    private String email;
    private int currentPosition=0;

    private List<String> emails= new ArrayList<>();

    private List<Profile> relatedProfiles= new ArrayList<>();

    public LinkedInIterator(SocialNetwork linkedIn, IteratorType type, String email){
        this.linkedIn= linkedIn;
        this.type= type;
        this.email=email;
    }
    @Override
    public boolean hasNext() {
        lazyLoadEmails(this.email);
        return currentPosition<this.emails.size();
    }

    @Override
    public Profile getNext() {
        if(!hasNext())
            return null;

        String email = emails.get(currentPosition);
        Profile profile = relatedProfiles.get(currentPosition);
        if(null!= profile){
            profile = linkedIn.requestProfile(email);
            relatedProfiles.set(currentPosition,profile);
        }
        currentPosition++;
        return profile;
    }

    @Override
    public void reset() {
        currentPosition=0;
    }

    private void lazyLoadEmails(String email) {
        List<String> strings = linkedIn.requestConnectionsOf(this.email, this.type);
        this.emails.addAll(strings);
    }
}
