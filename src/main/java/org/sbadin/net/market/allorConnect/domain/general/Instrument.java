package org.sbadin.net.market.allorConnect.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.sbadin.net.market.allorConnect.domain.Exchange;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Instrument {

    @JsonProperty("symbol")
    private String symbol;

    @JsonProperty("exchange")
    private Exchange exchange;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("symbol", symbol)
                .append("exchange", exchange)
                .toString();
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Exchange getExchange() {
        return exchange;
    }

    public void setExchange(Exchange exchange) {
        this.exchange = exchange;
    }
}
