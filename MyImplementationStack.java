import java.util.Collection;

public class MyImplementationStack<T> implements MyStack<T> {

    private MyLinkedList<T> list;

    public MyImplementationStack(){
        list = new MyLinkedList<>();
    }

    public MyImplementationStack(Collection<T> collection){
        this.list = new MyLinkedList<>(collection);
    }

    @Override
    public void push(T value) {
        list.addFirst(value);
    }

    @Override
    public T peek() throws Exception {
        return list.getFirstElement();
    }

    @Override
    public T pop() throws Exception {
        T value = list.getFirstElement();
        list.removeFirst();
        return value;
    }

    @Override
    public boolean empty() {
        return list.getQuantityElement() == 0;
    }
}
