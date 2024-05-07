package com.example.urbandrive;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.urbandrive.databinding.RegisterMainBinding;

public class RegisterActivity extends AppCompatActivity {
    private RegisterMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = RegisterMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //  binding.textViewUsername.setText("Nome de usuário");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.register_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.request) {
            Intent mainIntent = new Intent(this, MainActivity.class);
            startActivity(mainIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
