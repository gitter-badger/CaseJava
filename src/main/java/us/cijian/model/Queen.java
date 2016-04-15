package us.cijian.model;

import java.util.Arrays;

/**
 * Created by Murphy handle 4/6/2015.
 */
public class Queen<T> {

    private Object[] items;

    public Queen() {
        items = new Queen[0];
    }

    public void push(T t) {
        int length = items.length;
        Object[] temp = new Object[length + 1];
        for (int i = 0; i < items.length; i++) {
            temp[i] = items[i];
        }
        temp[length] = t;
        items = temp;
    }

    public T pop() {
        int length = items.length;
        if (length == 0) {
            throw new StackOverflowError();
        }
        Object[] temp = new Object[length - 1];
        for (int i = 0; i < length - 1; i++) {
            temp[i] = items[i + 1];
        }
        T top = (T) items[0];
        items = temp;
        return top;
    }

    public T top() {
        return (T) items[0];
    }

    @Override
    public String toString() {
        return "Queen=" + Arrays.toString(items);
    }

}
