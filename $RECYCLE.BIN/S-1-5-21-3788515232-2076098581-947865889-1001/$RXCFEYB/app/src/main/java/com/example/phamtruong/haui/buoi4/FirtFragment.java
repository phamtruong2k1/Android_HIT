package com.example.phamtruong.haui.buoi4;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FirtFragment extends Fragment {

    private OnSendMessageListener mListener;
    private EditText mTextMessage;
    private Button mButtonSend;

    public static FirtFragment  newInstance(){
        return new FirtFragment ();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnSendMessageListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() + " must implement OnSendMessageListener");
        }
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        mButtonSend = view.findViewById(R.id.button);
        mTextMessage = view.findViewById(R.id.edit);
        mButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    mListener.onSend(mTextMessage.getText().toString());

            }
        });

        return view;
    }

    public interface OnSendMessageListener{
        void onSend(String msg);
    }
}