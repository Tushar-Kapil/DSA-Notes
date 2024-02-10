package Stack;

public class CustomStack {

    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    private int top = -1;

    CustomStack() {
        this(DEFAULT_SIZE);
    }

    CustomStack(int size) {
        this.data = new int[size];
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is already full");
            return;
        }
        top++;
        data[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is already Empty");
            return 1;
        }
        int poped = data[top];
        top--;
        return poped;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is  Empty");
            return 1;
        }
        return data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == data.length - 1;
    }

    public static void main(String[] args) {
        CustomStack stack = new CustomStack();

        stack.push(1);
        stack.push(2);
        stack.push(5);
        stack.push(10);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());

    }

}
