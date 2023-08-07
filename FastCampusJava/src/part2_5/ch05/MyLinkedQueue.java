package part2_5.ch05;

import part2_5.ch03.MyLinkedList;
import part2_5.ch03.MyListNode;

interface Queue{
    public void enQueue(String data);
    public String dequeue();
    public void printQueue();
}

public class MyLinkedQueue extends MyLinkedList implements Queue{

    MyListNode front;
    MyListNode rear;

    @Override
    public void enQueue(String data) {
        MyListNode newNode;
        if( isEmpty()){
            newNode = addElement(data);
            front = newNode;
            rear = newNode;
        } else {
            newNode = addElement(data);
            rear = newNode;
        }

        System.out.println(newNode.getData() + " added");
    }

    @Override
    public String dequeue() {

        if(isEmpty()){
            return null;
        }

        String data = front.getData();
        front = front.next;

        if(front == null){
            rear = null;
        }

        return data;
    }

    @Override
    public void printQueue() {
        printAll();
    }


}
