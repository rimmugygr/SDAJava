package basic.klasyObiekty.zad3;

abstract class Vehicle {
    private Marka marka;

    abstract String getData();

    protected String getMarka() {
        return this.marka.toString();
    }

    protected void setMarka(String marka){
        switch (marka){
            case "BMW":
                this.marka=Marka.BMW;
                break;
            case "FIAT":
                this.marka=Marka.FIAT;
                break;
            case "ROMET":
                this.marka=Marka.ROMET;
                break;
            default:
                this.marka=Marka.NIEOKRESLONA;
        }
    }

    @Override
    public abstract String toString();
}
