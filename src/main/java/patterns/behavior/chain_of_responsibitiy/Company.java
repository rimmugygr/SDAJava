package patterns.behavior.chain_of_responsibitiy;

public class Company {
    private String name;
    private Employees employees;
    private AccessCheck accessCheck;

    public Company(String name) {
        this.name = name;
    }

    public void setCheck(AccessCheck check) {
        this.accessCheck = check;
    }

    public boolean enterRoom(String username){
        if(accessCheck.doCheck(username)){
            System.out.println("Access granted for " + username);
            return true;
        }
        System.out.println("Access dont granted for " + username);
        return false;
    }
}
