    package com.example.c2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun cadastroScreen(view: View) {
        val cadastro = Intent(this, Cadastro::class.java)

        startActivity(cadastro)
    }

    fun listaScreen(view: View) {
        val lista = Intent(this, Lista::class.java)

        startActivity(lista)
    }
}