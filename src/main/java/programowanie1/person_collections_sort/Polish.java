package programowanie1.person_collections_sort;

import java.util.Objects;

public class Polish extends Person {
    private String nationality;
    private int children;
    private String identity;
    {
        identity="polish";
    }

    public Polish(String firstName, String lastName, int age, String sex, int children, String pesel) {
        super(firstName, lastName, age, sex);
        this.nationality = "polish";
        this.children = children;
        this.identity = pesel;
    }

    public Polish() {
    }

    public String getNationality() {
        return nationality;
    }


    @Override
    public boolean isRetired() {
        boolean wynik=false;
        if(this.getSex()==Sex.MAN&&(this.getAge()>65))
            wynik=true;
        if (this.getSex()==Sex.WOMAN&&(this.getAge()>60))
            wynik=true;
        return wynik;
    }

    public Boolean enabledKDR(){
        return children>=3;
    }

    @Override
    public String toString() {
        return super.toString()+
                "nationality='" + nationality + '\'' +
                " children=" + children  ;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String pesel){
        this.identity=pesel;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polish polish = (Polish) o;
        return Objects.equals(identity, polish.identity) &&
                Objects.equals(getFirstName()+getLastName(),polish.getFirstName()+polish.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(identity+getFirstName()+getLastName());
    }


    @Override
    public boolean canDriveCar() {
        return getAge()>16&&isDrivingLicense();
    }

    @Override
    public boolean canRace() {
        return getAge()>10;
    }
}
