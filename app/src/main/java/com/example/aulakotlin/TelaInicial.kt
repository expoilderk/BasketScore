package com.example.aulakotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class TelaInicial : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

    }

    fun botaoBasquete(view: View){
        val intent = Intent(this, BasketballActivity::class.java)
        startActivity(intent)
    }

}
