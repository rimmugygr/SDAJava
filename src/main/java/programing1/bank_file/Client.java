package programing1.bank_file;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client {
    private String firstName;
    private String lastName;
    private String pesel;
    List<Account> bills;

    public Client(String firstName, String lastName, String pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        bills=new ArrayList<>();
    }

    public String addAccount(Account account){
        bills.add(account);
        return account.getAccountNumber();
    }


    public List<Account> removeAccount(){
        List<Account> temp = new ArrayList<>();
        for (Account account : bills) {
            if (account.getBalance().equals("0")) {
                bills.remove(account);
                temp.add(account);
            }
        }
        return temp;
    }

    public int getNumerAccounts(){
        return bills.size();
    }

    public String getViewAccounts(){
        String result;
        result="Client: "+firstName+" "+lastName+" "+pesel+" accounts:\n";
        for (Account account : bills) {
            result+=account.view();
        }
        return result;
    }

    public String getViewAccountsWithSaldo(){
        String result;
        result="Client: "+firstName+" "+lastName+" "+pesel+" accounts:\n";
        for (Account account : bills) {
            result+=account.viewWithSaldo();
        }
        return result;
    }

    public List<Account> getListAccounts(){
        return bills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(pesel, client.pesel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pesel);
    }
}
