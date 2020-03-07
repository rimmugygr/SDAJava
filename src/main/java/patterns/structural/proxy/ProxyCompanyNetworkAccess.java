package patterns.structural.proxy;

public class ProxyCompanyNetworkAccess implements CompanyNetwork {
    CompanyNetwork companyNetwork;

    private boolean isEmployee(String username){
        return CompanyEmployee.isEmploye(username);
    }


    @Override
    public void getAccess(String username) {
        if(isEmployee(username)){
            companyNetwork = new PrivateCompanyNetwork(username);
        } else {
            companyNetwork = new PublicCompanyNetwork(username);
        }
        companyNetwork.getAccess(username);
    }
}
