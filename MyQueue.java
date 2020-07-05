public interface MyQueue<T> {
    void enqueue(T value);
    T dequeue() throws Exception;
    T peek() throws Exception;
    boolean empty();
}