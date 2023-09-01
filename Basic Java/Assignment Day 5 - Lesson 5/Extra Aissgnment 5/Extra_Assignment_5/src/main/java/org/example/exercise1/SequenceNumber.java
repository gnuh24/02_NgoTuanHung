package org.example.exercise1;

import java.util.Scanner;

public class SequenceNumber{
    private int [] list ;


    public void input(){
        Scanner input = new Scanner(System.in);
        String sequence = input.nextLine();
        String [] listString = sequence.split(" ");
        try{
            if (this.list.length != listString.length){
                throw new LoiSaiSoLuongThanhPhan("Lưu ý bạn chỉ được nhập dãy số với " +this.list.length + " số và cách nhau bằng 1 dấu cách");
            }
            else {

                for (String i : listString) {
                    Integer.parseInt(i);
                }

                for (int i = 0; i < this.list.length; i++)
                    list[i] = Integer.parseInt(listString[i]);
                System.out.println("Đã nhập dãy số thành công ^^");
            }
        }
        catch (LoiSaiSoLuongThanhPhan e){
            System.out.println(e.getMessage());
            input();
        }
        catch (NumberFormatException e){
            System.out.println("Nhập số nguyên vào chuỗi thôi bạn ơi ^^");
            input();
        }

    }

    public void print(){
        for (int i: this.list)
            System.out.print(i + " ");
    }

    public int[] getList() {
        return list;
    }

    public SequenceNumber(int n){
        this.list = new int[n];
    }
}

class LoiSaiSoLuongThanhPhan extends Exception{
    public LoiSaiSoLuongThanhPhan(String error){
        super(error);
    }
}
