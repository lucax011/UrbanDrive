package com.example.urbandrive

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.urbandrive.data.LoginRequest
import com.example.urbandrive.databinding.LoginMainBinding
import com.example.urbandrive.ui.UserViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: LoginMainBinding
    private lateinit var userViewModel: UserViewModel // Certifique-se de que o ViewModel esteja inicializado corretamente

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Configurando o botão de login
        binding.loginButton.setOnClickListener {
            val email = binding.edtEmail.text.toString()
            val password = binding.edtSenha.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                val loginRequest = LoginRequest(email = email, password = password)
                userViewModel.loginUser(loginRequest)
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        // Observando LiveData do ViewModel
        userViewModel.userLiveData.observe(this, { user ->
            // Navegar para a próxima atividade após o login bem-sucedido
            if (user != null) {
                val mainIntent = Intent(this, MainActivity::class.java)
                startActivity(mainIntent)
                finish() // Opcional: para remover a LoginActivity da pilha de atividades
            }
        })

        userViewModel.errorLiveData.observe(this, { errorMessage ->
            // Mostrar mensagem de erro
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.login_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.request) {
            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
