package com.rajeev.domain;

public class Employee {
	int id;
	String firstName;
	String lastName;

	public Employee(EmployeeBuilder employeeBuilder) {
		this.id = employeeBuilder.id;
		this.firstName = employeeBuilder.firstName;
		this.lastName = employeeBuilder.lastName;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public static class EmployeeBuilder {
		int id;
		String firstName;
		String lastName;

		public EmployeeBuilder(int id) {
			this.id = id;
		}

		public EmployeeBuilder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public EmployeeBuilder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Employee build() {
			return new Employee(this);
		}

	}
}
