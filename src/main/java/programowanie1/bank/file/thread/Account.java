package programowanie1.bank.file.thread;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Account {
    private TypeAccount type;
    private BigDecimal balance;
    private List<BigDecimal> saldo;
    private String accountNumber;
    private static int accountCount=0;

    public Account(String type) {
        this.type = TypeAccount.getByName(type);
        this.balance =  new BigDecimal(String.valueOf(BigDecimal.ZERO));
        this.saldo = new LinkedList<>();
        this.accountNumber= String.valueOf(accountCount++);
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public List<BigDecimal> getSaldo() {
        return saldo;
    }

    public TypeAccount getType() {
        return type;
    }

    public void payIn(double value){
          this.balance=balance.add(BigDecimal.valueOf(value));
        saldo.add(BigDecimal.valueOf(value));
    }
    public boolean payOff(double value){
        if(BigDecimal.valueOf(value).compareTo(balance)>=0){
            System.out.println("brak środków na koncie");
            return false;
        }
        this.balance=balance.add(BigDecimal.valueOf(value).negate());
        saldo.add(BigDecimal.valueOf(value).negate());
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountNumber, account.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }

    public String view(){
        return "Account number: "+accountNumber + " typ:" + type + " balance:" + balance + "\n";
    }
    public String viewWithSaldo(){
        String result= "Account number: "+accountNumber + " typ:" + type + " balance:" + balance + "\n";
        result+="saldo:";
        for (BigDecimal bigDecimal : saldo) {
            result+=bigDecimal+" ";
        }
        result+="\n";
        return result;
    }
}
