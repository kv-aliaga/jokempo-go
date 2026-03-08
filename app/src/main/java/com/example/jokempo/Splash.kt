package com.example.jokempo

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        Capturando variáveis
        val joTxt = findViewById<TextView>(R.id.joTxt)
        val kenTxt = findViewById<TextView>(R.id.kenTxt)
        val poTxt = findViewById<TextView>(R.id.poTxt)
        val goTxt = findViewById<TextView>(R.id.goTxt)

//        Seta o que o programa precisa fazer ao iniciar
        lifecycleScope.launch {
            joTxt.text = "JO"
            delay(700)

            kenTxt.text = "KEN"
            delay(500)

            poTxt.text = "PÔ"
            delay(500)

            goTxt.text = "GO!"

//            vai de Splash.kt para MainActivity.kt (parse em java)
            val rota = Intent(this@Splash, MainActivity::class.java)
            startActivity(rota)
            finish()
        }
    }
}