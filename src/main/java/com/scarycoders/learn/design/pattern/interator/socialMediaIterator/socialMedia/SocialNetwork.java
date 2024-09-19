package com.scarycoders.learn.design.pattern.interator.socialMediaIterator.socialMedia;

import com.scarycoders.learn.design.pattern.interator.socialMediaIterator.iterator.IteratorType;
import com.scarycoders.learn.design.pattern.interator.socialMediaIterator.iterator.ProfileIterator;
import com.scarycoders.learn.design.pattern.interator.socialMediaIterator.model.Profile;

import java.util.List;

public interface SocialNetwork {

    ProfileIterator createFriendsIterator(String email);
    ProfileIterator createCoworkerIterator(String email);

    Profile requestProfile(String profileEmail);
    List<String> requestConnectionsOf(String profileEmail, IteratorType connectionType);

    default void simulateNetworkLatencyForMs(long latency){
        try{
            Thread.sleep(latency);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }

}
