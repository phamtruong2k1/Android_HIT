package com.example.phamtruong.haui.luyentap_3_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edt);
        bt = findViewById(R.id.bt);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //khai báo
                Intent intent = new Intent();

                //khai báo làm gì đấy
                intent.setAction(Intent.ACTION_SEND);

                intent.setType("text/plain");


                intent.putExtra(Intent.EXTRA_TEXT, editText.getText());

                //khởi chạy
                startActivity(intent);
            }
        });

    }
}