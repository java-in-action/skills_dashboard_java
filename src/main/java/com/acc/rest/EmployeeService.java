package com.acc.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.acc.bean.Employee;
import com.acc.dao.EmployeeDao;
import com.acc.json.EmployeeJSON;
 
@Path("/employees")
public class EmployeeService {
 
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployees() {
		
		ArrayList<Employee> listEmployees = new ArrayList<Employee>();
		EmployeeDao employeDao = new EmployeeDao();
		listEmployees = employeDao.getEmployees();
		return listEmployees;
 
	}
	
	@GET
	@Path("/{sysId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployees(@PathParam("sysId") int sysId) {
		// Refactorizar este método para que se conecte con la bd
		// 1.-En el DAO crear un método llamado getEmployeeBySysId que busque 
		// empleados por sysId y 
		// 2.- Remplazar el código hardcodeado aquí por el objeto employee 
		// que regresaría el método getEmployeeBySysId
		Employee employee = new Employee();
		
		if ( sysId == 1 ) {			
			employee.setSysId(1);
			employee.seteId("carlos.baez");
			employee.setLevel(11);
			employee.setLocation("CD-MX");
			employee.setName("Baez Carlos");
			employee.setBithday("00/00/00");
		} else {
			// return an error
			 throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		
		return employee;
 
	}
 
	/**
	 * Crear una API que inserte los datos de un employee
	 * 1 = Created
	 * 0 = Already exist
	 * -1 = Errors
	 */
	
	@POST @Consumes("application/json")
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public int insertEmployee(final EmployeeJSON employeeJson) {
		int result = 1;
		System.out.println("Name" + employeeJson.sysId);
		// Insertar aquí el código para insertar los datos en la db
		return result;
	}
}