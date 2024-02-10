package OOPS;

import java.util.Arrays;

public class CustomArrayList<T> {

    private Object[] data;
    private int DEFAULT_SIZE = 2;
    private int size = 0;

    CustomArrayList() {
        this.data = new Object[DEFAULT_SIZE];
    }

    public void add(T num) {
        if (isFull()) {
            resize();
        }
        data[size++] = num;
    }

    private void resize() {
        Object[] temp = new Object[data.length * 2];

        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }

        data = temp;
    }

    private boolean isFull() {
        return size == data.length;
    }

    public T get(int index) {
        return (T) (data[index]);
    }

    public T remove() {
        T removed = (T) (data[--size]);

        return removed;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    public static void main(String[] args) {
        CustomArrayList<String> list = new CustomArrayList<String>();

        list.add("Tushar");
        list.add("Tanu");
        list.add("Stuart");

        System.out.println(list);
    }

}
