package uk.ac.cam.kjh67.q46;

import java.util.AbstractList;
import java.util.Collection;

public class CollectionArrayList <T> extends AbstractList<T> {

    // Need to use Object[] instead of T[]
    private Object[] array;
    private int size;

    public CollectionArrayList() { array = new Object[] {}; }

    public CollectionArrayList(Collection<T> collection) {
        array = collection.toArray();
    }

    @Override
    public T get(int index) {
        if (0 <= index && index <= size) {
            return (T)array[index];
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T set(int index, T element) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T previous = (T)array[index];
        array[index] = element;

        return previous;
    }

    @Override
    public boolean add(T element) {
        if (size==array.length) {
            // need new array
            Object[] new_array = new Object[] {size*2};
            System.arraycopy(array, 0, new_array, 0, size);
            array = new_array;
        }
        array[size] = element;
        size++;
        return true;
    }

    @Override
    public T remove(int index) {
        // shuffle the other elements along
        T to_return = (T)array[index];
        for (int i = index; i < size-1; i++) {
            array[i] = array[i+1];
        }
        return to_return;
    }
}
