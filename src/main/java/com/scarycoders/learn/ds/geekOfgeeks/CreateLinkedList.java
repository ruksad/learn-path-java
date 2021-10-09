package com.scarycoders.learn.ds.geekOfgeeks;

public class CreateLinkedList<T> {

  private Node<T> head = null;

  public CreateLinkedList(T headData) {
    this.head = getNodeWith(headData);
  }

  public Node<T> delete(T node, boolean isDeleteFirstOccurrenceOnly) throws Exception {
    if (this.head == null) {
      throw new Exception("you cannot delete the from arrayList");
    }
    Node<T> tail = head;
    while (!tail.getNext().getData().equals(node)) {
      tail = tail.getNext();
    }
    tail .setNext( tail.getNext().getNext());

    if (!isDeleteFirstOccurrenceOnly) {
      if (tail.getNext() == null) {
        return head;
      }
      this.delete(node, false);
    }
    return head;
  }

  public Node<T> add(T node) {
    Node tail = this.head;
    Node<T> nodeWith = getNodeWith(node);
    if (this.head == null) {
      this.head = nodeWith;
      this.head.setNext(null);
      return head;
    } else {
      while (tail.getNext() != null) {
        tail = tail.getNext();
      }
      tail.setNext(nodeWith);
    }
    return head;
  }

  public void print() {
    StringBuffer stringBuffer = new StringBuffer("Linked list: ");
    Node<T> tail;
    tail = head;
    while (tail.getNext() != null) {
      stringBuffer.append(tail.getData() + "---->");
      tail = tail.getNext();
    }
    stringBuffer.append(tail.getData());
    System.out.println(stringBuffer);
  }

  public static void main(String[] args) {
    CreateLinkedList<Integer> integerCreateLinkedList = new CreateLinkedList<>(5);
    integerCreateLinkedList.add(6);
    integerCreateLinkedList.add(7);
    integerCreateLinkedList.add(6);
    integerCreateLinkedList.add(6);
    integerCreateLinkedList.add(8);
    integerCreateLinkedList.add(6);
    System.out.println(LLUtils.isCreatedLinkedListRedundant(integerCreateLinkedList));
    integerCreateLinkedList.print();
    try {
      integerCreateLinkedList.delete(6, false);
    } catch (Exception e) {
      e.printStackTrace();
    }
    integerCreateLinkedList.print();
    System.out.println(LLUtils.isCreatedLinkedListRedundant(integerCreateLinkedList));
  }

  private Node<T> getNodeWith(T data) {
    Node<T> tNode = new Node<>();
    tNode.setData(data);
    tNode.setNext(null);
    tNode.setPrev(null);
    return tNode;
  }

  public Node<T> getHead() {
    return head;
  }
}
