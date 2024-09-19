package com.scarycoders.learn.design.pattern.interator.socialMediaIterator;

import com.scarycoders.learn.design.pattern.interator.socialMediaIterator.model.Profile;
import com.scarycoders.learn.design.pattern.interator.socialMediaIterator.socialMedia.Facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Read facebook and linkedin profiles and send them spam message to their friends and coworkers using iterator design pattern
 */
//https://refactoring.guru/design-patterns/iterator/java/example
public class DriverClass {

    public static void main(String[] args) {
        SocialMediaSpammer socialMediaSpammer = new SocialMediaSpammer(new Facebook(createTestProfiles()));
        socialMediaSpammer.sendSpamToCoworkers("anna.smith@bing.com","Ha Ha You are bugged");
        socialMediaSpammer.sendSpamToFriends("catwoman@yahoo.com","Ha Ha You are bugged Friend");
    }

    public static List<Profile> createTestProfiles(){
        List<Profile> data = new ArrayList<Profile>();
        data.add(new Profile("anna.smith@bing.com", "Anna Smith", "friends:mad_max@ya.com", "friends:catwoman@yahoo.com", "coworkers:sam@amazon.com"));
        data.add(new Profile("mad_max@ya.com", "Maximilian", "friends:anna.smith@bing.com", "coworkers:sam@amazon.com"));
        data.add(new Profile("bill@microsoft.eu", "Billie", "coworkers:avanger@ukr.net"));
        data.add(new Profile("avanger@ukr.net", "John Day", "coworkers:bill@microsoft.eu"));
        data.add(new Profile("sam@amazon.com", "Sam Kitting", "coworkers:anna.smith@bing.com", "coworkers:mad_max@ya.com", "friends:catwoman@yahoo.com"));
        data.add(new Profile("catwoman@yahoo.com", "Liza", "friends:anna.smith@bing.com", "friends:sam@amazon.com"));
        return data;
    }
}
