package com.scarycoders.learn.dataStructure.queue

import com.scarycoders.learn.design.pattern.strategy.Item
import spock.lang.Specification
import uk.co.jemos.podam.api.PodamFactoryImpl

class QueueTest extends Specification {
    def podamFactory = new PodamFactoryImpl();
    def queue = new Queue();
    def item1 = podamFactory.manufacturePojo(Item.class);
    def item2 = podamFactory.manufacturePojo(Item.class);
    def item3 = podamFactory.manufacturePojo(Item.class);
    def item4 = podamFactory.manufacturePojo(Item.class);

    def "PeekFirst"() {
        given:
        queue.offer(item1);
        queue.offer(item2);
        queue.offer(item3);
        when:
        def firstElement = queue.peekFirst();
        then:
        firstElement.equals(item1);
        queue.size() == 3
    }

    def "PeekLast"() {
        given:
        queue.offer(item1);
        queue.offer(item2);
        queue.offer(item3);
        when:
        def lastElement = queue.peekLast();
        then:
        lastElement.equals(item3);
        queue.size() == 3
    }

    def "Clear"() {
        given:
        queue.offer(item1);
        queue.offer(item2);
        queue.offer(item3);
        when:
        queue.clear();
        then:
        queue.size() == 0
    }

    def "Offer"() {
        given:
        queue.offer(item1);
        queue.offer(item2);
        queue.offer(item3);
        when:
        queue.offer(item4);
        then:
        item4.equals(queue.peekLast());
        queue.size() == 4
    }

    def "Poll"() {
        given:
        queue.offer(item1);
        queue.offer(item2);
        queue.offer(item3);
        when:
        def polled = queue.poll();
        then:
        polled.equals(item1);
        queue.peekFirst().equals(item2);
        queue.size() == 2
    }

    def "Iterator"() {
        given:
        queue.offer(item1);
        queue.offer(item2);
        queue.offer(item3);
        when:
        def itr = queue.iterator()
        then:
        while (itr.hasNext()) {
            println(itr.next());
        }
        true
    }
}
