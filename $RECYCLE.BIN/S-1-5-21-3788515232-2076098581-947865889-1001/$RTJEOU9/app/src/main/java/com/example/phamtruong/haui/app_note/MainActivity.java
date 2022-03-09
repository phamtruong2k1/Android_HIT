package com.example.phamtruong.haui.app_note;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView setting, search;
    FloatingActionButton add;
    ListView lview;
    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findbyid();

        List<String> list = new ArrayList<>();
        list.add("ok la");

        show_lv(list);



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    void show_lv(List<String> list){
        DanhSachAdapter adapter = new DanhSachAdapter(list);

        lview.setAdapter(adapter);
    }



    private void findbyid(){
        setting = findViewById(R.id.setting);
        search = findViewById(R.id.search);
        lview = findViewById(R.id.lview);
        name = findViewById(R.id.name);
        add = findViewById(R.id.add);
    }

    @Override
    public void onBackPressed() {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).
                setMessage("Đóng").setIcon(R.drawable.ic_baseline_edit_24).setTitle("Thoát").
                setPositiveButton("Thoát", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }).
                setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).show();
    }
}