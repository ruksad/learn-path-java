package com.scarycoders.learn.design.pattern.interator.socialMediaIterator;

import com.scarycoders.learn.design.pattern.interator.socialMediaIterator.iterator.ProfileIterator;
import com.scarycoders.learn.design.pattern.interator.socialMediaIterator.model.Profile;
import com.scarycoders.learn.design.pattern.interator.socialMediaIterator.socialMedia.SocialNetwork;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class SocialMediaSpammer {

    private SocialNetwork socialNetwork;
    private ProfileIterator pfi;

    public SocialMediaSpammer(SocialNetwork socialNetwork){
        this.socialNetwork=socialNetwork;
        this.pfi=pfi;
    }

    public void sendSpamToFriends(String email, String message){
        ProfileIterator friendsIterator = socialNetwork.createFriendsIterator(email);
        while (friendsIterator.hasNext()){
            try {
                Profile next = friendsIterator.getNext();
                sendEmail(next.getEmail() + next.getName(),message);
            } catch (ExecutionException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void sendSpamToCoworkers(String email, String message ){
        ProfileIterator coworkerIterator = socialNetwork.createCoworkerIterator(email);
        while (coworkerIterator.hasNext()){
            Profile next = coworkerIterator.getNext();
            try {
                sendEmail(next.getEmail()+next.getName(),message);
            } catch (ExecutionException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private boolean sendEmail(String email, String message) throws ExecutionException, InterruptedException {

        FutureTask<Boolean> booleanFutureTask = new FutureTask<>(() -> {
            System.out.println("Sending message: " + message + " to email= " + email);
        }, Boolean.TRUE);
        Thread thread = new Thread(booleanFutureTask);
        thread.start();
        return booleanFutureTask.get();
    }
}
