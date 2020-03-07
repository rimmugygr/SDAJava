package patterns.structural.proxy;

public class PrivateCompanyNetwork implements CompanyNetwork {
    private String username;

    public PrivateCompanyNetwork(String username) {
        this.username = username;
    }


    @Override
    public void getAccess(String username) {
        System.out.println("Private acces granted to "+ username);
    }
}
