package com.Fresh.ProyectoFormativo.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LoginModel {
    private String email;
    private String password;
}
