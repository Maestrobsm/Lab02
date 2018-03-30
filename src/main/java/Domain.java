import entry.Dept;
import entry.Employee;
import entry.Entity;
import entry.Role;
import service.DeptService;
import service.EmployeeService;
import service.EntityService;
import service.RoleService;

import java.sql.SQLException;
import java.util.List;

public class Domain {
    public static void main(String[] args) throws SQLException {
        DeptService deptService = new DeptService();
        EmployeeService employeeService = new EmployeeService();

        //ROLE
        RoleService roleDAO = new RoleService();
        Role role = roleDAO.get(4321);
        System.out.println(role);

        //DEPT CRUD
        Dept dept = new Dept("ACCOUNTING","NEW YORK");
//        System.out.println(deptService.create(dept, role.getWrite()));
//        System.out.println(deptService.delete(1300320180439268203L, role.getWrite()));
//        System.out.println(deptService.get(1300320180210230261L, role.getRead()));

        //Employee CRUD
        Employee employee = new Employee("Petya",15000,"2018/03/18",1300320180210230261L);
//         System.out.println(employeeService.get(1300320180429047461L, role.getRead()));
//         System.out.println(employeeService.delete(1300320180238094804L, role.getWrite()));
//         System.out.println(employeeService.create(employee, role.getWrite()));

        //Lazy Download
        lazyDownload("DEPT"); // or "EMPLOYEE"

    }

    private static void lazyDownload(String typeName) throws SQLException {
        EntityService entityService = new EmployeeService();
        List<Entity> resultList = entityService.getAll( typeName, 1);
        for (Entity entity: resultList) {
            System.out.println(entity.getIdObj());
        }
    }
}
