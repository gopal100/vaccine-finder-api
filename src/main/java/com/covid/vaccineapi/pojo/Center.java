package com.covid.vaccineapi.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Center {
    @JsonProperty("center_id")
    public int getCenter_id() {
        return this.center_id;
    }

    public void setCenter_id(int center_id) {
        this.center_id = center_id;
    }

    int center_id;

    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    @JsonProperty("address")
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    String address;

    @JsonProperty("state_name")
    public String getState_name() {
        return this.state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    String state_name;

    @JsonProperty("district_name")
    public String getDistrict_name() {
        return this.district_name;
    }

    public void setDistrict_name(String district_name) {
        this.district_name = district_name;
    }

    String district_name;

    @JsonProperty("block_name")
    public String getBlock_name() {
        return this.block_name;
    }

    public void setBlock_name(String block_name) {
        this.block_name = block_name;
    }

    String block_name;

    @JsonProperty("pincode")
    public int getPincode() {
        return this.pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    int pincode;

    @JsonProperty("lat")
    public int getLat() {
        return this.lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    int lat;

    @JsonProperty("long")
    public int getLongitude() {
        return this.longitude ;
    }

    public void setLongitude(int longitude) {
        this. longitude =longitude ;
    }

    int longitude;

    @JsonProperty("from")
    public String getStartTime() {
        return this.startTime;
    }

    public void setstartTime(String startTime) {
        this.startTime = startTime;
    }

    String startTime;

    @JsonProperty("to")
    public String getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    String endTime;

    @JsonProperty("fee_type")
    public String getFee_type() {
        return this.fee_type;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    String fee_type;

    @JsonProperty("sessions")
    public List<Session> getSessions() {
        return this.sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    List<Session> sessions;

    @JsonProperty("vaccine_fees")
    public List<VaccineFee> getVaccine_fees() {
        return this.vaccine_fees;
    }

    public void setVaccine_fees(List<VaccineFee> vaccine_fees) {
        this.vaccine_fees = vaccine_fees;
    }

    List<VaccineFee> vaccine_fees;
}
