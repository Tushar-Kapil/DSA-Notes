package LinkedList;

class LinkedList {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;
    Node tail;
    int size;

    LinkedList() {
        this.size = 0;
    }

    void insertFirst(int data) {

        Node node = new Node(data);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size++;
    }

    void insertLast(int data) {

        if (tail == null) {
            insertFirst(data);
            return;
        }
        Node node = new Node(data);
        tail.next = node;
        tail = node;
        size++;
    }

    void insert(int data, int index) {
        if (index == 0) {
            insertFirst(data);
            return;
        }
        if (index == size) {
            insertLast(data);
            return;
        }

        Node curr = head;

        for (int i = 1; i < index; i++) {
            curr = curr.next;
        }

        Node node = new Node(data);
        node.next = curr.next;
        curr.next = node;

        size++;
    }

    int deleteFirst() {
        int val = head.data;
        head = head.next;

        if (head == null) {
            tail = null;
        }
        size--;

        return val;

    }

    int deleteLast() {
        if (head == null) {
            return -1;
        }

        Node curr = head;

        while (curr.next != tail) {
            curr = curr.next;
        }
        int last = curr.next.data;
        tail = curr;
        curr.next = null;

        return last;
    }

    int delete(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }

        Node prev = head;

        for (int i = 1; i < index; i++) {
            prev = prev.next;
        }
        int val = prev.next.data;

        prev.next = prev.next.next;

        return val;
    }

    void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");

            temp = temp.next;
        }
        System.out.println("NULL");
    }

}

public class LL {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertFirst(10);
        list.insertFirst(20);
        list.insertFirst(30);
        list.insert(50, 1);
        list.display();
        list.deleteLast();
        list.display();
        list.delete(1);
        list.display();

    }
}