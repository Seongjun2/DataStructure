package DataStructure;

public class QueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new ArrayQueue<>();

        queue.add("A");
        queue.add("B");
        queue.add("C");
        queue.add("D");


        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println();

        queue.add("A");
        queue.add("B");


        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println();

        queue.add("C");
        queue.add("D");

        System.out.println(queue.poll());
        System.out.println(queue.poll());

    }
}
