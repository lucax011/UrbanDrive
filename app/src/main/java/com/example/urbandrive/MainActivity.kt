package com.example.urbandrive

import LoginActivity
import RegisterActivity
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.urbandrive.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =  ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setSupportActionBar(binding.toolbar) // Define a toolbar como a action bar
        val titleIntroElement = findViewById<TextView>(R.id.title_intro)

        titleIntroElement.text = "Reiventamos o aluguel de carros "

        val textIntroElement = findViewById<TextView>(R.id.text_intro)

        // Texto normal
        val textoNormalIntro = "Aqui na Drive urban, você aluga um carro por algumas\n" +
                "horas, dias ou por quanto tempo precisar!\n" +
                "E o melhor "

        // Texto em negrito
        val textoNegritoIntro = " sem filas e sem papelada, tudo pelo app."

        // Concatenando o texto normal com o texto em negrito
        val textoCompletoIntro = textoNormalIntro + textoNegritoIntro

        // Criando uma SpannableString
        val spannableStringIntro = SpannableString(textoCompletoIntro)

        // Definindo o estilo negrito apenas para a última linha
        spannableStringIntro.setSpan(
            StyleSpan(Typeface.BOLD),
            textoNormalIntro.length,
            textoCompletoIntro.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        // Definindo o texto para o TextView
        textIntroElement.text = spannableStringIntro

        val titleFinalElement = findViewById<TextView>(R.id.title_final)
        titleFinalElement.text = "Alugar um carro agora é fácil!"

        val textFinalElement = findViewById<TextView>(R.id.text_final)

        // Texto normal
        val textoNormalFinal = "Faça a sua reserva e abra o seu carro através do seu celular." +
                "Encontre o estacionamento mais próximo, escolha o carro e a quantidade " +
                "de tempo que quer ficar com ele. "

        // Texto em negrito (última linha)
        val textoNegritoFinal = "Agora é só chegar no local, abrir o seu carro e aproveitar a viagem!"

        // Concatenando o texto normal com o texto em negrito
        val textoCompletoFinal = textoNormalFinal + textoNegritoFinal

        // Criando uma SpannableString
        val spannableStringFinal = SpannableString(textoCompletoFinal)

        // Definindo o estilo negrito apenas para a última linha
        spannableStringFinal.setSpan(
            StyleSpan(Typeface.BOLD),
            textoNormalFinal.length,
            textoCompletoFinal.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        // Definindo o texto para o TextView
        textFinalElement.text = spannableStringFinal

        // Acessando os elementos dentro do CardView
        val textTitle = findViewById<TextView>(R.id.textTitle)
        val textDescription = findViewById<TextView>(R.id.textDescription)

        // Definindo o texto dos elementos
        textTitle.text = "Precisa de um carro agora? "
        textDescription.text = "Encontre o mais próximo de você e alugue na hora!"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.request -> {
                // Redireciona para a tela de solicitação
                // Este trecho de código ainda precisa ser implementado
                Toast.makeText(this, "Feature em desenvolvimento", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.login -> {
                // Redireciona para a tela de login
                val loginIntent = Intent(this, LoginActivity::class.java)
                startActivity(loginIntent)
                return true
            }
            R.id.register -> {
                // Redireciona para a tela de registro
                val registerIntent = Intent(this, RegisterActivity::class.java)
                startActivity(registerIntent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}