package org.sbadin.net.market.allorConnect.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.sbadin.net.market.allorConnect.domain.Exchange;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @JsonProperty("portfolio")
    private String portfolio;

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("portfolio", portfolio)
                .toString();
    }




}
