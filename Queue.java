package DataStructure;

public interface Queue<T> {
    void add(T input);
    boolean isEmpty();
    boolean isFull();
    T poll();
    void clear();
    int size();
    void resize();

}
