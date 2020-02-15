package programowanie1.bank_file;

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

    public void addClients(List<Client> clients){
        for (Client client : clients) {
            this.addClient(client);
        }

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
        if(client.getNumerAccounts()>0){
            accounts.addAll(client.getListAccounts());
        }
        return client;
    }

    public String addAccount(Client client, String typeAccount) {
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



    public void printClientAccounts(){
//on steam
        this.clients.entrySet().stream()
                .map(x->x.getValue())//steam clients
                .map(Client::getListAccounts)//steam list of accounts
                .flatMap(x->x.stream())//steam accounts
                .forEach(System.out::println);
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
