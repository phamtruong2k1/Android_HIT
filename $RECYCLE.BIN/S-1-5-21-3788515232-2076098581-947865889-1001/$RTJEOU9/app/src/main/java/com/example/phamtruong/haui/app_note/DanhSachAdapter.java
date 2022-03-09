package com.example.phamtruong.haui.app_note;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DanhSachAdapter extends BaseAdapter {

    List<String> list = new ArrayList<>();


    public DanhSachAdapter(List<String> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }



    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view1 = layoutInflater.inflate(R.layout.item_show_note,viewGroup,false);

        TextView noidung = view1.findViewById(R.id.noidung);

        String str = list.get(i);

        noidung.setText(str);

        return view1;
    }
}
