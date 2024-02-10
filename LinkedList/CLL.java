package LinkedList;

public class CLL {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;
    Node tail;

    void insert(int data) {
        Node node = new Node(data);

        if (head == null) {
            head = node;
            tail = node;
        }

        tail.next = node;
        node.next = head;
        tail = node;
    }

    void display() {
        Node temp = head;

        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("Head");
    }

    void delete(int element) {
        Node temp = head;

        if (temp.data == element) {
            head = head.next;
            tail.next = head;
            return;
        }

        do {
            if (temp.next.data == element) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;

        } while (temp != head);

    }

    public static void main(String[] args) {
        CLL list = new CLL();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.display();
        list.delete(20);
        list.display();
    }
}
