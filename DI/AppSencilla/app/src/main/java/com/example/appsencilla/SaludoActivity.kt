package com.example.appsencilla

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SaludoActivity : AppCompatActivity() {
    private lateinit var txtSaludo : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saludo)

        //Obtenemos una referencia a los controles de la interfaz
        txtSaludo = findViewById(R.id.txtSaludo)
        //Recuperamos la información pasada en el intent
        val nombre = intent.getStringExtra("NOMBRE")
        val pass = intent.getStringExtra("PASS")
        val visibility = intent.getBooleanExtra("ISVISIBLE", false)
        //Construimos el mensaje a mostrar
        if (!visibility) {
            txtSaludo.text = "Hola $nombre, tu contraseña es $pass"
        } else {
            txtSaludo.text = "Hola $nombre, tu contraseña es $pass, has mostrado la imagen"
        }
    }
}