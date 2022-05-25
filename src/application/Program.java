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
		String departmentName = sc.next();
		System.out.print("Dia do pagamento: ");
		int payDay = sc.nextInt();
		System.out.print("Email: ");
		String departmentEmail = sc.next();
		System.out.print("Telefone: ");
		String departmentPhone = sc.next();

		Address adress = new Address(departmentEmail, departmentPhone);
		Department department = new Department(departmentName, payDay, adress);

		System.out.print("Quantos funcionários tem o departamento? ");
		int quantityEmployee = sc.nextInt();

		for (int i = 0; i < quantityEmployee; i++) {
			System.out.println("Dados do funcionário " + (i + 1));
			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salário: ");
			Double salary = sc.nextDouble();

			Employee employee = new Employee(name, salary);
			department.addEmployee(employee);
		}
		System.out.println();
		System.out.println("FOLHA DE PAGAMENTO:");
		showReport(department);

		sc.close();

	}

	private static void showReport(Department department) {

		StringBuilder sb = new StringBuilder();

		sb.append("Departamento " + department.getName());
		sb.append(" = R$ " + String.format("%.2f", department.payRoll()) + "\n");
		sb.append("Pagamento realizado no dia " + department.getPayDay() + "\n");
		sb.append("Funcionários:\n");
		for (Employee emp : department.getEmployees()) {
			sb.append(emp.getName() + "\n");
		}
		sb.append("Para dúvidas, favor entrar em contato: ");
		sb.append(department.getAddress().getEmail());

		System.out.println(sb);
	}
}
