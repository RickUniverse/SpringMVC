package com.springmvc.converters;

import com.springmvc.pojo.Department;
import com.springmvc.pojo.Employee;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 自定义转换器，将一个字符串转换为employee类型
 * 字符串需要按照此规则：name-gender-departmentid
 *  例如：张三-1-3
 * @author lijichen
 * @date 2020/11/23 - 17:17
 */
@Component(value = "employeeConverter")
public class EmployeeConverter implements Converter<String, Employee> {
    @Override
    public Employee convert(String source) {
        if (source != null) {
            String[] vars = source.split("-");
            if (vars != null && vars.length == 3){
                return new Employee(0,vars[0],
                        Integer.parseInt(vars[1]),
                        new Department(Integer.parseInt(vars[2]),null));
            }
        }
        return null;
    }
}
