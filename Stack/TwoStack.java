package Stack;

import java.util.Arrays;

public class TwoStack {
    int[] arr;
    int top1;
    int top2;
    int size;

    TwoStack(int size) {
        this.size = size;
        arr = new int[size];
        top1 = -1;
        top2 = size;
    }

    public void push1(int data) {
        if (top2 - top1 > 1) {
            top1++;
            arr[top1] = data;
        } else {
            System.out.println("Overflow");
        }
    }

    public void push2(int data) {
        if (top2 - top1 > 1) {
            top2--;
            arr[top2] = data;
        } else {
            System.out.println("Overflow");
        }
    }

    public void pop1() {
        if (top1 >= 0) {
            arr[top1] = 0;
            top1--;
        }
    }

    public void pop2() {
        if (top1 < size) {
            arr[top2] = 0;
            top2++;
        }
    }

    public void display() {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        TwoStack ts = new TwoStack(5);
        ts.push1(10);
        ts.push1(20);
        ts.push1(30);
        ts.push2(90);
        ts.push2(80);
        ts.display();
    }
}
