package L7;

import lombok.Getter;

import java.util.Iterator;


public class Collection<T> implements Iterator<PartCollection<T>> {

    @Getter
    private PartCollection<T> head;
    @Getter
    private PartCollection<T> tail;
    private int size;
    private PartCollection<T> current;


    public void add(T value) {
        PartCollection<T> newNode = new PartCollection<>();
        newNode.setValue(value);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
        size++;
    }


    public PartCollection<T> delete() {
        if (tail == null) {
            return null;
        }
        PartCollection<T> deletedNode = tail;

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.getPrevious();
            tail.setNext(null);
        }

        size--;
        return deletedNode;
    }

    public PartCollection<T> delete(T value) {
        PartCollection<T> current = head;

        while (current != null) {
            if (current.getValue().equals(value)) {
                if (current == head) {
                    head = head.getNext();
                    if (head != null) head.setPrevious(null);
                } else if (current == tail) {
                    tail = tail.getPrevious();
                    if (tail != null) tail.setNext(null);
                } else {
                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious());
                }
                size--;
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public PartCollection<T> findByValue(T value) {
        PartCollection<T> current = head;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public int size() {
        return size;
    }

    @Override
    public boolean hasNext() {
        if (current == null) {
            current = head;
        } else {
            current = current.getNext();
        }
        return current != null;
    }

    @Override
    public PartCollection<T> next() {
        return current;
    }

}