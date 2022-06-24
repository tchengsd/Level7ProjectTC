package org.jointheleague.api.unisearch.repository.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "domains",
        "web_pages",
        "state-province",
        "name",
        "country",
        "alpha_two_code"
})
@Generated("jsonschema2pojo")
public class Result {

    @JsonProperty("state-province")
    private Object stateProvince;
    @JsonProperty("name")
    private String name;
    @JsonProperty("country")
    private String country;

    @JsonProperty("state-province")
    public Object getStateProvince() {
        return stateProvince;
    }

    @JsonProperty("state-province")
    public void setStateProvince(Object stateProvince) {
        this.stateProvince = stateProvince;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }
}