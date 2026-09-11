package com.example.simpleloginai

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simpleloginai.databinding.ActivityCursosBinding

class CursosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCursosBinding
    private var usuarioLogueado: String = ""
    private var usuarioObjeto: Usuario? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCursosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtener el usuario logueado de los extras
        usuarioLogueado = intent.getStringExtra("EXTRA_USER") ?: "Invitado"
        @Suppress("DEPRECATION")
        usuarioObjeto = intent.getSerializableExtra("EXTRA_USER_OBJ") as? Usuario

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val listaCursos = listOf(
            Curso(
                titulo = "Desarrollo Web Fullstack",
                descripcion = "Aprende HTML, CSS, JavaScript, Node.js y bases de datos desde cero.",
                categoria = "Programación Web",
                nivelDuracion = "Principiante | Duración: 12 hrs",
                imagenResId = R.drawable.ic_course_placeholder
            ),
            Curso(
                titulo = "Mobile App con Kotlin",
                descripcion = "Crea aplicaciones móviles Android nativas y modernas usando Kotlin y Jetpack Compose.",
                categoria = "Desarrollo Móvil",
                nivelDuracion = "Intermedio | Duración: 25 hrs",
                imagenResId = R.drawable.ic_course_placeholder
            ),
            Curso(
                titulo = "Diseño UX/UI",
                descripcion = "Descubre las mejores prácticas de experiencia de usuario y diseño de interfaces con Figma.",
                categoria = "Diseño",
                nivelDuracion = "Principiante | Duración: 15 hrs",
                imagenResId = R.drawable.ic_course_placeholder
            )
        )

        val adapter = CursoAdapter(listaCursos) { curso ->
            val intent = Intent(this, DetalleCursoActivity::class.java).apply {
                putExtra("EXTRA_CURSO", curso)
                putExtra("EXTRA_USER", usuarioLogueado)
                putExtra("EXTRA_USER_OBJ", usuarioObjeto)
            }
            startActivity(intent)
        }

        binding.rvCursos.layoutManager = LinearLayoutManager(this)
        binding.rvCursos.adapter = adapter
    }
}