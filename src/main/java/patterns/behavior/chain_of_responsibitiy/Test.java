package patterns.behavior.chain_of_responsibitiy;

public class Test {
    public static void main(String[] args) {
        Employees employees = new Employees();
        employees.addEmployee("jozef",10,true);
        employees.addEmployee("adolf",23,false);
        employees.addEmployee("staszek",1,false);
        employees.addEmployee("janek",1,true);
        AccessCheck accessCheck0 = new CompanyInsiderCheck();
        AccessCheck accessCheck1 = new CompanySeniorityCheck();
        AccessCheck accessCheck2 = new DepartmentCheck();
        accessCheck0.addChainElement(accessCheck1);
        accessCheck0.addChainElement(accessCheck2);
       // accessCheck1.addChainElement(accessCheck2);

        Company company = new Company("Firma xxx");
        company.setCheck(accessCheck0);

        System.out.println("=============");
        company.enterRoom("jozef");
        System.out.println("=============");
        company.enterRoom("adolf");
        System.out.println("=============");
        company.enterRoom("staszek");
        System.out.println("=============");
        company.enterRoom("janek");
    }
}
