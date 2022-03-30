package com.example.phamtruong.haui.buoi7_file;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    Button add,lay;
    EditText nhap;
    TextView txt;
    String name ="data.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add=findViewById(R.id.add);
        lay=findViewById(R.id.lay);
        nhap = findViewById(R.id.edt);
        txt = findViewById(R.id.txt);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ADD();
            }
        });

        lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lay();
            }
        });


    }

    void ADD(){
        String data = this.nhap.getText().toString();
        try {
            FileOutputStream out = openFileOutput(name,MODE_PRIVATE);
            out.write(data.getBytes());
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void lay(){
        try {
            FileInputStream out = openFileInput(name);
            BufferedReader br = new BufferedReader(new InputStreamReader(out));
            StringBuilder str = new StringBuilder();
            String show="";
            while((show=br.readLine())!=null){
                str.append(show).append("\n");
            }
            txt.setText(str.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}