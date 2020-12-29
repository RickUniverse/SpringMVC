package com.springmvc.dao;

import com.springmvc.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * @author lijichen
 * @date 2020/11/22 - 19:45
 */
@Repository
public class DepartmentDao {

    public List<Department> getDepartments() {
        return Arrays.asList(new Department(1,"部门1"),
                new Department(2,"部门2"),
                new Department(3,"部门3"),
                new Department(4,"部门4"),
                new Department(5,"部门5"),
                new Department(6,"部门6"));
    }

    public Department getDepartmentById(int id) {
        return new Department(id,"部门"+id+"");
    }
}
