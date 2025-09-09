package com.example.demo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class FeedbackForm {

    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 30, message = "Имя должно быть от 2 до 30 символов")
    private String name;

    @NotEmpty(message = "Email не должен быть пустым")
    @Email(message = "Неверный формат email")
    private String email;

    @NotEmpty(message = "Сообщение не должно быть пустым")
    @Size(min = 10, max = 300, message = "Сообщение должно быть от 10 до 300 символов")
    private String message;

    // Геттеры и сеттеры
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
