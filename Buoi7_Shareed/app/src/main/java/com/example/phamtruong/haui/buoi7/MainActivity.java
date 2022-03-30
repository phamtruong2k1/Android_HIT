package com.example.phamtruong.haui.buoi7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText = findViewById(R.id.nhap);
        Button button = findViewById(R.id.luu);
        TextView txt = findViewById(R.id.txt);
        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = editText.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("giatri",str);

                editor.commit();
                txt.setText(sharedPreferences.getString("giatri",""));
            }
        });

        txt.setText(sharedPreferences.getString("giatri",""));
    }
}