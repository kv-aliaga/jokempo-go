package com.example.jokempo

import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Capturando variáveis
        val framePedra = findViewById<FrameLayout>(R.id.framePedra)
        val framePapel = findViewById<FrameLayout>(R.id.framePapel)
        val frameTesoura = findViewById<FrameLayout>(R.id.frameTesoura)

        val imgPedra = findViewById<ImageView>(R.id.imgPedra)
        val imgPapel = findViewById<ImageView>(R.id.imgPapel)
        val imgTesoura = findViewById<ImageView>(R.id.imgTesoura)
        val imgOraculo = findViewById<ImageView>(R.id.oraculoImg)

        val btnJogar = findViewById<Button>(R.id.btnJogar)
        val resultado = findViewById<TextView>(R.id.resultado)
        val placarUsuario = findViewById<TextView>(R.id.placarUsuario)
        val placarComputador = findViewById<TextView>(R.id.placarComputador)

        // Criando variáveis
        var escolha = 0

        fun limparSelecao(){
            framePedra.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent))
            framePapel.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent))
            frameTesoura.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent))
            escolha = 0
        }

        imgPedra.setOnClickListener {
            limparSelecao()
            framePedra.setBackgroundColor(ContextCompat.getColor(this, R.color.gray))
            escolha = 1
        }

        imgPapel.setOnClickListener {
            limparSelecao()
            framePapel.setBackgroundColor(ContextCompat.getColor(this, R.color.gray))
            escolha = 2
        }

        imgTesoura.setOnClickListener {
            limparSelecao()
            frameTesoura.setBackgroundColor(ContextCompat.getColor(this, R.color.gray))
            escolha = 3
        }

        btnJogar.setOnClickListener {
            val escolhaComputador = Random.nextInt(1, 4)
            val placarUsuarioAtual = placarUsuario.text.toString().toInt()
            val placarComputadorAtual = placarComputador.text.toString().toInt()

            when (escolhaComputador){
                1 -> imgOraculo.setImageResource(R.drawable.pedra)
                2 -> imgOraculo.setImageResource(R.drawable.papel)
                3 -> imgOraculo.setImageResource(R.drawable.tesoura)
                else -> imgOraculo.setImageResource(R.drawable.padrao)
            }

            if (escolha == escolhaComputador) {
                resultado.setTextColor(ContextCompat.getColor(this ,R.color.yellow))
                resultado.text = "Empate!"
            }

            else if (escolha == 1 && escolhaComputador == 2 || escolha == 2 && escolhaComputador == 3 || escolha == 3 && escolhaComputador == 1) {
                resultado.setTextColor(ContextCompat.getColor(this, R.color.red))
                resultado.text = "Você perdeu!"
                placarComputador.text = (placarComputadorAtual + 1).toString()
            }

            else if (escolha == 1 && escolhaComputador == 3 || escolha == 2 && escolhaComputador == 1 || escolha == 3 && escolhaComputador == 2) {
                resultado.setTextColor(ContextCompat.getColor(this, R.color.green))
                resultado.text = "Você venceu!"
                placarUsuario.text = (placarUsuarioAtual + 1).toString()
            }

            else resultado.text = "Você não escolheu nada!"
        }
    }


}