package us.cijian.model;

import java.util.Arrays;

public class Stack<T> {

    public Object[] items;

    public Stack() {
        items = new Object[0];
    }

    public void push(T t) {
        int length = items.length;
        Object[] temp = new Object[length + 1];
        for (int i = 0; i < length; i++) {
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
            temp[i] = items[i];
        }
        T top = (T) items[length - 1];
        items = temp;
        return top;
    }

    public T top() {
        return (T) items[items.length - 1];
    }

    @Override
    public String toString() {
        return "Stack=" + Arrays.toString(items);
    }
}
