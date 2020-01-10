package DataStructure;

public class ArrayQueue<T> implements Queue<T> {

    private T[] array;
    private int front;
    private int rear;
    private int size;

    public ArrayQueue(int queueSize){
        array = (T[])new Object[10];
        front = 0;
        rear = 0;
        size = 0;
    }

    @Override
    public void add(T input) {
        if(size == 0){
            array[0] = input;
        }
        else{
            if(isFull()){
                resize();
                array[rear] = input;
            }
            else{
                array[rear] = input;
            }
            size++;
            rear++;
        }
    }

    @Override
    public boolean isEmpty() {
        if(size == 0) return true;
        else return false;
    }

    @Override
    public boolean isFull() {
        if(array.length == size) return true;
        else return false;
    }

    @Override
    public T poll() {
        if(size == 0) return null;
        else{
            T t = array[front];
            array[front] = null;
            front++;
            size--;
            return array[front];
        }
    }

    @Override
    public void clear() {
        array = (T[])new Object[10];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void resize() {
        T[] tArray = (T[])new Object[size*2];
        System.arraycopy(array,0, tArray, 0, array.length);
        array = tArray;
    }

}
