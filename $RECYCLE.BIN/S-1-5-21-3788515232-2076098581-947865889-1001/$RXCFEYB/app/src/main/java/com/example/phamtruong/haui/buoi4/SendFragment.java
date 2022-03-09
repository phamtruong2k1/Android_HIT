package com.example.phamtruong.haui.buoi4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class SendFragment extends Fragment {

    TextView mTextMessage;

    public static SendFragment newInstance(String msg){
        SendFragment fragment = new SendFragment();
        Bundle args = new Bundle();
        args.putString("ARGUMENT_MSG",msg);
        fragment.setArguments(args);
        return fragment;
    }


    private void initData() {
        if (getArguments()!=null){
            String msg = getArguments().getString("ARGUMENT_MSG");
            mTextMessage.setText(msg);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_send, container, false);
        mTextMessage=view.findViewById(R.id.text);
        return view;
    }
}