package com.ukn.edu.louvreguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class OpinionActivity extends AppCompatActivity {
    Button finishButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opinion);

        finishButton = (Button) findViewById(R.id.btn_finish);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(OpinionActivity.this, "感謝您的填答", Toast.LENGTH_LONG).show();
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

        if(id == R.id.action_login){
            Intent goLogin = new Intent(this, LoginActivity.class);
            startActivity(goLogin);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}