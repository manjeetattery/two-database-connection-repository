package com.javatpoint.model2;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Principal {
	@Id
	private Long id;
	private String name;
	private String city;
	private Long salary;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Principal [id=" + id + ", name=" + name + ", city=" + city + ", salary=" + salary + "]";
	}

	public Principal(Long id, String name, String city, Long salary) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.salary = salary;
	}

	public Principal() {
		super();
		// TODO Auto-generated constructor stub
	}

}
