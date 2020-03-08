package patterns.behavior.chain_of_responsibitiy;

public class CompanySeniorityCheck extends AccessCheck {
    @Override
    protected boolean doCheck(String usrename) {
        System.out.print("Company Seniority check for " + usrename);
        if (Employees.checkEmployeeLevel(usrename)>10){
            System.out.println(" PASSED");
            return checkNextElement(usrename);
        }
        System.out.println(" FAIL");
        return false;
    }
}
