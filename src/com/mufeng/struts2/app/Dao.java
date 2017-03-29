package com.mufeng.struts2.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dao {
private static Map<Integer, Employee> emps=new HashMap<Integer,Employee>();
static{
	emps.put(1001, new Employee(1001, "Tom1", "Li1", "li1@mufeng.com"));
	emps.put(1002, new Employee(1002, "Tom2", "Li2", "li2@mufeng.com"));
	emps.put(1003, new Employee(1003, "Tom3", "Li3", "li3@mufeng.com"));
	emps.put(1004, new Employee(1004, "Tom4", "Li4", "li4@mufeng.com"));
	emps.put(1005, new Employee(1005, "Tom5", "Li5", "li5@mufeng.com"));
	
}
public List<Employee> getEmployees(){
	return new ArrayList<>(emps.values());
}
public void delete(Integer empId){
	emps.remove(empId);
}
public void save(Employee emp){
	long time=System.currentTimeMillis();
	emp.setEmployeeId((int)time);
	emps.put(emp.getEmployeeId(), emp);
}
public Employee get(Integer empId){
	return emps.get(empId);
}
public void update(Employee emp){
	emps.put(emp.getEmployeeId(), emp);
}
}
