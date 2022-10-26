package com.example.appsencilla

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SaludoActivity : AppCompatActivity() {
    private lateinit var txtSaludo : TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saludo)

        //Obtenemos una referencia a los controles de la interfaz
        txtSaludo = findViewById(R.id.txtSaludo)
        //Recuperamos la información pasada en el intent
        val nombre = intent.getStringExtra("NOMBRE")
        val pass = intent.getStringExtra("PASS")
        //Construimos el mensaje a mostrar
        txtSaludo.text = "Hola $nombre, tu password es $pass"
    }
}