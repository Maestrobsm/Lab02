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
        DeptService deptService = new DeptService();
        RoleService roleDAO = new RoleService();
        Role role = roleDAO.get(4321);
        System.out.println(role);



      System.out.println(deptService.delete(1230320182224085264L, role.getWrite()));
        //System.out.println(deptService.get(1230320180056579405L, 0));
       // System.out.println(deptService.create(dept,1));
        //System.out.println(domain.addDept(role.getWrite(), "DepOne", "Ukraine"));





    }

    private void addEmployee(String name, Integer sall, String date1, Long deptNo)
            throws SQLException, ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy") ;
        java.util.Date convDate = sdf.parse(date1);
        java.sql.Date convSQLDate = new java.sql.Date(convDate.getTime());

        EmployeeService employeeService = new EmployeeService();

        Employee employee = new Employee(name, sall, convSQLDate, deptNo);
        employeeService.create(employee);
        System.out.println(employee);
    }


    private void getEmployee (Long id) throws SQLException {
        EmployeeService employeeService = new EmployeeService();
        Employee employee = employeeService.get(id);
        System.out.println(employee);
    }

    private boolean addDept(Integer write, String Name, String loc) {
            DeptService deptService = new DeptService();
            boolean result = false;
            Dept dept = new Dept(Name, loc);

            try {
                result =deptService.create(dept, write);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println(dept);
            return result;
        }

        private void getDept (Integer read, Long id) throws SQLException {
            DeptService deptService = new DeptService();
            Dept dept = deptService.get(id, read);
            System.out.println(dept);
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


