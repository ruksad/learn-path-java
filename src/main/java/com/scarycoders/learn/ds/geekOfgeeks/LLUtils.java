package com.scarycoders.learn.ds.geekOfgeeks;

public class LLUtils {

  /**
   * check if
   * @return
   */
  public static boolean isCreatedLinkedListRedundant(CreateLinkedList createLinkedList){
    Node last,redundantNode;
    last=createLinkedList.getHead();


    while(last.getNext()!=null){
      redundantNode=last.getNext();
      while (redundantNode.getNext()!=null){
        if(last.getData().equals(redundantNode.getData())){
          return true;
        }
        redundantNode=redundantNode.getNext();
      }
      last=last.getNext();
    }
    return false;
  }
}
