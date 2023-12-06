import { saveHello } from "./helloWorld";
saveHello()
saveHello()



public void inBienLai(){
    DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
    System.out.println("*".repeat(60));
    System.out.printf("%-30s\n","Biên lai");
    System.out.println("*".repeat(60));

    System.out.println("*  %-30s %-30s*\n","Mã biên lai: "+this.getMaBienLai());
    System.out.println("*  %-30s %-30s*\n","Học Viên: "+this.getYeuCauDangKy().getHocVien().getHoTen());
    System.out.println("*  %-30s %-30s*\n","Mã học viên: "+this.getYeuCauDangKy().getHocVien().getMaUser());
    System.out.println("*  %-30s %-30s*\n","Lớp: "+this.getYeuCauDangKy().getLopHoc().getMaLop());
    System.out.println("*  %-30s %-30.2f*\n","Số tiền: "+this.getSoTienDaDong());
    System.out.println("*  %-30s %-30s*\n","Ngày đóng: "+this.getNgayThanhToan().format(formatter));
    System.out.println("*".repeat(60));

}
