package patterns.behavior.chain_of_responsibitiy;

public class CompanyInsiderCheck extends AccessCheck {
    @Override
    protected boolean doCheck(String usrename) {
        System.out.print("Company Insider check for " + usrename);
        if (Employees.checkEmployee(usrename)){
            System.out.println(" PASSED");
            return checkNextElement(usrename);
        }
        System.out.println(" FAIL");
        return false;
    }
}
