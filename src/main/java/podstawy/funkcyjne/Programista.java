package podstawy.funkcyjne;

import java.util.Optional;

public class Programista {
    private String jezyk;
    public String podajGlownyJezyk() {
        return this.jezyk;
    }
    public Optional podajGlownyJezykOpt() {
        return Optional.ofNullable(this.jezyk);
    }
    public void ustawGlownyJezyk(String jezyk) {
        this.jezyk = jezyk;
    }

}
