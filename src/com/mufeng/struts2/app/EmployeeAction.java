package com.mufeng.struts2.app;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class EmployeeAction implements RequestAware,ModelDriven<Employee>,Preparable{
	private Dao dao =new Dao();
	private Employee employee;
	private Integer employeeId;
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String delete(){
		dao.delete(employeeId);
		return "delete";
	}
public String list(){
	request.put("emps", dao.getEmployees());
	return "list";
}
private Map<String, Object>request;
@Override
public void setRequest(Map<String, Object> arg0) {
	this.request=arg0;
}
@Override
public void prepare() throws Exception {
	System.out.println("prepare...");
}
@Override
public Employee getModel() {
	return employee;
}

}
