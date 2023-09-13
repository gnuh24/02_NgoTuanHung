package org.example.entity;

public class NgayThangNam {
    public int ngay, thang, nam;
    public class GioPhutGiay{
        public int gio, phut, giay;
        public void xuatthongtin(){
            System.out.println("Ngày: " + ngay + " Tháng: " + thang + " Năm: " + nam);
            System.out.println("Giờ: " + gio + " Phút: " + phut + " Giây " + giay);
        }
    }
}
