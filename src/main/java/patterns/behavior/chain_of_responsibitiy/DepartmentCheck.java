package patterns.behavior.chain_of_responsibitiy;

public class DepartmentCheck extends AccessCheck {
    @Override
    protected boolean doCheck(String usrename) {
        System.out.print("Department check for " + usrename);
        if (Employees.checkEmployeeDepartment(usrename)){
            System.out.println(" PASSED");
            return checkNextElement(usrename);
        }
        System.out.println(" FAIL");
        return false;
    }
}
