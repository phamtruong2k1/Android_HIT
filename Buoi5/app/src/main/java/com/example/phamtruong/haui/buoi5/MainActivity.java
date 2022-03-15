package com.example.phamtruong.haui.buoi5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static List<User> list = new ArrayList<>();
    static RecyAdapter adapter;
    static RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recy);

        list=tao();

        adapter = new RecyAdapter(list, this, new Click_recy() {
            @Override
            public void click_re(User str) {
                list.add(new User("4","Trường 4"));
                adapter.notifyDataSetChanged();
            }
        });

        show();
        recyclerView.scrollToPosition(20);





    }

     void show(){
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));

        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(decoration);
    }

    List<User> tao(){
        List<User> list = new ArrayList<>();
        list.add(new User("1","Trường 1"));
        list.add(new User("2","Trường 2"));
        list.add(new User("3","Trường 3"));
        list.add(new User("4","Trường 4"));
        list.add(new User("5","Trường 5"));
        list.add(new User("1","Trường 1"));
        list.add(new User("2","Trường 2"));
        list.add(new User("3","Trường 3"));
        list.add(new User("4","Trường 4"));
        list.add(new User("5","Trường 5"));
        list.add(new User("1","Trường 1"));
        list.add(new User("2","Trường 2"));
        list.add(new User("3","Trường 3"));
        list.add(new User("4","Trường 4"));
        list.add(new User("5","Trường 5"));
        list.add(new User("1","Trường 1"));
        list.add(new User("2","Trường 2"));
        list.add(new User("3","Trường 3"));
        list.add(new User("4","Trường 4"));
        list.add(new User("20","Trường 5"));
        list.add(new User("1","Trường 1"));
        list.add(new User("2","Trường 2"));
        list.add(new User("3","Trường 3"));
        list.add(new User("4","Trường 4"));
        list.add(new User("1","Trường 1"));
        list.add(new User("2","Trường 2"));
        list.add(new User("3","Trường 3"));
        list.add(new User("4","Trường 4"));

        return list;
    }

}