package OOPS;

public class Stat2 {

    public static void main(String[] args) {

        // static cannot acces non-static data
        // greet();

        Stat2 st = new Stat2();

        st.greet();
    }

    // is not dependent on object
    static void fun() {
        // greet(); //cant use
    }

    // belongs to an objects, cannot use it without making object
    void greet() {
        fun(); // can use static inside non-statics
        System.out.println("Hello");
    }
}
