package org.generation.delhaz.dto;

public class Login {
    private String email;
    private String password;

    // Constructor vacío
    public Login() {
    }

    // Constructor con parámetros
    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters y setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Método toString para facilitar el debugging
    @Override
    public String toString() {
        return "Login{" +
               "email=" + email + '\'' +
               ", password='[PROTECTED]'" + '}';
    }
}