package edu.ittj.p3.junit;

import edu.ittj.p3.domain.Employee;
import edu.ittj.p3.service.NameListService;
import edu.ittj.p3.service.TeamException;
import org.junit.Test;

/**
 * 对NameListService测试
 */
public class NameListServiceTest {
    @Test
    public void testGetAllEmployees(){
        NameListService service = new NameListService();
        Employee[] employees = service.getAllEmployees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);

        }
    }

    @Test
    public void testGetEmployees(){
        NameListService service = new NameListService();
        int id = 109;
        try {
            Employee employees = service.getEmployees(id);
            System.out.println(employees);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
//            e.printStackTrace();
        }
    }
}
