public interface MyStack<T> {
    void push(T value);
    T peek() throws Exception;
    T pop() throws Exception;
    boolean empty();
}