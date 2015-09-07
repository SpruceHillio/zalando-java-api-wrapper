package io.sprucehill.zalando.api.model;

/**
 * @author Michael Duergner
 */
public enum Domain {
    DE("","",19,Currency.EUR,SizeChart.EU);

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
