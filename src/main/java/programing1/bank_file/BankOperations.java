package programing1.bank_file;

import programing1.bank_file.domena.Bank;

import java.util.List;
import java.util.Map;

public class BankOperations {
    private Bank bank;

    public BankOperations(Bank bank) {
        this.bank = bank;
    }

    public Client addClient(Client client) {
        bank.getClients().put(bank.getClientIdAndIncrement(),client);
        if(client.getNumerAccounts()>0){
           bank.getAccounts().addAll(client.getListAccounts());
        }
        return client;
    }


    public void addClients(List<Client> clients){
        for (Client client : clients) {
            addClient(client);
        }
    }

    private Account getAccount(String accountNumber){
        for (Account account : bank.getAccounts()) {
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



    public String addAccount(Client client, String typeAccount) {
        Account account= new Account(typeAccount);
        bank.getAccounts().add(account);
        return client.addAccount(account);
    }


    public boolean removeClient(Client client){

        if(client.getNumerAccounts()==0 && bank.getClients().containsValue(client)){
            bank.getClients().remove(client);
            return true;
        }
        return false;
    }



    public void printClientAccounts(){
//on steam
        bank.getClients().entrySet().stream()
                .map(x->x.getValue())//steam clients
                .map(Client::getListAccounts)//steam list of accounts
                .flatMap(x->x.stream())//steam accounts
                .forEach(System.out::println);
    }



    public String getViewClient(){

        String result="Bank: "+ bank.getName() + " clients:\n";
        for (Map.Entry<Integer, Client> integerClient : bank.getClients().entrySet()) {
            result+="Client number: "+integerClient.getKey()+ " " +integerClient.getValue().getViewAccounts();
        }
        return result;
    }

    public String getViewWithClientSaldo(){
        String result="Bank: "+ bank.getName() + " clients:\n";
        for (Map.Entry<Integer, Client> integerClient : bank.getClients().entrySet()) {
            result+="Client number: "+integerClient.getKey()+ " " +integerClient.getValue().getViewAccountsWithSaldo();
        }
        return result;
    }

    public String getViewAccount(){
        String result="Bank: "+ bank.getName() + " account:\n";
        for (Account account : bank.getAccounts()) {
            result+=account.view();
        }
        return result;
    }

    public String getViewAccountWithSaldo(){
        String result="Bank: "+ bank.getName() + " account:\n";
        for (Account account : bank.getAccounts()) {
            result+=account.viewWithSaldo();
        }
        return result;
    }

}
