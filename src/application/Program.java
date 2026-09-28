package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome do departamento: ");
        String deptName = sc.nextLine();
        System.out.print("Dia do pagamento: ");
        int payday = sc.nextInt();
        sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Telefone: ");
        String phone = sc.nextLine();

        Department dept = new Department(deptName, payday, new Address(email, phone));

        System.out.print("Quantos funcionarios tem o departamento? ");
        int numberOfEmployees = sc.nextInt();
        for (int i = 0; i < numberOfEmployees; i++) {
            sc.nextLine();
            System.out.println("Dados do funcionario " + (i + 1) + ":");
            System.out.print("Nome: ");
            String name = sc.nextLine();
            System.out.print("Salario: ");
            double salary = sc.nextDouble();
            dept.addEmployee(new Employee(name, salary));
        }
        showReport(dept);
        sc.close();
    }

    public static void showReport(Department dept) {
        StringBuilder sb = new StringBuilder();
        sb.append("\nFOLHA DE PAGAMENTO:\n");
        sb.append("Departamento " + dept.getName() + " = R$ " + String.format("%.2f", dept.payroll()) + "\n");
        sb.append("Pagamento realizado no dia " + dept.getPayDay()+"\n");
        sb.append("Funcionarios:\n");
        for (Employee employee : dept.getEmployees()) {
            sb.append(employee + "\n");
        }
        sb.append("Para mais duvidas por favor entrar em contato: " + dept.getAddress().getEmail());
        System.out.print(sb.toString());
    }
}
