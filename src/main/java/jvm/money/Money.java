package jvm.money;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public final class Money {
    private final BigDecimal value;
    public final static BigDecimal ZERO = BigDecimal.ZERO;

    public static Money of(String value){
        return new Money(value);
    }

    public static Money zero(){
        return new Money(ZERO);
    }

    private Money(BigDecimal value) {
        this.value = value;
    }

    private Money(String value) {
        this.value = new BigDecimal(value);
    }

    public Money sum(List<Money> moneys){
        Money temp = new Money(value);
        for (Money money : moneys) {
            temp = money.add(temp);
        }
        return temp;
    }

    public Money sum(Money... moneys){
        Money temp = new Money(value);
        for (Money money : moneys) {
            temp = money.add(temp);
        }
        return temp;
    }

    public Money add(Money money){
        return new Money(this.value.add(money.value));
    }
    public Money substract(Money money){
        return new Money(this.value.subtract(money.value));
    }
    public Money multiply(Money money){
        return new Money(this.value.multiply(money.value));
    }
    public Money divide(Money money){
        if(money.equals(zero())) throw new IllegalArgumentException("nie mozna dzieliæ przez zero");
        return new Money(this.value.divide(money.value));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(value, money.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Money{" +
                "value=" + value +
                '}';
    }
}
