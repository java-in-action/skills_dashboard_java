package com.acc.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.acc.bean.Employee;
import com.acc.bean.Skill;
import com.acc.dao.EmployeeDao;
import com.acc.dao.SkillDao;

@Path("/employees")
public class EmployeeService {
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployees() {
		ArrayList<Employee> listEmployees = new ArrayList<Employee>();
		EmployeeDao employeDao = new EmployeeDao();
		listEmployees = employeDao.getEmployees();
		return listEmployees;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON })
	public int insertEmployee(Employee employee) {
		System.out.println("Insert");

		EmployeeDao employeeDao = new EmployeeDao();
		int res = employeeDao.insertEmployee(employee, "Unknown");

		return res;
	}

	@GET
	@Path("{sysId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployee(@PathParam("sysId") int sysId) {
		return new EmployeeDao().getEmployee(sysId);
	}

	@POST
	@Path("{sysId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON })
	public int updateEmployee(@PathParam("sysId") int sysId, Employee employee) {
		System.out.println("Update");
		employee.setSysId(sysId);

		EmployeeDao employeeDao = new EmployeeDao();
		int res = employeeDao.updateEmployee(employee, "Unknown");

		return res;
	}

	@GET
	@Path("{sysId}/skills")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Skill> getEmployeeSkills(@PathParam("sysId") int sysId) {
		return new SkillDao().getSkillsByEmployeeId(sysId);
	}
}