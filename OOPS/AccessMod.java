package OOPS;

class A {
    private int num;
    String name;
    int[] arr;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    A(int num, String name) {
        this.num = num;
        this.name = name;
        this.arr = new int[num];
    }
}

public class AccessMod {

    public static void main(String[] args) {
        A a = new A(10, "Tushar");
        System.out.println(a.getNum());
        a.setNum(20);
        System.out.println(a.getNum());

        // Acces Modifiers:-
        // 1) Private -> Only accessible in the same class
        // 2) Public -> accessible every where (different packages)
        // 3) Default -> accessible everywhere within the same package

    }
}
