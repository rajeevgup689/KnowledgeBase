package com.rajeev.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.rajeev.domain.Employee;

public class SortExample {

	public static void main(String[] args) {
		Employee e1 = new Employee.EmployeeBuilder(1).setFirstName("Rajeev").setLastName("Gupta").build();
		Employee e2 = new Employee.EmployeeBuilder(2).setFirstName("Amod").setLastName("Singh").build();
		Employee e3 = new Employee.EmployeeBuilder(3).setFirstName("Sagar").setLastName("Pahwa").build();

		List<Employee> empList = new ArrayList<>();
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);

		System.out.println("comparing by firstName: ");
		Comparator<Employee> firstNameComparator = new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getFirstName().compareTo(o2.getFirstName());
			}
		};
		Collections.sort(empList, firstNameComparator);
		empList.forEach(o1 -> {
			System.out.println(o1.getFirstName() + " " + o1.getLastName());
		});

		System.out.println("comparing by lastName: ");
		Comparator<Employee> lastNameComparator = (o1, o2) -> o1.getLastName().compareTo(o2.getLastName());
		Collections.sort(empList, lastNameComparator);
		empList.forEach(o1 -> {
			System.out.println(o1.getFirstName() + " " + o1.getLastName());
		});

	}
}
