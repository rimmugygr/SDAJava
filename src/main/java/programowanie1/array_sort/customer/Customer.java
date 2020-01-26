package programowanie1.array_sort.customer;
/**
 Klasa Customer implementuje interfejs Comparable
 Słuzy do poruwnywania obiektow klasy Customer po polu amount malejaco
 */
public class Customer implements Comparable<Customer>{
    private Double amount;
    private String name;
    public Customer(String firstName, String secondName, double amount) {
        // korzystamy ze stringbulidera bo jednowatkowy ten program
        // stringbulider szybszy
        StringBuilder fullName = new StringBuilder("Pan/Pani ");//tworzymy obiekt
        fullName.append(firstName);// dodajemy kolejne stringi
        fullName.append(" ");
        fullName.append(secondName);
        this.name = fullName.toString();//metoda toString zwracamy calosc
        this.amount = amount;
    }


    @Override
    public String toString() {
        // stringbuffer wielowatkowy i wolniejszy
        return new StringBuffer(name).append(" ma kwote: ").append(amount).toString();
    }

    public double getAmount() {
        return amount;
    }



    @Override
    public int compareTo(Customer customer) {//poruwnywanie obiektow po
       return - amount.compareTo(customer.amount);
    }
}
