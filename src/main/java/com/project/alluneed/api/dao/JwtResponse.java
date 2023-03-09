package com.project.alluneed.api.dao;

public class JwtResponse {
    private String Jwt;
    private Long id;
    private String name;
    private String email;

    public JwtResponse(String jwt, Long id, String name, String email) {
        Jwt = jwt;
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getJwt() {
        return Jwt;
    }

    public void setJwt(String jwt) {
        Jwt = jwt;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
