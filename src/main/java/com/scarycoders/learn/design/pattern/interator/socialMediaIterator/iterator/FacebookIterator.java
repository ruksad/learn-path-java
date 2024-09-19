package com.scarycoders.learn.design.pattern.interator.socialMediaIterator.iterator;

import com.scarycoders.learn.design.pattern.interator.socialMediaIterator.model.Profile;
import com.scarycoders.learn.design.pattern.interator.socialMediaIterator.socialMedia.SocialNetwork;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FacebookIterator implements ProfileIterator {

    private SocialNetwork facebook;
    private IteratorType type;
    private String email;
    private int currentPosition = 0;

    private List<String> emails = new ArrayList<>();

    private List<Profile> relatedProfiles = new ArrayList<>();

    public FacebookIterator(SocialNetwork facebook, IteratorType type, String email) {
        this.facebook = facebook;
        this.type = type;
        this.email = email;
    }

    @Override
    public boolean hasNext() {
        lazyLoadEmails(this.email);
        return currentPosition < emails.size();
    }

    private void lazyLoadEmails(String email) {
        if (emails.isEmpty()) {
            List<String> strings = facebook.requestConnectionsOf(this.email, this.type);
            strings.forEach(x -> {
                this.emails.add(x);
                this.relatedProfiles.add(null);
            });
        }
    }

    @Override
    public Profile getNext() {
        if (!hasNext())
            return null;

        String email = emails.get(currentPosition);
        Profile profile = relatedProfiles.get(currentPosition);
        if (null == profile) {
            profile = facebook.requestProfile(email);
            relatedProfiles.set(currentPosition, profile);
        }
        currentPosition++;
        return profile;
    }

    @Override
    public void reset() {
        currentPosition = 0;
    }
}
