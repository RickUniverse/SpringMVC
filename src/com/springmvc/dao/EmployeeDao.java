package com.springmvc.dao;

import com.springmvc.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * @author lijichen
 * @date 2020/11/22 - 19:44
 */
@Repository
public class EmployeeDao {

    public static final Map<Integer, Employee> MAP = new HashMap<>();

    private static DepartmentDao departmentDao = new DepartmentDao();

    static {
        MAP.put(1,new Employee(1,"wang1",1,departmentDao.getDepartmentById(1)));
        MAP.put(2,new Employee(2,"wang2",2,departmentDao.getDepartmentById(2)));
        MAP.put(3,new Employee(3,"wang3",1,departmentDao.getDepartmentById(3)));
        MAP.put(4,new Employee(4,"wang4",2,departmentDao.getDepartmentById(4)));
        MAP.put(5,new Employee(5,"wang5",1,departmentDao.getDepartmentById(5)));
        MAP.put(6,new Employee(6,"wang16",2,departmentDao.getDepartmentById(6)));
        MAP.put(7,new Employee(7,"wang7",1,departmentDao.getDepartmentById(7)));
    }

    public List<Employee> getAllEmployee() {
        return new ArrayList<>(MAP.values());
    }

    public boolean deleteEmployee(Integer id) {
        return (MAP.containsKey(id) ? MAP.remove(id) : null) != null;
    }

    public void updateEmployee(Employee employee) {
        MAP.put(employee.getId(),employee);
    }

    public Employee getEmployee(Integer id) {
        return MAP.get(id);
    }

    public void addEmployee(Employee employee) {
        int id = MAP.size() + 1;
        employee.setId(id);
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        MAP.put(id,employee);
    }
}
