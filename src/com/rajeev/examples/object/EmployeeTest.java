package com.rajeev.examples.object;

/**
 * Object class method: toString, hashCode, equals, finalize, clone, wait, notify, notifyAll
 * @author RA016GU
 *
 */
public class EmployeeTest {

	public static void main(String[] args) {
		Employee e1 = new Employee(1, "Rajeev");
		Employee e2 = new Employee(1, "Rajeev");

		System.out.println("e1.equals(e2): "+ e1.equals(e2));
		System.out.println("e1.hashCode(): "+ e1.hashCode() + " e2.hashCode(): "+ e2.hashCode());
		System.out.println("e1 == e2: "+ (e1 == e2));
		System.out.println("e1: "+ e1 + " e2: "+ e2);
	}
	
	private static class Employee {
		int id;
		String name;
		
		public Employee(int id, String name) {
			this.id = id;
			this.name = name;
		}

		/*@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Employee other = (Employee) obj;
			if (id != other.id)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}*/
		
		
	}

}
