package com.example.quanlysinhvien;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class SinhVienAdapter extends ArrayAdapter<SinhVien> {
    ArrayList<SinhVien> arr;
    Context ct;
    public SinhVienAdapter(Context context, int resource, ArrayList<SinhVien> o){
        super(context, resource, o);
        this.ct = context;
        this.arr = data.getDt().arrSV;
        System.out.println("dugh" + arr.size());
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        viewHodler v;
        if(row == null){
            LayoutInflater inflater = (LayoutInflater)ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.item_sinh_vien,null);
            v = new viewHodler(row);
            row.setTag(v);
        }
        v = new viewHodler(row);

        if(arr.size()>0){
            System.out.println("dugh");
            v.setView(arr.get(position));

        }
        return row;
    }
    class viewHodler{
        TextView txvTen,txvSDT,txvEmail,txvLop;
        ImageView imgGT;
        public viewHodler(View v){
            txvTen=(TextView)v.findViewById(R.id.txvTen);
            txvEmail=(TextView)v.findViewById(R.id.txvEmail);
            txvLop=(TextView)v.findViewById(R.id.txvlop);
            txvSDT=(TextView)v.findViewById(R.id.txvSDT);
            imgGT=(ImageView)v.findViewById(R.id.imgGT);
        }
        public void setView(SinhVien sv){
            txvTen.setText(sv.getTen());
            txvSDT.setText(sv.getSodt());
            txvLop.setText(sv.getLophoc());
            txvEmail.setText(sv.getEmail());
            System.out.println("dughj"+sv.getGioitinh());
            if(sv.getGioitinh().equals("nu")){
                imgGT.setImageResource(R.drawable.nu);
            }
            else {
                imgGT.setImageResource(R.drawable.nam);
            }
        }
    }
}
