package Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap {

    private int[] arr;
    private int size;

    Heap(int capacity) {
        arr = new int[capacity];
        size = -1;
    }

    public void insert(int val) {
        size++;
        int index = size;
        arr[index] = val;

        while (index > 0) {
            int parent = index / 2;

            if (arr[parent] < arr[index]) {
                int temp = arr[parent];
                arr[parent] = arr[index];
                arr[index] = temp;
                index = parent;
            } else {
                return;
            }
        }
    }

    public void delete() {
        if (size == 0) {
            System.out.println("Already empty");
        }

        arr[0] = arr[size];
        size--;

        int i = 0;

        while (i < size) {
            int leftIndex = 2 * i + 1;
            int rightIndex = 2 * i + 2;

            if (arr[i] < arr[leftIndex] && i < size) {
                int temp = arr[i];
                arr[i] = arr[leftIndex];
                arr[leftIndex] = temp;
                i = leftIndex;

            } else if (arr[i] < arr[rightIndex] && i < size) {
                int temp = arr[i];
                arr[i] = arr[rightIndex];
                arr[rightIndex] = temp;
                i = rightIndex;
            } else {
                return;
            }
        }
    }

    public void display() {
        for (int i = 0; i <= size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void heapify(int arr[], int i, int n) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < n && arr[largest] < arr[leftChild]) {
            largest = leftChild;
        }

        if (rightChild < n && arr[largest] < arr[rightChild]) {
            largest = rightChild;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, largest, n);
        }
    }

    public void buildHeap(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }
    }

    public void heapSort(int arr[]) {
        int n = arr.length - 1;

        while (n > 1) {
            int temp = arr[0];
            arr[0] = arr[n];
            arr[n] = temp;
            n--;

            heapify(arr, 0, n);
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap(10);
        h.insert(50);
        h.insert(55);
        h.insert(53);
        h.insert(52);
        h.insert(54);
        h.display();
        h.delete();
        h.display();

        int[] arr = { 54, 53, 55, 52, 50 };
        h.buildHeap(arr);
        System.out.println(Arrays.toString(arr));

        h.heapSort(arr);
        System.out.println(Arrays.toString(arr));

        // Min Heap
        PriorityQueue<Integer> p = new PriorityQueue<>();
        p.add(4);
        p.add(2);
        p.add(5);
        p.add(3);
        System.out.println(p);

        // Max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(4);
        pq.add(2);
        pq.add(5);
        pq.add(3);
        // System.out.println(pq);

    }
}
