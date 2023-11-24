package org.sbadin.net.market.allorConnect.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderBookData {

    @JsonProperty("bids")
    private List<OrderBookElement> bids;

    @JsonProperty("asks")
    private List<OrderBookElement> asks;

    @JsonProperty("ms_timestamp")
    private Long ms_timestamp;

    @JsonProperty("existing")
    private Boolean existing;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("bids", bids)
                .append("asks", asks)
                .append("ms_timestamp", ms_timestamp)
                .append("existing", existing)
                .toString();
    }

    public List<OrderBookElement> getBids() {
        return bids;
    }

    public void setBids(List<OrderBookElement> bids) {
        this.bids = bids;
    }

    public List<OrderBookElement> getAsks() {
        return asks;
    }

    public void setAsks(List<OrderBookElement> asks) {
        this.asks = asks;
    }

    public Long getMs_timestamp() {
        return ms_timestamp;
    }

    public void setMs_timestamp(Long ms_timestamp) {
        this.ms_timestamp = ms_timestamp;
    }

    public Boolean getExisting() {
        return existing;
    }

    public void setExisting(Boolean existing) {
        this.existing = existing;
    }
}
