package ru.baROM.pr2;

public class MyArrayList<T> implements MyList<T>{

    private static final int DEFAULT_SIZE = 8;

    private Object[] items;
    private int size;

    public MyArrayList() {
        this.items = new Object[DEFAULT_SIZE];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T item) {
        if (size >= items.length) {
            Object[] newitems = new Object[size + DEFAULT_SIZE];
            System.arraycopy(items, 0, newitems, 0, size);
            items = newitems;
        }
        items[size] = item;
        size++;
    }

    public void add(int index, T item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(item);
            return;
        }
        Object[] tempitems;

        if (size + 1 > items.length) {
            tempitems = new Object[size + DEFAULT_SIZE];
        } else {
            tempitems = new Object[items.length];
        }
        if (index == 0) {
            System.arraycopy(items, 0, tempitems, 1, size);
            items = tempitems;
            items[0] = item;
            size++;
        } else {
            System.arraycopy(items, 0, tempitems, 0, index);
            System.arraycopy(items, index, tempitems, index + 1, size - index);
            items = tempitems;
            items[index] = item;
            size++;
        }
    }

    public boolean delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Object[] tempitems = new Object[items.length];

        if (index == 0) {
            System.arraycopy(items, 1, tempitems, 0, size - 1);
            items = tempitems;
            size--;
        } else {
            System.arraycopy(items, 0, tempitems, 0, index);
            System.arraycopy(items, index + 1, tempitems, index, size - index - 1);
            items = tempitems;
            size--;
        }
        return true;
    }

    public boolean delete(T item) {
        int index = indexOf(item);
        if (index == -1) {
            return false;
        } else {
            return delete(index);
        }
    }

    public int indexOf(T item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(items[i])) {
                return i;
            }
        }
        return -1;
    }

    public void set(T item, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        items[index] = item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) items[index];
    }

    public boolean contains(T item) {
        return indexOf(item) > -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(items[i]).append(", ");
        }
        if (size > 0) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }
}
