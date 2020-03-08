package patterns.behavior.chain_of_responsibitiy;

import com.mysql.cj.util.DnsSrv;

import java.util.HashMap;
import java.util.Map;

public class Employees {
    private static Map<String,Employee> companyEmployee;

    public Employees() {
        this.companyEmployee = new HashMap<>();
    }

    public static Map<String, Employee> getCompanyEmployee() {
        return companyEmployee;
    }

    public boolean addEmployee(String employee, int level, boolean department) {
        companyEmployee.put(employee,new Employee(employee,level,department));
        return true;
    }

    public static boolean checkEmployee(String userName){
        return companyEmployee.keySet().contains(userName);
    }

    public static Integer checkEmployeeLevel(String userName){
        return companyEmployee.get(userName).getLevel();
    }

    public static boolean checkEmployeeDepartment(String userName){
        return companyEmployee.get(userName).isDepartment();
    }
}
