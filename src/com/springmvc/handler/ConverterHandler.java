package com.springmvc.handler;

import com.springmvc.dao.EmployeeDao;
import com.springmvc.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lijichen
 * @date 2020/11/23 - 17:30
 */
@Controller
public class ConverterHandler {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "/parseStringEmployeeAndSave", method = RequestMethod.POST)
    public String parseStringEmployeeAndSave(@RequestParam("parseString") Employee employee) {
        System.out.println(employee);
        employeeDao.addEmployee(employee);
        return "redirect:/emps";
    }
}
