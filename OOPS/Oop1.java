package OOPS;

class Student {
    int rno;
    String name;

    static void hello() {
        // System.out.println(this.name); //cant use
    }

    Student(int rno, String name) {
        this.rno = rno;
        this.name = name;
    }

    Student(Student st) {
        this.name = st.name;
        this.rno = st.rno;
    }
}

public class Oop1 {

    public static void main(String[] args) {

        Student s1 = new Student(2110991462, "Tushar");

        Student s2 = new Student(s1);

        System.out.println(s2.name);
        System.out.println(s2.rno);
    }
}
