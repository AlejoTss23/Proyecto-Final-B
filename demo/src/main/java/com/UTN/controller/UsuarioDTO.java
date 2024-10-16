package com.UTN.controller;

public class UsuarioDTO {
    private Long id;
    private String username;
    private String role;

    public UsuarioDTO(Long id, String role, String username) {
        this.id = id;
        this.role = role;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
