package com.example.phamtruong.haui.demb4;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirtFragment extends Fragment {

    SenData senData;

    public interface SenData{
        void onSendData(String str);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof SenData){
            senData = (SenData) context;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    EditText edt;
    Button bt;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_firt, container, false);
        edt = view.findViewById(R.id.edt);
        bt = view.findViewById(R.id.bt);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senData.onSendData(edt.getText().toString());
            }
        });

        return view;
    }


}