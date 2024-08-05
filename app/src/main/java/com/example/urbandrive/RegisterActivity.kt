package com.example.urbandrive

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.urbandrive.data.User
import com.example.urbandrive.databinding.RegisterMainBinding
import com.example.urbandrive.ui.UserViewModel

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: RegisterMainBinding
    private val userViewModel: UserViewModel by viewModels() // Usando ViewModel para gerenciamento de dados

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegisterMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Configurando o botão de registro
        binding.loginButton.setOnClickListener {
            val name = binding.edtName.text.toString()
            val email = binding.edtEmail.text.toString()
            
            // Realizar criptografia
            val password = binding.edtSenha.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                val user = User(id = 0, name = name, email = email, password = password)
                userViewModel.registerUser(user)
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        // Observando o LiveData para atualizações
        userViewModel.userLiveData.observe(this, { User ->
            Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()
            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)
        })

        userViewModel.errorLiveData.observe(this, { error ->
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.register_menu, menu)
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
