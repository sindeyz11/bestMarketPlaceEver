package com.example.project;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotBlank(message = "Введите имя")
    @Pattern(regexp = "^([А-Яа-я\\s]+|[A-Za-z\\s]+)", message = "Неправильное имя")
    @Size(max = 75, message = "Длина имени не должна превышать 75 символов")
    private String username;
    @NotBlank(message = "Введите пароль")
    @Pattern(regexp = "^[a-zA-Z0-9!@#\\$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?`~]{8,100}$", message = "Неправильное имя")
    @Size(max = 75, message = "Длина имени не должна превышать 75 символов")
    private String password;
    private String phone;
    private String email;
    private String role;
}
/*
object Validator {
fun validatePhone(phone: String) {
    require(phone.isNotEmpty()) {
        "Заполните поле номера телефона"
    }
    require(Regex("^(\\+)?((\\d{2,3}) ?\\d|\\d)(([ -]?\\d)|( ?(\\d{2,3}) ?)){5,12}\\d$").matches(phone)) {
        "Неправильный номер телефона"
    }
    require(phone.length <= 20) {
        "Длина номера не должна превышать 20 символов"
    }
}

fun validateEmail(email: String) {
    require(email.isNotEmpty()) {
        "Заполните поле e-mail"
    }
    require(Regex("^[\\w_.]+@([\\w-]+\\.)+[a-zA-Z-]{2,4}\$").matches(email)) {
        "Неправильный e-mail"
    }
    require(email.length <= 50) {
        "Длина e-mail не должна превышать 50 символов"
    }
}

fun validateName(name: String) {
    require(name.isNotEmpty()) {
        "Введите имя"
    }
    require(Regex("^([А-Яа-я\\s]+|[A-Za-z\\s]+)\$").matches(name)) {
        "Неправильное имя"
    }
    require(name.length <= 75) {
        "Длина имени не должна превышать 75 символов"
    }
}

fun validatePassword(password: String) {
    require(password.isNotEmpty()) {
        "Введите пароль"
    }
    require(password.length >= 8){
        "Длина пароля должна быть от 8 символов"
    }
    require(password.length <= 100){
        "Длина пароля не должна превышать 100 символов"
    }
    require(Regex("^[a-zA-Z0-9!@#\$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?`~]{8,100}\$").matches(password)) {
        "Неправильный пароль"
    }
}

fun validateRepeatedPassword(password: String, repeatedPassword: String) {
    validatePassword(repeatedPassword)

    require(password == repeatedPassword) {
        "Пароли не совпадают"
    }*/
