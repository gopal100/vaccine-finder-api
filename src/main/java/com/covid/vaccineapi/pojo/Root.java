package com.covid.vaccineapi.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Root{
    @JsonProperty("centers")
    public List<Center> getCenters() { 
		 return this.centers; } 
    public void setCenters(List<Center> centers) {
		 this.centers = centers; } 
    List<Center> centers;
}
