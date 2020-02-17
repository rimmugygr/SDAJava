package jvm.money;

public enum CurrencyVersion2 {


    PLN("Poland, Zloty", 2, "# ###,##", new IsoCode("PLN", 985), new UnitName("zloty", "grosz")),
    USD("US Dollar", 2, "#,###.##", new IsoCode("USD", 840), new UnitName("dollar", "cent")),
    EUR("Euro", 2, "#,###.##", new IsoCode("EUR", 978), new UnitName("euro", "cent"));

    private final String currencyName;
    private final IsoCode isoCodes;
    private final UnitName unitName;
    private final int decimal;
    private final String display;

    CurrencyVersion2(String currencyName, int decimal, String display, IsoCode isoCodes, UnitName unitName) {
        this.currencyName = currencyName;
        this.isoCodes = isoCodes;
        this.unitName = unitName;
        this.decimal = decimal;
        this.display = display;
    }


    private static class IsoCode {
        private final String alpha;
        private final int numeric;

        private IsoCode(String alpha, int numeric) {
            this.alpha = alpha;
            this.numeric = numeric;
        }
    }

    private static class UnitName {
        private final String major;
        private final String minor;

        private UnitName(String major, String minor) {
            this.major = major;
            this.minor = minor;
        }
    }
}
