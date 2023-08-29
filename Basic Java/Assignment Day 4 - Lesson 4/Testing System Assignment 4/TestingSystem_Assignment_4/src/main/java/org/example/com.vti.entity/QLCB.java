package org.example.com.vti.entity;
import java.util.ArrayList;
public class QLCB {
    /*
    *   a) Thêm mới cán bộ.
        b) Tìm kiếm theo họ tên.
        c) Hiện thị thông tin về danh sách các cán bộ.
        d) Nhập vào tên của cán bộ và delete cán bộ đó
        e) Thoát khỏi chương trình.*/
    ArrayList<CanBo> listOfCanBo = new ArrayList<>();
    public void addCanBo(CanBo canbo1){
        this.listOfCanBo.add(canbo1);
        System.out.println("Đã thêm cán bộ mới thành công ^^");
    }

    public CanBo findCanBo(String name){
        for (CanBo i: this.listOfCanBo)
            if (i.name.equals(name))
                return i;
        return null;
    }

    public void outputList(){
        System.out.printf("| %-30s| %-5s| %-10s| %-50s|%n", "Họ và tên", "Tuổi", "Giới tính", "Địa chỉ");
        for (CanBo i: this.listOfCanBo)
            System.out.printf("| %-30s| %-5d| %-10s| %-50s|%n", i.name, i.age, i.gender.toString(), i.address);
    }

    public void deleteCanBo(String name){
        /*CanBo toRemove = null;
        for (CanBo i : this.listOfCanBo)
            if (i.name.equals(name)) {
                toRemove = i;
                break;
            }

        if (toRemove != null) {
            this.listOfCanBo.remove(toRemove);
            System.out.println("Đã xóa cán bộ " + name);
        }
        else System.out.println("Không tìm thấy cán bộ có tên " + name);

        listOfCanbo.removeIf(canBo -> canBo.getHoTen().equalsIgnoreCase(hoTen));*/

        this.listOfCanBo.remove(findCanBo(name));
    }

    //Thoát khỏi chương trình ^^
    public void exitProgram(){
        System.out.println("Đã thoát khỏi chương trình.");
        System.exit(0);
    }

}
