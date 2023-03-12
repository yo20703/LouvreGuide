package com.ukn.edu.louvreguide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
}