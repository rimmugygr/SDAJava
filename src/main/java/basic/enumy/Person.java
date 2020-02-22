package basic.enumy;

public enum Person {
    JANUSZ("janusz","lolek",175,true),
    MARTA("marta","sedew",166,false),
    IRENA("irena","sedew",163,false);
    private String firstName;
    private String secondName;
    private int height;
    private boolean gender;


    Person(String firstName, String secondName, int height, boolean gender) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.height = height;
        this.gender = gender;
    }

    public static Person getPerson(String firstName,String secondName)throws Exception{
        for (Person p:Person.values())
            if (p.firstName.equals(firstName)&&p.secondName.equals(secondName))
                return p;
        throw new Exception();
    }

    @Override
    public String toString() {
        return "firstName='" + firstName + '\'' +
                " secondName='" + secondName + '\'' +
                " height=" + height +
                " gender=" + gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

}

