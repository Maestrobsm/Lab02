package service;

import entry.Dept;
import entry.Employee;
import entry.Role;

import java.sql.SQLException;
import java.text.ParseException;


/**
 * Created by Богдан on 21.02.2018.
 */
public class Domain {

    public static void main(String[] args) throws SQLException, ParseException {

        Domain domain = new Domain();
        DeptService deptService = new DeptService();
        EmployeeService employeeService = new EmployeeService();


        //ROLE
        RoleService roleDAO = new RoleService();
        Role role = roleDAO.get(4321);
        System.out.println(role);

        //DEPT CRUD
        Dept dept = new Dept("OPERATIONS","BOSTON");
//        deptService.create(dept, 1);
//        domain.addDept("ACCOUNTING","NEW YORK");
//        domain.addDept("RESEARCH","DALLAS");
//        domain.addDept("SALES","CHICAGO");
//        boolean res = domain.addDept("OPERATIONS","BOSTON");
        //  Dept dept = new Dept("1-st","UA");
//        System.out.println(deptService.delete(1250320180032113225L, role.getWrite()));
//        System.out.println(deptService.get(1230320180056579405L, role.getRead()));
//        System.out.println(deptService.create(dept,role.getWrite()));

        //Employee CRUD
        Employee employee = new Employee("Petya",15000,"2018/03/24",1240320180642278795L);

//         System.out.println(domain.addEmployee("test3", 2000, "2018/03/24", 1240320180642278795L, role.getWrite()));
         System.out.println(employeeService.get(1250320180107483626L, 1));
//         System.out.println(employeeService.delete(1250320180055012069L, 1));
//         System.out.println(employeeService.create(employee, 1));

    }

}



