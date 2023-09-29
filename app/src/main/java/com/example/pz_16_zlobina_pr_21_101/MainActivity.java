package com.example.pz_16_zlobina_pr_21_101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnS;
    Button btnL;
    EditText editT;
    String st;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnS = findViewById(R.id.btnSafe);
        btnS.setOnClickListener(this);
        btnL = findViewById(R.id.btnLoad);
        btnL.setOnClickListener(this);
        editT = findViewById(R.id.editT);
        textView = findViewById(R.id.textView);
        loadText();
    }
    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {
            case R.id.btnSafe:
                Toast.makeText(this, "нажата Safe", Toast.LENGTH_SHORT).show();
                saveText();
                break;
            case R.id.btnLoad:
                Toast.makeText(this, "нажата load", Toast.LENGTH_SHORT).show();
                loadText();
                break;
            default:
                break;
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveText();
    }

    public void saveText() {
        SharedPreferences sPref = getPreferences(MODE_PRIVATE); //параметор доступа - данные только внутри приложения
        SharedPreferences.Editor ed = sPref.edit(); // создаем новые настроки управления edit()- метод возвраще
        ed.putString(st, editT.getText().toString()); // в созд. настроки назначем что в st кладем текст из editT
        ed.commit(); // подтверждение изменений
        Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
    }
    void loadText() {
        SharedPreferences sPref = getPreferences(MODE_PRIVATE);
        String savedText = sPref.getString(st, "");
        textView.setText(savedText);
        Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
    }
   /* SharedPreferences - Общие настройки
   этот метод нужен чтобы сохранить часть значений в самом приложении
   вот эти настройки хранятся в xml файле с настройкаим. НЕзашифрованы

    SharedPreferences.Editor - для управления настроками
    */
}

