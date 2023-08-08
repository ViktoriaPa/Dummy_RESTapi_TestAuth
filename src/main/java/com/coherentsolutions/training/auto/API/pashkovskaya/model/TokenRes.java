package com.coherentsolutions.training.auto.API.pashkovskaya.model;

public class TokenRes {
    private String token;
    private static TokenRes instance = new TokenRes();

    private TokenRes() {
    }

    public static TokenRes getInstance() {
        return TokenRes.instance;
    }

    public String getToken(){
        return token;
    }

    public void setToken(String token){
        this.token = token;
    }
}