package com.example.appsencilla

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private lateinit var txtNombre: EditText
    private lateinit var txtPass: EditText
    private lateinit var imagen: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Obtenemos una referencia a los controles de la interfaz
        txtNombre = findViewById(R.id.txtNombre)
        txtPass = findViewById(R.id.editTextTextPassword)
        imagen = findViewById(R.id.imageView)
        imagen.setImageResource(R.drawable.shk)
    }

    fun aceptar(view: View) {
        val intent = Intent(this@MainActivity, SaludoActivity::class.java)
        //Añadimos al intent la información a pasar entre actividades
        intent.putExtra("NOMBRE", txtNombre.text.toString())
        intent.putExtra("PASS", txtPass.text.toString())
        intent.putExtra("ISVISIBLE", checkVisibility())
        //Iniciamos la nueva actividad
        startActivity(intent)
    }

    fun mostrarImagen(view: View) {
        val btnMostrarImagen: Button = findViewById(R.id.btnMostrarImagen)

        if (imagen.visibility == View.INVISIBLE) {
            imagen.visibility = View.VISIBLE
            btnMostrarImagen.text = "Ocultar imagen"
        } else {
            imagen.visibility = View.INVISIBLE
            btnMostrarImagen.text = "Mostrar imagen"
        }
    }

    private fun checkVisibility(): Boolean {
        return imagen.visibility != View.INVISIBLE
    }
}