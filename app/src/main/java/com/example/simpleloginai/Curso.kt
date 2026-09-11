package com.example.simpleloginai

import java.io.Serializable

data class Curso(
    val titulo: String,
    val descripcion: String,
    val categoria: String,
    val nivelDuracion: String,
    val imagenResId: Int
) : Serializable