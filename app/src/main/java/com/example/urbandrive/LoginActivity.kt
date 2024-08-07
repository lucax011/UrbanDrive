package com.example.urbandrive

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.urbandrive.databinding.LoginMainBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: LoginMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        // binding.textViewUsername.text = "Nome de usuário"
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
