package service;

import entry.Dept;
import entry.Employee;
import entry.Role;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * Created by Богдан on 21.02.2018.
 */
public class Domain {

    public static void main(String[] args) throws SQLException, ParseException {

        Domain domain = new Domain();
        //EmployeeService employeeService = new EmployeeService();

//   DeptService deptService = new DeptService();
//       Boolean bol = deptService.delete(1110320182238102254L);
//        System.out.println("Delete "+bol);

//        domain.addDept("ACCOUNTING","NEW YORK");
//        domain.addDept("RESEARCH","DALLAS");
//        domain.addDept("SALES","CHICAGO");
//        boolean res = domain.addDept("OP","BOSTON");
//        System.out.println(res);
   //    domain.getDept(1110320182238101458L);

   //     domain.addEmployee("PETR", 1000, "1999/02/25",1120320180033154538L);
//        domain.addEmployee("Vasya", 12000, "25/11/2010",1120320180033154538L);
    //   domain.getEmployee(1120320180010551025L);

//        Boolean bol = employeeService.deleteEmployee(1120320180012561973L);
//        System.out.println("Delete "+bol);

        //ROLE
        RoleService roleDAO = new RoleService();
        Role role = roleDAO.get(4321);
        System.out.println(role);

        //DEPT CRUD
        DeptService deptService = new DeptService();


        Dept dept = new Dept("1-st","UA");
//      System.out.println(deptService.delete(1230320182224085264L, role.getWrite()));
//        System.out.println(deptService.get(1230320180056579405L, role.getRead()));
//        System.out.println(deptService.create(dept,role.getWrite()));

    //Employee CRUD
        EmployeeService employeeService = new EmployeeService();
      //  System.out.println(domain.addEmployee("PETR", 1000, "1999/02/25",1120320180033154538L, role.getWrite()));
      //  System.out.println(employeeService.get(1240320180622445703L, 0));
      //  System.out.println(employeeService.delete(1120320180034295839L, 0));


    }

    private boolean addEmployee(String name, Integer sall, String date1, Long deptNo, Integer write)
            throws SQLException, ParseException {
        boolean reslt = false;

        SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy") ;
        java.util.Date convDate = sdf.parse(date1);
        java.sql.Date convSQLDate = new java.sql.Date(convDate.getTime());

        EmployeeService employeeService = new EmployeeService();

        Employee employee = new Employee(name, sall, convSQLDate, deptNo);
        reslt = employeeService.create(employee, write);
        System.out.println(employee);
        return reslt;
    }

    }

//        Calendar calendar = Calendar.getInstance();
//        calendar.set(1994, 1,11);
//
//        EmployeeService employeeService = new EmployeeService();
//
//        Employee employee = new Employee();
//        employee.setName("Bogdan");
//        employee.setSalary(20000);
//        employee.setDate(new java.sql.Date(calendar.getTime().getTime()));
//        employee.setDeptNo(12345678L);
//
//        employeeService.addEmp(employee);
//        System.out.println(employee);

//        Employee employee = employeeService.getEmp(1080320182037210445L);
//        System.out.println(employee);


