package com.scarycoders.learn.design.observer1;

import com.scarycoders.learn.design.observer1.observer.BinaryObserver;
import com.scarycoders.learn.design.observer1.observer.HexObserver;
import com.scarycoders.learn.design.observer1.observer.OctalObserver;
import com.scarycoders.learn.design.observer1.subject.Subject;
import com.scarycoders.learn.design.observer1.subject.SubjectImpl;

/**
 * https://www.tutorialspoint.com/design_pattern/observer_pattern.htm
 */
public class ObserverPatternDemo {
    public static void main(String[] args) {
        SubjectImpl subject = new SubjectImpl();

        BinaryObserver binaryObserver = new BinaryObserver(subject);
        HexObserver hexObserver = new HexObserver(subject);
        OctalObserver octalObserver = new OctalObserver(subject);

        subject.setNotifyData(1);
        subject.setNotifyData(2);
        subject.setNotifyData(100);

    }
}
