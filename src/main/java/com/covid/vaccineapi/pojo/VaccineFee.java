package com.covid.vaccineapi.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VaccineFee{
    @JsonProperty("vaccine") 
    public String getVaccine() { 
		 return this.vaccine; } 
    public void setVaccine(String vaccine) { 
		 this.vaccine = vaccine; } 
    String vaccine;
    @JsonProperty("fee")
    public String getFee() { 
		 return this.fee; } 
    public void setFee(String fee) { 
		 this.fee = fee; } 
    String fee;
}
