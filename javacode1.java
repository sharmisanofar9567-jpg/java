import java.util.Scanner;

class Pay {
    String name;
    float salary, DA, HRA, grossSalary;

    Scanner in = new Scanner(System.in);

    void input() {
        System.out.print("Enter the name: ");
        name = in.next();

        System.out.print("Enter the salary: ");
        salary = in.nextFloat();
    }

    void calculate() {
        DA = (15.0f / 100) * salary;
        HRA = (10.0f / 100) * salary;

        grossSalary = salary + DA + HRA;
    }

    void output() {
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("DA: " + DA);
        System.out.println("HRA: " + HRA);
        System.out.println("Gross Salary: " + grossSalary);
    }
}

public class Main {
    public static void main(String[] args) {
        Pay p = new Pay();

        p.input();
        p.calculate();
        p.output();
    }
}