package com.example.phamtruong.haui.buoi7_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DataSQLite dataSQLite;
    List<Ghichu> ghichuList = new ArrayList<>();
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataSQLite = new DataSQLite(this,"datalite.sqlite",null,1);

        dataSQLite.QueryData("Create table if not EXISTS GhiChu(id INTEGER PRIMARY KEY AUTOINCREMENT , Noidung NVARCHAR(1000) )");


        EditText editText = findViewById(R.id.edit);
        Button button = findViewById(R.id.add);
        textView = findViewById(R.id.txt);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataSQLite.QueryData("INSERT INTO GhiChu VALUES (null,'"+editText.getText().toString()+"')");
//                dataSQLite.QueryData("Update GhiChu SET  Noidung='"+editText.getText().toString()+"' where id="+1);
                getDat();
            }
        });
        getDat();


    }

    void getDat(){
        Cursor cursor = dataSQLite.GetData("Select * From GhiChu");
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String str = cursor.getString(1);
            ghichuList.add(new Ghichu(id,str));
        }
        String str="";
        for (Ghichu i : ghichuList){
            str+=i.getId()+" --- "+i.getNd()+'\n';
        }
        textView.setText(str);
    }
}