package programowanie1.person_collections_sort;

public abstract class Person implements Driver{
    private String firstName,lastName;
    private int age;
    private Sex sex;
    private boolean drivingLicense;

    public Person(String firstName, String lastName, int age, String sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = Sex.getByShortName(sex);
    }

    public String getName(){
        return this.firstName+" "+this.lastName;
    }

    public Sex getSex() {
        return sex;
    }

    public Person() {
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getShortName() {
        return sex.getShortName();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public boolean isRetired(){
        boolean wynik=false;
        if(this.sex==Sex.MAN&&(this.age>67))
            wynik=true;
        if (this.sex==Sex.WOMAN&&(this.age>65))
            wynik=true;
        return wynik;
    }

    @Override
    public String toString() {
        return "Person " +
                "firstName='" + firstName + '\'' +
                " lastName='" + lastName + '\'' +
                " age=" + age +
                " sex='" + sex + '\'';
    }

    public abstract String getIdentity();

    public boolean isDrivingLicense(){
        return drivingLicense;
    }

}



    /*Napisz klasę Person
        Z polami firstName, lastName typu String,
        Z polem age typu int
        Z polem sex typu String
        Dopisz settery i gettery dla wszystkich pól
        Dopisz metodę public boolean isRetired sprawdzającą czy osoba jest emerytem
        (kobieta powyżej 65 lat, mężczyzna powyżej 67)
        Przeładuj metodę toString aby wyświetlić wszystkie informacje o danej osobie.
        Na kilku przykładach sprawdź działanie klasy.
*/