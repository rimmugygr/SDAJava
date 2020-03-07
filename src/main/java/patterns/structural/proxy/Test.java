package patterns.structural.proxy;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> employee = Arrays.asList("adolf","jozef");
        CompanyEmployee.setEmployee(employee);
        ProxyCompanyNetworkAccess proxyCompanyNetworkAccess = new ProxyCompanyNetworkAccess();
        proxyCompanyNetworkAccess.getAccess("jozef");
        proxyCompanyNetworkAccess.getAccess("wiktor");
    }
}
