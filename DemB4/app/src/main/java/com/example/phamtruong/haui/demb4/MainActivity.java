package com.example.phamtruong.haui.demb4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FirtFragment.SenData {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout layout;
        ADDFragment();

    }

    @Override
    public void onSendData(String str) {
        SecondFragment fragment = (SecondFragment) getSupportFragmentManager().findFragmentById(R.id.second);
        if (fragment != null){
            fragment.textView.setText(str);
        }
        else {
            Toast.makeText(MainActivity.this,"Lỗi",Toast.LENGTH_LONG).show();
        }


    }

    private void ADDFragment(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.first,new FirtFragment());
        transaction.add(R.id.second,new SecondFragment());
        transaction.commit();
    }
}