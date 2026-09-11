package com.example.simpleloginai

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.simpleloginai.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Usuario fijo definido con la estructura de la clase Usuario
    private val usuarioFijo = Usuario(
        nombre = "Paola Salazar",
        login = "paola",
        pass = "1234",
        email = "paola.salazar@example.com"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Configuración de ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Funcionalidad del botón Login
        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            // Validación de credenciales contra el usuario fijo
            if (username == usuarioFijo.login && password == usuarioFijo.pass) {
                Toast.makeText(this, "ingresaste las credenciales correctas", Toast.LENGTH_SHORT).show()
                
                // Navegar a CursosActivity pasando tanto el string como el objeto Usuario completo
                val intent = Intent(this, CursosActivity::class.java).apply {
                    putExtra("EXTRA_USER", usuarioFijo.nombre)
                    putExtra("EXTRA_USER_OBJ", usuarioFijo)
                }
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Credenciales incorrectas o campos vacíos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}