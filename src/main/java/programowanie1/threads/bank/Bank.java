package programowanie1.threads.bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    private String name;
    private int clientId;
    private Map<Integer,Client> clients;
    private List<Account> accounts;

    public Bank(String name) {
        clientId =0;
        this.name = name;
        this.clients = new HashMap<>();
        accounts = new ArrayList<>();
    }

    private Account getAccount(String accountNumber){
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public boolean payIn(String accountNumber, double value){
        if(getAccount(accountNumber)==null) return false;
        getAccount(accountNumber).payIn(value);
        return true;
    }

    public boolean payOff(String accountNumber, double value){
        if(getAccount(accountNumber)==null) return false;
        if(getAccount(accountNumber).payOff(value)==false) return false;
        return true;
    }

    public Client addClient(Client client) {
        clients.put(clientId++,client);
        return client;
    }

    public String addAccount(Client client, TypeAccount typeAccount) {
        Account account= new Account(typeAccount);
        accounts.add(account);
        return client.addAccount(account);
    }


    public boolean removeClient(Client client){

        if(client.getNumerAccounts()==0 && clients.containsValue(client)){
            clients.remove(client);
            return true;
        }
        return false;
    }

    public String getViewClient(){
        String result="Bank: "+ name + " clients:\n";
        for (Map.Entry<Integer, Client> integerClient : clients.entrySet()) {
            result+="Client number: "+integerClient.getKey()+ " " +integerClient.getValue().getViewAccounts();
        }
        return result;
    }

    public String getViewWithClientSaldo(){
        String result="Bank: "+ name + " clients:\n";
        for (Map.Entry<Integer, Client> integerClient : clients.entrySet()) {
            result+="Client number: "+integerClient.getKey()+ " " +integerClient.getValue().getViewAccountsWithSaldo();
        }
        return result;
    }
    
    public String getViewAccount(){
        String result="Bank: "+ name + " account:\n";
        for (Account account : accounts) {
            result+=account.view();
        }
        return result;
    }

    public String getViewAccountWithSaldo(){
        String result="Bank: "+ name + " account:\n";
        for (Account account : accounts) {
            result+=account.viewWithSaldo();
        }
        return result;
    }

}
