package com.employees.Service;

import com.employees.dao.EmpDao;
import com.employees.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class EmpService {

	private final EmpDao empDao;

	@Autowired
	public EmpService(EmpDao empDao) {
		this.empDao = empDao;
	}

	public Model validation(Employee employee,Model model) {
		if(employee.getEmpid() == null) {
			if(isAllFieldsEmpty(employee)) {
				return model.addAttribute("isAllFieldsEmpty", "Please enter all employee details");
			}
			else {
				model.addAttribute("id", "Please enter employee ID");
                if(employee.getName().isEmpty()) {
					model.addAttribute("id", "Please enter employee Name");
				}
				if(employee.getEmail().isEmpty()) {
					model.addAttribute("invalidEmail", "Please enter employee Email");
				}
				if(employee.getAddress().isEmpty()) {
					model.addAttribute("address", "Please enter employee Address");
				}
			}
		}
		else if(isIdExist(employee.getEmpid())) {
			model.addAttribute("id", "ID is alredy exist in DB");
		}
		else {
			if(employee.getName().isEmpty()) {
				model.addAttribute("name", "Please enter employee Name");
			}
			if(employee.getEmail().isEmpty() || !employee.getEmail().contains("@") || !employee.getEmail().contains(".")) {
				model.addAttribute("invalidEmail", "Please enter valid employee Email");
			}
			if(employee.getAddress().isEmpty()) {
				model.addAttribute("address", "Please enter employee Address");
			}
			else {
				addEmployee(employee);
			}
		}
		return model;
	}

	@Transactional
	public void addEmployee(Employee employee) {
		empDao.saveEmployee(employee);
	}
	public boolean isAllFieldsEmpty(Employee employee) {
		return employee.getName().isEmpty() && employee.getEmail().isEmpty() && employee.getAddress().isEmpty();
	}
	public boolean isIdExist(Integer empid) {
		Employee emp = empDao.getEmployeeById(empid);;
		return emp != null;
	}

	@Transactional
	public List<Employee> getAllEmployee() {
		return empDao.getAllRecords();
	}

	@Transactional
	public void deleteEmployee(Integer empid) {
		Employee employee = empDao.getEmployeeById(empid);
		if(employee != null) {
			employee.setActive(0);
		}
		empDao.updateEmployee(employee);
	}

	@Transactional
	public Employee getEmployee(Integer empid) {
		return empDao.getEmployeeById(empid);
	}

	@Transactional
	public void updateNow(Employee employee) {
		empDao.updateEmployee(employee);
	}
}
