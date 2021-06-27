package com.covid.vaccineapi.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SendMessage {
    @JsonProperty("ok")
    public boolean getOk() {
        return this.ok; }
    public void setOk(boolean ok) {
        this.ok = ok; }
    boolean ok;
    @JsonProperty("result")
    public Result getResult() {
        return this.result; }
    public void setResult(Result result) {
        this.result = result; }
    Result result;
}
