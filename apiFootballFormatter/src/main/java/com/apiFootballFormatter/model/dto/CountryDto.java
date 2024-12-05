package com.apiFootballFormatter.model.dto;


public class CountryDto {

    private String name;

    private String flag;

    private String code;

    public CountryDto() {
    }

    public CountryDto(String name, String flag, String code) {
        this.name = name;
        this.flag = flag;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
