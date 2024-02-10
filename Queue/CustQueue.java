package Queue;

import java.util.Arrays;

public class CustQueue {

    int[] arr;
    int front;
    int rear;
    int size;

    CustQueue(int capacity) {
        arr = new int[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void enqueue(int data) {
        if (rear == arr.length) {
            System.out.println("Queue is Full");
        } else {
            arr[rear++] = data;
        }
    }

    public void dequeue() {
        if (front == rear) {
            System.out.println("Queue is Empty");
        } else {
            arr[front] = 0;
            front++;

            if (front == rear) {
                front = 0;
                rear = 0;
            }
        }
    }

    public int peek() {
        return arr[front];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void display() {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        CustQueue q = new CustQueue(4);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(50);
        q.enqueue(70);
        q.display();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.display();

    }
}
