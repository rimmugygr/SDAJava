package patterns.structural.proxy;

import java.util.ArrayList;
import java.util.List;

public class CompanyEmployee {
    private static List<String> employee;

    {
        employee = new ArrayList<>();
    }

    public static List<String> getEmployee() {
        return employee;
    }

    public static void setEmployee(List<String> employee) {
        CompanyEmployee.employee = employee;
    }

    public static boolean isEmploye(String string){
        return employee.contains(string);
    }

}
