package com.example.phamtruong.haui.buoi4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements  FirtFragment.OnSendMessageListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.firt, new FirtFragment());
        transaction.add(R.id.send, new SendFragment());
        transaction.commit();


//        transaction.add(R.id.send, new SendFragment());
//        transaction.commit();
    }

    @Override
    public void onSend(String msg) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.send,SendFragment.newInstance(msg));
        transaction.commit();

    }
}