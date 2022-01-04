package com.scarycoders.learn.dataStructure.tree

import com.scarycoders.learn.design.pattern.strategy.Item
import spock.lang.Specification
import uk.co.jemos.podam.api.PodamFactoryImpl

class BinarySearchTreeTest extends Specification {

    def podam = new PodamFactoryImpl();
    def bst = new BinarySearchTree();
    def item1 = new Item();
    def item2 = new Item()
    def item3 = new Item();
    def item4 = new Item();
    def item5 = new Item();
    def item6 = new Item();
    def item7 = new Item();
    def item8 = new Item();
    def item9 = new Item();
    def item10 = new Item();

    void setup() {
        item1.setItemName("abc");
        item2.setItemName("bcd");
        item3.setItemName("cde");
        item4.setItemName("def");
        item5.setItemName("efg")
        item6.setItemName("fhi");
        item7.setItemName("hij");
        item8.setItemName("ijk")
        item9.setItemName("jkl");
        item10.setItemName("klm");

        item1.setPrice(100);
        item2.setPrice(200)
        item3.setPrice(300);
        item4.setPrice(400);
        item5.setPrice(500)
        item6.setPrice(600);
        item7.setPrice(700);
        item8.setPrice(800)
        item9.setPrice(900);
        item10.setPrice(1000);
    }

    def "InOrderDFS"() {
    }

    def "PreOrderDFS"() {
    }

    def "PostOrderDFS"() {
    }

    def "BFS"() {
    }

    def "Add"() {
        given:

        when:
        bst.add(item1)
        bst.add(item3)
        bst.add(item2)
        bst.add(item2)
        then:
        true
    }

    def "Contains"() {
    }

    def "Delete"() {
    }


}
