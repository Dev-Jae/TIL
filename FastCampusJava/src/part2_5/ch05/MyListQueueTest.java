package part2_5.ch05;

public class MyListQueueTest {
    public static void main(String[] args) {
        MyLinkedQueue listQueue = new MyLinkedQueue();
        listQueue.enQueue("A");
        listQueue.enQueue("B");
        listQueue.enQueue("C");

        listQueue.printQueue();

        System.out.println(listQueue.dequeue());
        System.out.println(listQueue.dequeue());

        listQueue.printQueue();
    }
}
