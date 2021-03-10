package edu.ittj.p3.service;

import edu.ittj.p3.domain.*;

import static edu.ittj.p3.service.Data.*;

/**
 * 负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法。
 */
public class NameListService {
    Employee[] employees;

    public NameListService() {
//        1.根据项目提供的Data类构建相应大小的employees数组
//        2.再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Designer和Architect对象，以及相关联的Equipment子类的对象
//        3.将对象存于数组中
        employees = new Employee[EMPLOYEES.length];

        for (int i = 0; i < employees.length; i++) {
            int key = Integer.parseInt(EMPLOYEES[i][0]);
            // 得到前4个元素
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            int salary = Integer.parseInt(EMPLOYEES[i][4]);

            Equipment equipment;
            int bonus;
            switch (key) {
                case EMPLOYEE:
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case PROGRAMMER:
                    equipment = createEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, equipment);
                    break;
                case DESIGNER:
                    equipment = createEquipment(i);
                    bonus = Integer.parseInt(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary, equipment, bonus);
                    break;
                case ARCHITECT:
                    equipment = createEquipment(i);
                    bonus = Integer.parseInt(EMPLOYEES[i][5]);
                    int stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
                    break;
            }
        }
    }

    private Equipment createEquipment(int index) {
        Equipment equipment = null;
        int key = Integer.parseInt(EQUIPMENTS[index][0]);
        String model;
        switch (key) {
            case PC:
                model = EQUIPMENTS[index][1];
                String display = EQUIPMENTS[index][2];
                equipment = new PC(model, display);
                break;
            case NOTEBOOK:
                model = EQUIPMENTS[index][1];
                double price = Double.parseDouble(EQUIPMENTS[index][2]);
                equipment = new NoteBook(model, price);
                break;
            case PRINTER:
                String name = EQUIPMENTS[index][1];
                String type = EQUIPMENTS[index][2];
                equipment = new Printer(name, type);
                break;
        }
        return equipment;
    }

    /**
     * 获取当前所有员工。
     * @return:包含所有员工对象的数组
     */
    public Employee[] getAllEmployees() {
        return employees;
    }

    /**
     * 获取指定ID的员工对象。
     * @param id
     * @return
     */
    public Employee getEmployees(int id) throws TeamException {
        for(int i=0;i<employees.length;i++){
            if(employees[i].getId() == id){
                return employees[i];
            }
        }
        throw new TeamException("找不到指定的员工");
    }
}
