package jvm.money;

public enum  Currency {
    USD("Dollar",ISOCodes.USD_CODE,UnitNames.USD_NAME,2,"#,###.##"),
    PLN ("Zloty",ISOCodes.PLN_CODE,UnitNames.PLN_NAME,2,"# ###,##"),
    EUR("Euro",ISOCodes.EURO_CODE,UnitNames.EURO_NAME,2,"#,###.##");
    private final String currencyName;
    private final ISOCodes isoCodes;
    private final UnitNames unitNames;
    private final int decimal;
    private final String display;

    Currency(String currencyName, ISOCodes isoCodes, UnitNames unitNames, int decimal, String display) {
        this.currencyName = currencyName;
        this.isoCodes = isoCodes;
        this.unitNames = unitNames;
        this.decimal = decimal;
        this.display = display;
    }

    enum ISOCodes{
        USD_CODE("USD",840),
        PLN_CODE("PLN",985),
        EURO_CODE("EURO",978);
        private final String alfa;
        private final int numeric;

        ISOCodes(String alfa, int numeric) {
            this.alfa = alfa;
            this.numeric = numeric;
        }
    }

    enum UnitNames{
        USD_NAME("dollar","cent"),
        PLN_NAME("zloty","grosz"),
        EURO_NAME("euro","cent");
        private final String major;
        private final String minor;

        UnitNames(String major, String minor) {
            this.major = major;
            this.minor = minor;
        }
    }

}
