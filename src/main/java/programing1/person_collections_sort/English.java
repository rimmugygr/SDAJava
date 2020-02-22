package programing1.person_collections_sort;

import java.util.Objects;

public class English extends Person {
    private String taxNumber;
    private boolean hasGuardian;
    private String nationality;

    static {//blok inicjujacy przy tworzenu klasy(start systemu)
        //....
    }


    {//blok inicjujacy przy tworzeniu obiektu
        this.hasGuardian=false;
        this.nationality="English";
    }


    public English() {
    }

    public English(String firstName, String lastName, int age, String sex, String taxNumber) {
        super(firstName, lastName, age, sex);
        this.taxNumber = taxNumber;
    }


    @Override
    public String getIdentity() {
        return taxNumber;
    }

    @Override
    public boolean canDriveCar() {
        return (getAge()>16&&isDrivingLicense())||(getAge()>14&& hasGuardian);
    }

    @Override
    public boolean canRace() {
        return getAge()>12;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        English english = (English) o;
        return Objects.equals(taxNumber, english.taxNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taxNumber);
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public boolean isHasGuardian() {
        return hasGuardian;
    }

    public void setHasGuardian(boolean hasGuardian) {
        this.hasGuardian = hasGuardian;
    }

    @Override
    public String toString() {
        return super.toString()+
                "taxNumber='" + taxNumber + '\'' +
                " hasGuardian=" + hasGuardian +
                " nationality='" + nationality + '\'' ;
    }
}
