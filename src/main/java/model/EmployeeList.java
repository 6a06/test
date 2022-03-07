package model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList {
	List<Employee> el=new ArrayList<>();

	public void add(Employee e) {
		el.add(e);
	}
	public EmployeeList() {}
	public List<Employee> getEl() {
		return el;
	}
	public void setEl(List<Employee> el) {
		this.el = el;
	}



}
