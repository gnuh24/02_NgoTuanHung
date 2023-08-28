package org.example.com.vti.entity;
import java.util.ArrayList;
public class QLCB {
    ArrayList<CanBo> listOfCanBo = new ArrayList<>();
    public void addCanBo(CanBo canbo1){
        this.listOfCanBo.add(canbo1);
        System.out.println("Đã thêm cán bộ mới thành công ^^");
    }

    public CanBo findCanBo(String name){
        CanBo result = null;
        for (CanBo i: this.listOfCanBo)
            if (i.name.equals(name)){
                result = i;
                break;
            }
        return result;
    }

    public void outputList(){
        System.out.printf("| %-30s| %-5s| %-10s| %-50s|%n", "Họ và tên", "Tuổi", "Giới tính", "Địa chỉ");
        for (CanBo i: this.listOfCanBo)
            System.out.printf("| %-30s| %-5d| %-10s| %-50s|%n", i.name, i.age, i.gender.toString(), i.address);
    }

    public void deleteCanBo(String name){
        CanBo toRemove = null;
        for (CanBo i : this.listOfCanBo) {
            if (i.name.equals(name)) {
                toRemove = i;
                break;
            }
        }

        if (toRemove != null) {
            this.listOfCanBo.remove(toRemove);
            System.out.println("Đã xóa cán bộ " + name);
        } else {
            System.out.println("Không tìm thấy cán bộ có tên " + name);
        }
    }

    //Thoát khỏi chương trình ^^
}
