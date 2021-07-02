package com.example.aulakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class BasketballActivity : AppCompatActivity() {

    private var pontuacaoTimeA: Int = 0
    private var pontuacaoTimeB: Int = 0
    private var ultimaPontuacaoTimeA: Int = 0
    private var ultimaPontuacaoTimeB: Int = 0

    private lateinit var pTimeA: TextView
    private lateinit var pTimeB: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basketball)

        pTimeA = findViewById(R.id.placarTimeA)
        pTimeB = findViewById(R.id.placarTimeB)

        val bTresPontosTimeA: Button = findViewById(R.id.tresPontosA)
        val bDoisPontosTimaA: Button = findViewById(R.id.doisPontosA)
        val bTiroLivreTimeA: Button = findViewById(R.id.tiroLivreA)

        val bTresPontosTimeB: Button = findViewById(R.id.tresPontosB)
        val bDoisPontosTimeB: Button = findViewById(R.id.doisPontosB)
        val bTiroLivreTimeB: Button = findViewById(R.id.tiroLivreB)

        val bRemovePontosTimeA: Button = findViewById(R.id.removePontosTimeA)
        val bRemovePontosTimeB: Button = findViewById(R.id.removePontosTimeB)

        val bReiniciar: Button = findViewById(R.id.reiniciarPartida)


        bTresPontosTimeA.setOnClickListener{ adicionarPontos(3, "A")}
        bDoisPontosTimaA.setOnClickListener { adicionarPontos(2, "A")}
        bTiroLivreTimeA.setOnClickListener{ adicionarPontos(1, "A")}

        bTresPontosTimeB.setOnClickListener { adicionarPontos(3, "B") }
        bDoisPontosTimeB.setOnClickListener { adicionarPontos(2, "B") }
        bTiroLivreTimeB.setOnClickListener { adicionarPontos(1, "B") }

        bRemovePontosTimeA.setOnClickListener { removePontos(ultimaPontuacaoTimeA, "A") }
        bRemovePontosTimeB.setOnClickListener { removePontos(ultimaPontuacaoTimeB, "B") }

        bReiniciar.setOnClickListener { reiniciarPartida() }

    }

    fun adicionarPontos(pontos: Int, time: String){
        if(time == "A") {
            ultimaPontuacaoTimeA = pontos
            pontuacaoTimeA += pontos
        } else {
            ultimaPontuacaoTimeB = pontos
            pontuacaoTimeB += pontos
        }
    atualizaPlacar(time)
    }

    fun removePontos(pontos: Int, time: String){
        if(time == "A" && pontuacaoTimeA == 0){
            Toast.makeText(this, "A pontuação está zerada!", Toast.LENGTH_SHORT).show()
        } else if(time == "B" && pontuacaoTimeB == 0){
            Toast.makeText(this, "A pontuação está zerada!", Toast.LENGTH_SHORT).show()
        }

        if(time == "A" && pontuacaoTimeA != 0){
            pontuacaoTimeA -= pontos
        } else if(time == "B" && pontuacaoTimeB != 0){
            pontuacaoTimeB -= pontos
        }
        atualizaPlacar(time)

    }

    fun atualizaPlacar(time: String){
        if(time == "A"){
            pTimeA.setText(pontuacaoTimeA.toString())
        } else {
            pTimeB.setText(pontuacaoTimeB.toString())
        }
    }

    fun reiniciarPartida(){
        pontuacaoTimeA = 0
        pTimeA.setText(pontuacaoTimeA.toString())
        pontuacaoTimeB = 0
        pTimeB.setText(pontuacaoTimeB.toString())
        Toast.makeText(this, "Placar Reiniciado!", Toast.LENGTH_SHORT).show()
    }
}

