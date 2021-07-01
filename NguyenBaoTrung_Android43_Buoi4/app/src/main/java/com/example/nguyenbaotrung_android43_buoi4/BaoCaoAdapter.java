package com.example.nguyenbaotrung_android43_buoi4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class BaoCaoAdapter extends BaseAdapter {
    List<BaoCao> listBaoCao;

    public BaoCaoAdapter(List<BaoCao> listBaoCao) {
        this.listBaoCao = listBaoCao;
    }

    @Override
    public int getCount() {
        return listBaoCao.size();
    }

    @Override
    public Object getItem(int position) {
        return listBaoCao.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    private class ViewHolder{
        TextView tvngayGiaoDich,tvmaCCQ,tvgiaMua,tvgiaThiTruong,tvloiNhuan;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.layout_table,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.tvngayGiaoDich = convertView.findViewById(R.id.textNgayGD);
            viewHolder.tvmaCCQ = convertView.findViewById(R.id.textMaCCQ);
            viewHolder.tvgiaMua = convertView.findViewById(R.id.textGiaMua);
            viewHolder.tvgiaThiTruong = convertView.findViewById(R.id.textGiaThiTruong);
            viewHolder.tvloiNhuan = convertView.findViewById(R.id.textLoiNhuan);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        BaoCao baoCao = listBaoCao.get(position);
        viewHolder.tvngayGiaoDich.setText(baoCao.getNgayGiaoDich());
        viewHolder.tvmaCCQ.setText(baoCao.getMaCCQ());
        viewHolder.tvgiaMua.setText(baoCao.getGiaMua());
        viewHolder.tvgiaThiTruong.setText(baoCao.getGiaThuong());
        viewHolder.tvloiNhuan.setText(baoCao.getLoiNhuan());
        return convertView;
    }
}
