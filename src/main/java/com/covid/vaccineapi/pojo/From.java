package com.covid.vaccineapi.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class From{
    @JsonProperty("id")
    public int getId() {
        return this.id; }
    public void setId(int id) {
        this.id = id; }
    int id;
    @JsonProperty("is_bot")
    public boolean getIs_bot() {
        return this.is_bot; }
    public void setIs_bot(boolean is_bot) {
        this.is_bot = is_bot; }
    boolean is_bot;
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
}
