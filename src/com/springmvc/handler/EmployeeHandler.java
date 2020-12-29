package com.springmvc.handler;

import com.springmvc.dao.DepartmentDao;
import com.springmvc.dao.EmployeeDao;
import com.springmvc.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * @author lijichen
 * @date 2020/11/22 - 19:59
 */
//@SessionAttributes(value = {"employees"})
@Controller
public class EmployeeHandler {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Map<String,Object> map) {
        map.put("employees",employeeDao.getAllEmployee());
        return "forward:/views/company/list.jsp";
    }

    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public String input(Map<String,Object> map) {
        map.put("departments", departmentDao.getDepartments());
        map.put("employee",new Employee());
        return "forward:/views/company/input.jsp";
    }

    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String save(@Valid Employee employee,
                       BindingResult result,
                        Map<String,Object> map) {

        if (result.getErrorCount() > 0) {
            System.out.println("出錯了");
            for (FieldError error : result.getFieldErrors()) {
                System.out.println(error.getField() + ":" + error.getDefaultMessage());
            }
            return "forward:/views/company/input.jsp";
        }
        System.out.println(employee);
        employeeDao.addEmployee(employee);
        return "redirect:/emps";
    }


    //delete
    @RequestMapping(value = "emp/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id) {
        System.out.println("delete method");
        employeeDao.deleteEmployee(id);
        return "redirect:/emps";
    }

    //update
    @RequestMapping("/emp/{id}")
    public String input(@PathVariable Integer id,
                        Map<String,Object> map) {
        map.put("departments", departmentDao.getDepartments());
        map.put("employee",employeeDao.getEmployee(id));
        return "forward:/views/company/input.jsp";
    }

    @ModelAttribute
    public void getEmployee(@RequestParam(value = "id", required = false) Integer id,
                            Map<String, Object> map) {
        if (id != null) {
            map.put("employee",employeeDao.getEmployee(id));
        }
    }

    @RequestMapping(value = "emp/{id}", method = RequestMethod.PUT)
    public String update(@ModelAttribute(value = "employee") Employee employee) {
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employeeDao.updateEmployee(employee);
        return "redirect:/emps";
    }


//    @InitBinder
//    public void intiBinder(WebDataBinder webDataBinder) {
//        webDataBinder.setDisallowedFields("name");
//    }

}
