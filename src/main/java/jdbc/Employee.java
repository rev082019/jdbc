package jdbc;

// Data Transfer Object
public class Employee {

	private Integer id;
	private String name;
	private String city;
	private String department;
	private Integer salary;
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", city=" + city + ", department=" + department + ", salary="
				+ salary + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Integer getSalary() {
		
		return salary;
	}
	public void setSalary(Integer salary) {
		if(salary<0) {
			throw new IllegalArgumentException("Invalid salary");
			//System.out.println("Invalid salary amt..");
		}
		this.salary = salary;
		
	}
}
