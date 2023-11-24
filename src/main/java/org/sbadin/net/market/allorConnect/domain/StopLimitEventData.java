package org.sbadin.net.market.allorConnect.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StopLimitEventData {
    @JsonProperty("data")
    private StopLimitEvent data;

    @JsonProperty("guid")
    private String guid;

    public StopLimitEvent getData() {
        return data;
    }

    public void setData(StopLimitEvent data) {
        this.data = data;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("data", data)
                .append("guid", guid)
                .toString();
    }

}
