package com.sanjay.loginsignup.service;

import com.sanjay.loginsignup.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    JdbcTemplate template;

    @Override
    public Map<String, Object> registration(Employee emp) {
        Map<String, Object> mapOfResopnse=new HashMap<>();
        try {
            String sql = "INSERT INTO employee (EMPID, FIRSTNAME, LASTNAME,EMAILID,CONTACTNO,ORGANAZATION,PASSWORD) " +
                    "VALUES (?,?,?,?,?,?,?)";
            int status = template.update(sql,emp.getEmpId(),emp.getFirstName(),emp.getLastName(),
                    emp.getEmailId(),emp.getContactNo(),emp.getOrganazation(),emp.getPassword());
            if (status == 1) {
                mapOfResopnse.put("statusCode", 1);
                mapOfResopnse.put("messgae", "Registration Success");
            }
            else
            {
                mapOfResopnse.put("statusCode", 0);
                mapOfResopnse.put("messgae", "Registration Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            mapOfResopnse.put("statusCode", 0);
            mapOfResopnse.put("messgae", "Registration Failed");
        }
        return mapOfResopnse;
    }

    @Override
    public Map<String, Object> login(Employee emp) {
        Map<String, Object> mapOfResopnse=new HashMap<>();
        String sql="select * from employee where empId=?";
        try{
            Map<String, Object> validation = template.queryForMap(sql, emp.getEmpId());
            if(StringUtils.hasText(validation.get("EMAILID").toString())){
                mapOfResopnse.put("statusCode",1);
                mapOfResopnse.put("message","Login Success");
            }
        }catch (Exception e){
            mapOfResopnse.put("statusCode",0);
            mapOfResopnse.put("message","Login Failed");
        }
        return mapOfResopnse;
    }

}
