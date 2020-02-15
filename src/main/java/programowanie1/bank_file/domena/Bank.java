package programowanie1.bank_file.domena;

import programowanie1.bank_file.Account;
import programowanie1.bank_file.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    private String name;
    private int clientId;
    private Map<Integer, Client> clients;
    private List<Account> accounts;

    public Bank(String name) {
        clientId =0;
        this.name = name;
        this.clients = new HashMap<>();
        accounts = new ArrayList<>();
    }

    public int getClientIdAndIncrement() {
        return clientId++;
    }

    public Map<Integer, Client> getClients() {
        return clients;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public String getName() {
        return name;
    }
}
