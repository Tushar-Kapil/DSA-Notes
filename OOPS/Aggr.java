package OOPS;

import java.util.ArrayList;
import java.util.List;

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

class Department {
    String deptName;
    List<Student> students;

    Department(String deptName, List<Student> students) {
        this.deptName = deptName;
        this.students = students;
    }

    public List<Student> getStudents() {
        return this.students;
    }
}

class College {
    String name;
    List<Department> departments;

    College(String name, List<Department> departments) {
        this.name = name;
        this.departments = departments;
    }
}

public class Aggr {
    public static void main(String[] args) {
        Student s1 = new Student("tushar");
        Student s2 = new Student("tanya");
        List<Student> studentListCse = new ArrayList<>();
        studentListCse.add(s1);
        studentListCse.add(s2);

        Student s3 = new Student("kapil");
        Student s4 = new Student("budhiraja");
        List<Student> studentListBca = new ArrayList<>();
        studentListBca.add(s3);
        studentListBca.add(s4);

        Department cse = new Department("cse", studentListCse);
        Department bca = new Department("bca", studentListBca);
        List<Department> departments = new ArrayList<>();
        departments.add(cse);
        departments.add(bca);

        College chitkara = new College("chitkara", departments);
    }

}
