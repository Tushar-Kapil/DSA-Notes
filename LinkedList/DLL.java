package LinkedList;

public class DLL {

    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;
    Node tail;

    void insertFirst(int data) {
        Node node = new Node(data);

        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;

        if (tail == null) {
            tail = head;
        }
    }

    void insertLast(int data) {
        Node node = new Node(data);

        if (tail == null) {
            insertFirst(data);
            return;
        }

        tail.next = node;
        node.prev = tail;
        node.next = null;
        tail = node;
    }

    void insert(int index, int data) {
        Node prev = head;

        for (int i = 1; i < index; i++) {
            prev = prev.next;
        }

        Node node = new Node(data);

        node.next = prev.next;
        prev.next = node;
        node.prev = prev;
        node.next.prev = node;

    }

    void deleteFirst() {
        head = head.next;

        if (head == null) {
            tail = null;
        }

        head.prev = null;
    }

    void deleteLast() {
        Node prev = head;

        while (prev.next != tail) {
            prev = prev.next;
        }

        tail = prev;
        tail.next = null;
    }

    void delete(int index) {
        Node prev = head;

        for (int i = 1; i < index; i++) {
            prev = prev.next;
        }

        prev.next = prev.next.next;
        prev.next.prev = prev;
    }

    void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        DLL list = new DLL();
        list.insertFirst(10);
        list.insertFirst(20);
        list.insertLast(50);
        // list.deleteFirst();
        // list.deleteLast();
        list.delete(1);
        list.display();
    }
}
