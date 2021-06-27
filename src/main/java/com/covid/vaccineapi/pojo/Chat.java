package com.covid.vaccineapi.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Chat{
    @JsonProperty("id")
    public int getId() {
        return this.id; }
    public void setId(int id) {
        this.id = id; }
    int id;
    @JsonProperty("first_name")
    public String getFirst_name() {
        return this.first_name; }
    public void setFirst_name(String first_name) {
        this.first_name = first_name; }
    String first_name;
    @JsonProperty("username")
    public String getUsername() {
        return this.username; }
    public void setUsername(String username) {
        this.username = username; }
    String username;
    @JsonProperty("type")
    public String getType() {
        return this.type; }
    public void setType(String type) {
        this.type = type; }
    String type;
}

