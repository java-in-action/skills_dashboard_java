package com.acc.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.acc.bean.Employee;
 
@Path("/employees")
public class EmployeeService {
 
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployees() {
		
		ArrayList<Employee> listEmployees = new ArrayList<Employee>();
		Employee employee = new Employee();
		
		employee.setSysId(1);
		employee.seteId("carlos.baez");
		employee.setLevel(11);
		employee.setLocation("CD-MX");
		employee.setName("Baez Carlos");
		employee.setBithday("00/00/00");
		
		Employee employee2 = new Employee();
		employee2.setSysId(2);
		employee2.seteId("s.coronado.andrad");
		employee2.setLevel(12);
		employee2.setLocation("MTY");
		employee2.setName("Coronado Andrade, S.");
		employee2.setBithday("00/00/00");

		Employee employee3 = new Employee();
		employee3.setSysId(3);
		employee3.seteId("g.rodriguez.lozano");
		employee3.setLevel(10);
		employee3.setLocation("CD-MX");
		employee3.setName("Rodriguez Lozano, G.");
		employee3.setBithday("00/00/00");
		
		Employee employee4 = new Employee();
		employee4.setSysId(4);
		employee4.seteId("r.sanchez.rojas");
		employee4.setLevel(10);
		employee4.setLocation("MTY");
		employee4.setName("Sanchez Rojas, R.");
		employee4.setBithday("00/00/00");
		
		Employee employee5 = new Employee();
		employee5.setSysId(5);
		employee5.seteId("ivan.albor");
		employee5.setLevel(9);
		employee5.setLocation("USA");
		employee5.setName("Albor, Ivan");
		employee5.setBithday("00/00/00");
		
		listEmployees.add(employee);
		listEmployees.add(employee2);
		listEmployees.add(employee3);
		listEmployees.add(employee4);
		listEmployees.add(employee5);
		
		return listEmployees;
 
	}
 
}