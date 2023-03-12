package com.ukn.edu.louvreguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    public static String loginAccount = "";
    EditText etAccount;
    EditText etPassword;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etAccount = findViewById(R.id.et_account);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = etAccount.getText().toString();
                String password = etPassword.getText().toString();

                if(account.equals("")){
                    Toast.makeText(LoginActivity.this, "請輸入您的帳號", Toast.LENGTH_LONG).show();
                    return;
                }

                if(password.equals("")){
                    Toast.makeText(LoginActivity.this, "請輸入您的密碼", Toast.LENGTH_LONG).show();
                    return;
                }

                loginAccount = account;
                Toast.makeText(LoginActivity.this, "歡迎回來!\n" + account, Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_guide_service){
            Intent goGuide = new Intent(this, GuideActivity.class);
            startActivity(goGuide);
            return true;
        }

        if(id == R.id.action_opinion){
            Intent goOpinion = new Intent(this, OpinionActivity.class);
            startActivity(goOpinion);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}