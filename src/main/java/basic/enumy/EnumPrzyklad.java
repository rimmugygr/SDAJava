package basic.enumy;
public class EnumPrzyklad {

    public enum Odpowiedz {

        TAK(true),
        NIE(false),
        T(true),
        N(false),
        YES(true),
        NO(false),
        OK(true),
        SURE(true),
        NOPE(false);

        private boolean wartosc;

        private Odpowiedz(boolean wartosc) {
            this.wartosc = wartosc;
        }

        public boolean getWartosc() {
            return wartosc;
        }
    }

    public static void main(String[] args) {

        EnumPrzyklad test = new EnumPrzyklad();
        String[] wartosciUsera = {"tak", "TAK", "OK", "ta", "nie", "niewiem", "NoPe" };

        test.simplePrint("==WEJSCIE==", "==WYJSCIE==");
        test.simplePrint("-----------", "-----------");

        for(String wejscie : wartosciUsera) {

            test.simplePrint(wejscie, test.odpUseraString(wejscie));
        }
    }

    public String odpUseraString(String wejscie) {
        try {
            return odpUsera(wejscie) ? "pozytywna" : "negatywna";
        } catch (Exception e) {
            return "nieznana";
        }
    }

    public boolean odpUsera(String wejscie) throws Exception {
        for(Odpowiedz odp : Odpowiedz.values()) {
            if(odp.toString().equalsIgnoreCase(wejscie))
                return odp.getWartosc();
        }
        throw new Exception();
    }

    private void simplePrint(String one, String two) {
        System.out.printf("%15s  |  %10s\n", one, two);
    }

}