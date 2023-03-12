package com.ukn.edu.louvreguide;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Calendar;

public class GuideActivity extends AppCompatActivity {
    Button btnName;
    Button btnDate;
    Spinner spnLanguage;

    Button btnSignup;
    String selectLanguage = "English";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        btnName = findViewById(R.id.btn_name);
        btnDate = findViewById(R.id.btn_date);
        spnLanguage = findViewById(R.id.spn_language);
        btnSignup = findViewById(R.id.btn_signup);

        btnName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText etName = new EditText(GuideActivity.this);
                AlertDialog.Builder builder = new AlertDialog.Builder(GuideActivity.this);
                builder.setTitle("報名");
                builder.setMessage("請輸入您的名字");
                builder.setView(etName);
                builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        btnName.setText(etName.getText());
                    }
                });

                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.create().show();
            }
        });

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                DatePickerDialog dialog = new DatePickerDialog(
                        GuideActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                btnDate.setText(year + "/" + month + "/" + day);
                            }
                        },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));
                dialog.show();
            }
        });

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.language_array));
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spnLanguage.setAdapter(adapter);
        spnLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    selectLanguage = "English";
                } else {
                    selectLanguage = "中文";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(GuideActivity.this);
                builder.setTitle("報名成功");
                builder.setMessage(btnName.getText() + "!\n" + "謝謝您的報名!\n" + "您的活動日期在:" + btnDate.getText() + "\n選擇的語言為:" + selectLanguage);
                builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.create().show();
            }
        });
    }
}