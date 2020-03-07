package patterns.structural.proxy;

public class PublicCompanyNetwork implements CompanyNetwork {
    private String username;

    public PublicCompanyNetwork(String username) {
        this.username = username;
    }


    @Override
    public void getAccess(String username) {
        System.out.println("Public acces granted to "+ username);
    }
}
