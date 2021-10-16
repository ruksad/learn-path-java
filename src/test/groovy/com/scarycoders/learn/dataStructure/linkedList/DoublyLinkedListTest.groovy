package com.scarycoders.learn.dataStructure.linkedList

import com.scarycoders.learn.design.pattern.strategy.Item
import spock.lang.Specification
import uk.co.jemos.podam.api.PodamFactoryImpl

class DoublyLinkedListTest extends Specification {

    def podamFactory = new PodamFactoryImpl();
    def dll = new DoublyLinkedList();
    def item1 = podamFactory.manufacturePojo(Item.class);
    def item2 = podamFactory.manufacturePojo(Item.class);
    def item3 = podamFactory.manufacturePojo(Item.class);
    def item4 = podamFactory.manufacturePojo(Item.class);

    def "Add"() {
    }

    def "AddAt"() {
        given:

        when:
        dll.add(item1);
        dll.addAt(-3, item2);
        dll.addAt(10, item3);  //item2,item1,item3
        dll.addAt(1, item4);//item2,item4,item1,item3
        then:
        dll.size() > 0;
    }

    def "AddAt bigger index than length"() {
        given:
        dll.add(item1);
        dll.addAt(1, item2);
        dll.addAt(2, item3);  //item2,item1,item3
        dll.addAt(3, item4);//item2,item4,item1,item3
        when:
        dll.addAt(10, item4);
        then:
        dll.peekLast().equals(item4)
    }

    def "AddAt smaller index  than 0"() {
        given:
        dll.add(item1);
        dll.addAt(1, item2);
        dll.addAt(2, item3);  //item2,item1,item3
        dll.addAt(3, item4);//item2,item4,item1,item3
        when:
        dll.addAt(-4, item4);
        then:
        dll.peekFirst().equals(item4)
    }


    def "Size"() {
    }

    def "IsEmpty"() {
    }

    def "Remove"() {
        when:
        dll.add(item1);
        dll.add(item2)
        dll.add(item3)

        then:
        dll.remove(item3).equals(item3);
    }

    def "RemoveAt"() {

        when:
        dll.addAt(0, item1);
        dll.addAt(0, item2)
        dll.addAt(0, item3)
        dll.remove(item3);
        then:
        dll.peekFirst().equals(item2)
        !dll.peekFirst().equals(item3)
    }

    def "RemoveAt smaller index than 0"() {
        given:
        dll.addAt(1, item1);
        dll.addAt(2, item2)
        dll.addAt(3, item3)
        dll.addAt(4, item4);
        when:
        dll.removeAt(-5);
        then:
        thrown(RuntimeException)
    }

    def "Iterator"() {
        given:
        dll.addAt(1, item1);
        dll.addAt(2, item2)
        dll.addAt(3, item3)
        dll.addAt(4, item4);
        when:
        def itr = dll.iterator();
        then:

        while (itr.hasNext()) {
            println(itr.next());
        }
        true
    }

    def "PeekFirst"() {
    }

    def "PeekLast"() {
    }

    def "Clear"() {
    }

}
