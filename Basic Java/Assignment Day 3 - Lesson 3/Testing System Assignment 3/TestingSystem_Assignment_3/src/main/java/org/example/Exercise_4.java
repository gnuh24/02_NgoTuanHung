package org.example;

import java.util.Scanner;

public class Exercise_4 {
    /*Question 1:
    Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó (các từ có
            thể cách nhau bằng nhiều khoảng trắng );*/
    public static void question1(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập chuỗi cần đếm từ"); String s1 = input.nextLine();
        int countWord = 0;
        for (int i =0; i< s1.length(); i++)
            if ( s1.charAt(i) == ' ')
                countWord++;
        System.out.println("Chuỗi s1 có " + (countWord + 1) + " từ");

    }
    /*Question 2:
    Nhập hai xâu kí tự s1, s2 nối xâu kí tự s2 vào sau xâu s1;*/
    public static void question2(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập chuỗi s1"); String s1 = input.nextLine();
        System.out.println("Nhập chuỗi s2"); String s2 = input.nextLine();
        System.out.println(s1 + " " + s2);
    }


    /*Question 3:
    Viết chương trình để người dùng nhập vào tên và kiểm tra, nếu tên chư
    viết hoa chữ cái đầu thì viết hoa lên*/
    public static void question3(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập họ và tên"); String s1 = input.nextLine();
        s1 = s1.toLowerCase();

        for (int i=0; i<s1.length(); i++)
            if (' ' == s1.charAt(i))
                //s1.charAt(i+1) = Character.toUpperCase(s1.charAt(i+1));
        System.out.println(s1);

    }
   /* Question 4:
    Viết chương trình để người dùng nhập vào tên in từng ký tự trong tên
    của người dùng ra
    VD:
    Người dùng nhập vào "Nam", hệ thống sẽ in ra
        "Ký tự thứ 1 là: N"
        "Ký tự thứ 1 là: A"
        "Ký tự thứ 1 là: M"*/
    public static void question4(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tên"); String s1 = input.nextLine();
        for (int i=0; i< s1.length(); i++){
            System.out.println("Đây là ký tự thứ " + (i+1) + " " + s1.charAt(i));
        }

    }
    /* Question 5:
        Viết chương trình để người dùng nhập vào họ, sau đó yêu cầu người
        dùng nhập vào tên và hệ thống sẽ in ra họ và tên đầy đủ*/
    public static void question5(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập họ"); String s1 = input.nextLine();
        System.out.println("Nhập tên"); String s2 = input.nextLine();
        System.out.println("Họ và tên: " + s1 + " " + s2);
    }

    /*Question 6:
        Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và
        sau đó hệ thống sẽ tách ra họ, tên , tên đệm
        VD:
        Người dùng nhập vào "Nguyễn Văn Nam"
        Hệ thống sẽ in ra
        "Họ là: Nguyễn"
            "Tên đệm là: Văn"
            "Tên là: Nam"*/
    public static void question6(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập họ và tên"); String s1 = input.nextLine();
        String [] list = s1.split(" ");

        for (int i=0; i < list.length; i++){
            if (i == 0)
                System.out.println("Họ: " + list[0]);
            else if (i == list.length -1)
                System.out.println("Tên: " + list[list.length -1]);
            else
                System.out.println("Tên đệm " + i + ": " + list[i]);
        }
    }
    /*Question 7:
        Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và
        chuẩn hóa họ và tên của họ như sau:
        a) Xóa dấu cách ở đầu và cuối và giữa của chuỗi người dùng nhập vào
        VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ
        chuẩn hóa thành "nguyễn văn nam"
        b) Viết hoa chữ cái mỗi từ của người dùng
        VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ
        chuẩn hóa thành "Nguyễn Văn Nam"*/

    public static void question7(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập họ và tên"); String s1 = input.nextLine();
        s1.toLowerCase();


        String [] list = s1.split(" ");
        for (int i=0; i< list.length; i++)
            if (list[i].equals(' '))
                list.remove;

        for (String i: list)
            System.out.println(i);



    }

    /*Question 8:
         In ra tất cả các group có chứa chữ "Java"*/

    /*Question 9:
    In ra tất cả các group "Java"*/

    /*Question 10 (Optional):
    Kiểm tra 2 chuỗi có là đảo ngược của nhau hay không.
    Nếu có xuất ra “OK” ngược lại “KO”.
    Ví dụ “word” và “drow” là 2 chuỗi đảo ngược nhau.*/

    /*Question 11 (Optional): Count special Character
    Tìm số lần xuất hiện ký tự "a" trong chuỗi*/

    /*Question 12 (Optional): Reverse String
    Đảo ngược chuỗi sử dụng vòng lặp*/

    /*Question 13 (Optional): String not contains digit
    Kiểm tra một chuỗi có chứa chữ số hay không, nếu có in ra false ngược
    lại true.
    Ví dụ:
    "abc" => true
    "1abc", "abc1", "123", "a1bc", null => false*/

    /*Question 14 (Optional): Replace character
    Cho một chuỗi str, chuyển các ký tự được chỉ định sang một ký tự khác
    cho trước.
    Ví dụ:
    "VTI Academy" chuyển ký tự 'e' sang '*' kết quả " VTI Acad*my"*/

    /*Question 15 (Optional): Revert string by word
    Đảo ngược các ký tự của chuỗi cách nhau bởi dấu cách mà không dùng
    thư viện.
    Ví dụ: " I am developer " => "developer am I".
    Các ký tự bên trong chỉ cách nhau đúng một dấu khoảng cách.
    Gợi ý: Các bạn cần loại bỏ dấu cách ở đầu và cuối câu, thao tác cắt
    chuỗi theo dấu cách*/

    /*Question 16 (Optional):

    4

    Cho một chuỗi str và số nguyên n >= 0. Chia chuỗi str ra làm các phần
    bằng nhau với n ký tự. Nếu chuỗi không chia được thì xuất ra màn
    hình “KO”.*/

}
