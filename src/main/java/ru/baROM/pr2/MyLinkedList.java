package ru.baROM.pr2;

public class MyLinkedList<T> implements MyList<T> {
    private Node first;
    private Node last;
    private int size;

    private class Node {
        Node prev;
        T value;
        Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(Node prev, T value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

    public MyLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void add(T item) {
        Node newNode = new Node(last, item, null);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }

    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            Node newNode = new Node(item, first);
            if (isEmpty()) {
                last = newNode;
            } else {
                first.setPrev(newNode);
            }
            first = newNode;
            size++;
            return;
        }
        if (index == size) {
            Node newNode = new Node(last, item, null);
            if (isEmpty()) {
                first = newNode;
            } else {
                last.setNext(newNode);
            }
            last = newNode;
            size++;
            return;
        }
        Node current = first;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        Node newNode = new Node(current, item, current.getNext());
        current.setNext(newNode);
        current.getNext().setPrev(newNode);
        size++;
    }

    public boolean delete(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            first = first.getNext();
            if (isEmpty()) {
                last = null;
            } else {
                first.setPrev(null);
            }
            size--;
            return true;
        }

        int idx = 0;
        Node current = first;
        while (current != null && idx != index) {
            current = current.getNext();
            idx++;
        }
        if (current == null) {
            return false;
        }
        if (current == last) {
            if (last.getPrev() == null) {
                first = null;
            } else {
                last.getPrev().setNext(null);
            }
            last = last.getPrev();
            size--;
            return true;
        }

        current.getNext().setPrev(current.getPrev());
        current.getPrev().setNext(current.getNext());
        size--;
        return true;
    }

    public int indexOf(T item) {
        Node current = first;
        int index = 0;
        while (current != null) {
            if (item.equals(current.getValue())) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    public boolean delete(T item) {
        if (isEmpty()) {
            return false;
        }
        if (item.equals(first.getValue())) {
            first = first.getNext();
            if (isEmpty()) {
                last = null;
            } else {
                first.setPrev(null);
            }
            size--;
            return true;
        }

        Node current = first;
        while (current != null && !item.equals(current.getValue())) {
            current = current.getNext();
        }
        if (current == null) {
            return false;
        }

        if (current == last) {
            if (last.getPrev() == null) {
                first = null;
            } else {
                last.getPrev().setNext(null);
            }
            last = last.getPrev();
            size--;
            return true;
        }

        current.getNext().setPrev(current.getPrev());
        current.getPrev().setNext(current.getNext());
        size--;
        return true;
    }

    public boolean contains(T item) {
        return indexOf(item) > -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node current = first;
        for (int i = 0; i < size; i++) {
            sb.append(current.getValue()).append(", ");
            current = current.getNext();
        }
        if (size > 0) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }

}
