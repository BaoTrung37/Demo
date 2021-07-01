package com.example.nguyenbaotrung_android43_buoi4;

public class BaoCao {
    private String ngayGiaoDich;
    private String maCCQ;
    private String giaMua;
    private String giaThuong;
    private String loiNhuan;

    public BaoCao(String ngayGiaoDich, String maCCQ, String giaMua, String giaThuong, String loiNhuan) {
        this.ngayGiaoDich = ngayGiaoDich;
        this.maCCQ = maCCQ;
        this.giaMua = giaMua;
        this.giaThuong = giaThuong;
        this.loiNhuan = loiNhuan;
    }

    public String getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public void setNgayGiaoDich(String ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }

    public String getMaCCQ() {
        return maCCQ;
    }

    public void setMaCCQ(String maCCQ) {
        this.maCCQ = maCCQ;
    }

    public String getGiaMua() {
        return giaMua;
    }

    public void setGiaMua(String giaMua) {
        this.giaMua = giaMua;
    }

    public String getGiaThuong() {
        return giaThuong;
    }

    public void setGiaThuong(String giaThuong) {
        this.giaThuong = giaThuong;
    }

    public String getLoiNhuan() {
        return loiNhuan;
    }

    public void setLoiNhuan(String loiNhuan) {
        this.loiNhuan = loiNhuan;
    }
}
