package OOPS;

import java.util.ArrayList;
import java.util.List;

class Bank {
    String bankName;
    List<Employee> emps;

    Bank(String bankName) {
        this.bankName = bankName;
    }

    public void setEmp(List<Employee> emps) {
        this.emps = emps;
    }

    public List<Employee> getEmp() {
        return this.emps;
    }
}

class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }
}

public class Asso {

    public static void main(String[] args) {
        Bank axis = new Bank("Axis");
        Employee e1 = new Employee("tushar");
        Employee e2 = new Employee("rahul");

        List<Employee> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);

        axis.setEmp(list);

        for (Employee e : axis.getEmp()) {
            System.out.println(e.name);
        }
    }
}
