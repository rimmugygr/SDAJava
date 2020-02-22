package basic.enumy;

public enum Gender {
    MENZCZYZNA(true),
    MEN(true),
    M(true),
    T(true),
    WOMEN(false),
    KOBIETA(false),
    K(false);
    private boolean genderMen;

    Gender(boolean gender) {
        this.genderMen = gender;
    }

    public boolean isGenderMen() {
        return genderMen;
    }

    static public boolean isGenderMenorWonem(String wejscie) throws Exception {
        for(Gender odp : Gender.values()) {
            if(odp.toString().equalsIgnoreCase(wejscie))
                return odp.isGenderMen();
        }
        throw new Exception();//zwraca wyjatek
        //return null; ze zwrotem nulla
    }
}
