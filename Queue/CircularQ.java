package Queue;

public class CircularQ {
    int[] arr;
    int front;
    int rear;
    int size;

    CircularQ(int capacity) {
        arr = new int[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public boolean isFull() {
        return size == arr.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int data) {
        if (isFull()) {
            return;
        }

        arr[rear] = data;
        rear++;
        rear = rear % arr.length;
        size++;
    }

    public void dequeue() {
        if (isEmpty()) {
            return;
        }

        front++;
        front = front % arr.length;
        size--;
    }

    public void display() {
        int i = front;

        do {
            System.out.print(arr[i] + "->");
            i++;
            i = i % arr.length;
        } while (i != rear);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQ cq = new CircularQ(3);
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.display();
        cq.dequeue();
        cq.display();
        cq.enqueue(50);
        cq.display();

    }
}
