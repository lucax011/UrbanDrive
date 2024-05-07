package com.example.urbandrive;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.urbandrive.databinding.RegisterMainBinding;

public class RegisterActivity extends Activity {
    private RegisterMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = RegisterMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //  binding.textViewUsername.setText("Nome de usuário");
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.login) {
            Intent loginIntent = new Intent(this, LoginActivity.class);
            startActivity(loginIntent);
            return true;
        } else if (id == R.id.register) {
            Intent registerIntent = new Intent(this, RegisterActivity.class);
            startActivity(registerIntent);
            return true;
        } else if (id == R.id.request) {
            Intent mainIntent = new Intent(this, MainActivity.class);
            startActivity(mainIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
