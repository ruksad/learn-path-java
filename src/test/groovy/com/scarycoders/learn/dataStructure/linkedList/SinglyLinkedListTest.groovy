package com.scarycoders.learn.dataStructure.linkedList

import com.scarycoders.learn.design.pattern.strategy.Item
import spock.lang.Specification
import uk.co.jemos.podam.api.PodamFactoryImpl

class SinglyLinkedListTest extends Specification {

    def podamFactory = new PodamFactoryImpl();

    def "Size"() {
        given:
        def sll = new SinglyLinkedList();

        when:
        def item1 = podamFactory.manufacturePojo(Item.class);
        sll.add(item1);
        sll.add(podamFactory.manufacturePojo(Item.class))
        then:
        sll.size() == 2;
    }

    def "IsEmpty"() {
        given:
        def sll = new SinglyLinkedList();

        when:
        def item1 = podamFactory.manufacturePojo(Item.class);
        sll.add(item1);
        sll.add(podamFactory.manufacturePojo(Item.class))
        then:
        !sll.isEmpty();
        sll.removeAt(0);
        sll.removeAt(0);
        sll.isEmpty()
    }

    def "Add"() {
        given:
        def sll = new SinglyLinkedList();

        when:
        def item1 = podamFactory.manufacturePojo(Item.class);
        sll.add(item1);
        sll.add(podamFactory.manufacturePojo(Item.class))
        then:
        !sll.isEmpty();
        sll.removeAt(0);
        sll.removeAt(0);
        sll.isEmpty()
    }

    def "AddAt"() {
        given:
        def sll = new SinglyLinkedList();
        def testData = podamFactory.manufacturePojo(Item.class)
        when:
        def item = podamFactory.manufacturePojo(Item.class);
        sll.addAt(0, item);
        sll.addAt(0, testData)
        sll.addAt(10, podamFactory.manufacturePojo(Item.class))
        sll.addAt(2, podamFactory.manufacturePojo(Item.class))
        then:
        def itr = sll.iterator();
        def next = itr.next();
        next.getItemName().equals(testData.getItemName());
    }

    def "Remove"() {
        given:
        def sll = new SinglyLinkedList();
        def testData = podamFactory.manufacturePojo(Item.class)
        def item = podamFactory.manufacturePojo(Item.class);
        sll.addAt(0, item);
        sll.addAt(0, testData)
        sll.addAt(10, podamFactory.manufacturePojo(Item.class))
        sll.addAt(2, podamFactory.manufacturePojo(Item.class))
        when:
        sll.remove(item)
        then:
        sll.size() == 3

    }

    def "RemoveAt"() {
        given:
        def sll = new SinglyLinkedList();
        def testData = podamFactory.manufacturePojo(Item.class)
        def item = podamFactory.manufacturePojo(Item.class);
        def itemAt11 = podamFactory.manufacturePojo(Item.class);
        sll.addAt(0, item);
        sll.addAt(0, testData)
        sll.addAt(10, podamFactory.manufacturePojo(Item.class))
        sll.addAt(2, podamFactory.manufacturePojo(Item.class))
        when:
        def remove = sll.removeAt(0);
        sll.addAt(11, itemAt11);
        def at11 = sll.removeAt(2);
        then:
        testData.getItemName().equals(remove.getItemName())
        //at11.getItemName().equals(itemAt11.getItemName())

    }

    def "Iterator"() {
        given:
        def sll = new SinglyLinkedList();
        when:
        def item1 = podamFactory.manufacturePojo(Item.class);
        sll.add(item1);
        sll.add(podamFactory.manufacturePojo(Item.class))
        then:
        def itr = sll.iterator();
        while (itr.hasNext()) {
            println(itr.next());
        }
        true
    }
}
