package com.covid.vaccineapi.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result{
    @JsonProperty("message_id")
    public int getMessage_id() {
        return this.message_id; }
    public void setMessage_id(int message_id) {
        this.message_id = message_id; }
    int message_id;
    @JsonProperty("from")
    public From getFrom() {
        return this.from; }
    public void setFrom(From from) {
        this.from = from; }
    From from;
    @JsonProperty("chat")
    public Chat getChat() {
        return this.chat; }
    public void setChat(Chat chat) {
        this.chat = chat; }
    Chat chat;
    @JsonProperty("date")
    public int getDate() {
        return this.date; }
    public void setDate(int date) {
        this.date = date; }
    int date;
    @JsonProperty("text")
    public String getText() {
        return this.text; }
    public void setText(String text) {
        this.text = text; }
    String text;
}

