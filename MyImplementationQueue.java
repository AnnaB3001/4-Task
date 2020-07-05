import java.util.Collection;

public class MyImplementationQueue<T> implements MyQueue<T> {

    private MyLinkedList<T> list;

    public MyImplementationQueue(){
        list = new MyLinkedList<>();
    }

    public MyImplementationQueue(Collection<T> collection){
        for(T element: collection){
            list.addLast(element);
        }
    }

    @Override
    public void enqueue(T value) {
        list.addLast(value);
    }

    @Override
    public T dequeue() throws Exception {
        T value = list.getFirstElement();
        list.removeFirst();
        return value;
    }

    @Override
    public T peek() throws Exception {
        return list.getFirstElement();
    }

    @Override
    public boolean empty() {
        return list.getQuantityElement() == 0;
    }
}
