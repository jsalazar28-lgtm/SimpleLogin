package com.example.simpleloginai

import java.io.Serializable

data class Usuario(
    val nombre: String,
    val login: String,
    val pass: String,
    val email: String
) : Serializable