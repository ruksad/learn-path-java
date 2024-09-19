package com.scarycoders.learn.design.pattern.interator.socialMediaIterator.iterator;

import com.scarycoders.learn.design.pattern.interator.socialMediaIterator.model.Profile;

public interface ProfileIterator {
    boolean hasNext();
    Profile getNext();
    void reset();

}
