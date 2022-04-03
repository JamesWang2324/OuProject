package com.wys.java8.bean;

import java.util.Objects;

public class Employee {

	private Integer id;
	private String name;
	private Integer age;
	private Double salary;
	private Status status;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Employee() {
	}	
	
	public Employee(Integer id) {
		this.id = id;
	}	
	
	public Employee(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public Employee(String name, Integer age, Double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public Employee(String name, Integer age, Double salary, Status status) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.status = status;
	}
	
	public Employee(Integer id, String name, Integer age, Double salary, Status status) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", status=" + status
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, id, name, salary, status);
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
		return Objects.equals(age, other.age) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(salary, other.salary) && status == other.status;
	}

	public enum Status {
		FREE,
		BUSY,
		VOCATION;
	}

	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
}
