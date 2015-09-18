package io.sprucehill.zalando.api.model;

/**
 * @author Michael Duergner
 */
public enum Domain {
    DE("de-DE","www.zalando.de",19,Currency.EUR,SizeChart.EU),
    DK("de-DE","www.zalando.dk",25,Currency.DKK,SizeChart.EU),
    AT("de-DE","www.zalando.at",20,Currency.EUR,SizeChart.EU),
    CH("de-DE","www.zalando.ch",19,Currency.CHF,SizeChart.EU),
    GB("de-DE","www.zalando.co.uk",20,Currency.GBP,SizeChart.UK),
    ES("de-DE","www.zalando.es",21,Currency.EUR,SizeChart.FR),
    FI("de-DE","www.zalando.fi",24,Currency.EUR,SizeChart.EU),
    BE("de-DE","www.zalando.be",21,Currency.EUR,SizeChart.EU),
    FR("de-DE","www.zalando.fr",20,Currency.EUR,SizeChart.FR),
    IT("de-DE","www.zalando.it",22,Currency.EUR,SizeChart.IT),
    NL("de-DE","www.zalando.nl",21,Currency.EUR,SizeChart.EU),
    NO("de-DE","www.zalando.no",25,Currency.NOK,SizeChart.EU),
    PL("de-DE","www.zalando.pl",23,Currency.EUR,SizeChart.EU),
    SE("de-DE","www.zalando.se",25,Currency.SEK,SizeChart.EU),
    LU("de-DE","www.zalando.lu",17,Currency.EUR,SizeChart.EU);

    private String locale;

    private String url;

    private Integer vat;

    private Currency currency;

    private SizeChart sizeChart;

    private Domain(String locale, String url, Integer vat, Currency currency, SizeChart sizeChart) {
        this.locale = locale;
        this.url = url;
        this.vat = vat;
        this.currency = currency;
        this.sizeChart = sizeChart;
    }

    public String getLocale() {
        return locale;
    }

    public String getUrl() {
        return url;
    }

    public Integer getVat() {
        return vat;
    }

    public Currency getCurrency() {
        return currency;
    }

    public SizeChart getSizeChart() {
        return sizeChart;
    }
}
