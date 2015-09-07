package io.sprucehill.zalando.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * @author Michael Duergner
 */
public class Price extends Base {

    @JsonProperty
    Currency currency;

    @JsonProperty
    BigDecimal value;

    @JsonProperty
    String formatted;

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getFormatted() {
        return formatted;
    }
}
