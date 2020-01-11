package DataStructure;

public class LinkedQueue<T> implements Queue<T> {

    private Node<T> start;
    private int size;
    private Node<T> end;

    public LinkedQueue(){
        start = null;
        size = 0;
    }
    @Override
    public void add(T input) {
        Node<T> node = new Node(input, null);
        if(size == 0){
            start = node;
            end = node;
        }
        else{
            end.next = node;
            end = node;
        }
        size++;
    }

    @Override
    public boolean isEmpty() {
        if(size == 0) return true;
        else return false;
    }

    @Override
    public boolean isFull() {// 노필요
        return false;
    }

    @Override
    public T poll() {
        if(size == 0){
            System.out.println("Queue is Empty");
            return null;
        }
        else{
            T value = start.value;
            start = start.next;
            size--;
            return value;
        }
    }

    @Override
    public void clear() {
        start = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void resize() {//노 필

    }

    class Node<T>{
        T value;
        Node next;

        public Node(){
            value = null;
            next = null;
        }
        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
