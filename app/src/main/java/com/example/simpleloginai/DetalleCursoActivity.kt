package com.example.simpleloginai

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.simpleloginai.databinding.ActivityDetalleCursoBinding

class DetalleCursoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalleCursoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleCursoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recibir los datos pasados por el Intent
        @Suppress("DEPRECATION")
        val curso = intent.getSerializableExtra("EXTRA_CURSO") as? Curso
        @Suppress("DEPRECATION")
        val usuario = intent.getSerializableExtra("EXTRA_USER_OBJ") as? Usuario
        val usuarioString = intent.getStringExtra("EXTRA_USER") ?: "Invitado"

        // Mostrar la información del usuario logueado
        if (usuario != null) {
            binding.tvUserWelcome.text = "Estudiante: ${usuario.nombre} (${usuario.email})"
        } else {
            binding.tvUserWelcome.text = "Estudiante: $usuarioString"
        }

        // Mostrar la información del curso seleccionado
        curso?.let {
            binding.tvDetalleTitulo.text = it.titulo
            binding.btnDetalleCategoria.text = it.categoria
            binding.tvDetalleNivelDuracion.text = it.nivelDuracion
            binding.tvDetalleDescripcion.text = it.descripcion
            binding.ivDetalleThumbnail.setImageResource(it.imagenResId)
        }

        // Funcionalidad para el botón Regresar
        binding.btnRegresar.setOnClickListener {
            finish()
        }
    }
}