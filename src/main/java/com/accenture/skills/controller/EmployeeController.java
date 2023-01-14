package com.accenture.skills.controller;

import com.accenture.skills.bean.Employee;
import com.accenture.skills.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

	@GetMapping(
            value = "/employees",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
	public DeferredResult<List<Employee>> getEmployees() {
        DeferredResult<List<Employee>> result = new DeferredResult<>();
		result.setResult(employeeService.findEmployees());

		return result;
	}

	@PostMapping(
			value = "/employee",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public DeferredResult<Employee> insertEmployee(@RequestBody @Valid Employee employee) {
		DeferredResult<Employee> result = new DeferredResult<>();
		result.setResult(employeeService.newEmployee(employee));

		return result;
	}
/*
	//@GetMapping(
	//@Path("/employee/{id}")
	///@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployee(@PathParam("id") int id) {
		return new EmployeeDao().getEmployee(id);
	}

	///@POST
	//@Path("{sysId}")
	//@Produces(MediaType.APPLICATION_JSON)
	//@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON })
	public int updateEmployee(@PathParam("sysId") int sysId, Employee employee) {
		System.out.println("Update");
		employee.setSysId(sysId);

		EmployeeDao employeeDao = new EmployeeDao();
		int res = employeeDao.updateEmployee(employee, "Unknown");

		return res;
	}

	//@GET
	//@Path("{sysId}/skills")
	//@Produces(MediaType.APPLICATION_JSON)
	public List<Skill> getEmployeeSkills(@PathParam("sysId") int sysId) {
		return new SkillDao().getSkillsByEmployeeId(sysId);
	}*/
}