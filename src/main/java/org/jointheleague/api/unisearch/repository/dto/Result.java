package org.jointheleague.api.unisearch.repository.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.*;

public class Result {

    private Object stateProvince;
    private String name;
    private String country;

    public Object getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(Object stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
