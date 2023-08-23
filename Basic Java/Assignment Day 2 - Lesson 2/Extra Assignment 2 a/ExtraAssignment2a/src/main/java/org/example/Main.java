package org.example;
import java.time.LocalDate;
import java.util.Random;
//import java.util.Date;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        /*Exercise 1:
        1 trường đại học cần 1 phần mềm để quản lý điểm của sinh viên. Bạn đang làm việc
        như người lập trình viên và bạn phải xây dựng 1 chương trình đáp ứng được các yêu
        cầu sau:


        1. Tạo tên của sinh viên:
            a. Tạo 1 array có chứa 7 họ của sinh viên (tên của sinh viên không chứa
            dấu)
            b. Tạo 1 array có chứa 7 tên đệm của sinh viên (tên đệm của sinh viên
                    không chứa dấu)
            c. Tạo 1 array có chứa 7 tên của sinh viên (tên của sinh viên không chứa
            dấu)
        Tạo 10 tên đầy đủ của sinh viên (bao gồm 1 họ, 1 tên đệm và 1 tên) và đặt
        chúng vào trong 1 array mới. (Các tên phải khác nhau từng đôi một).*/
        String[] lastNameArray = {"Nguyen", "Tran", "Le", "Pham", "Hoang", "Do", "Vu"};
        String[] firstNameArray = {"Van", "Thi", "Duc", "Thu", "Minh", "Hien", "Binh"};
        String[] middleNameArray = {"Thi", "Hoang", "Quang", "Duy", "Van", "Trung", "Ngoc"};
        String [] fullNameArray = {
                lastNameArray[0] + " "+ middleNameArray[0] + " " + firstNameArray[0],
                lastNameArray[1] + " "+ middleNameArray[1] + " " + firstNameArray[1],
                lastNameArray[2] + " "+ middleNameArray[2] + " " + firstNameArray[2],
                lastNameArray[3] + " "+ middleNameArray[3] + " "+ firstNameArray[3],
                lastNameArray[4] + " "+ middleNameArray[4] + " "+ firstNameArray[4],
                lastNameArray[5] + " "+ middleNameArray[5] + " "+ firstNameArray[5],
                lastNameArray[6] + " "+ middleNameArray[6] + " "+ firstNameArray[6],
                lastNameArray[5] + " "+ middleNameArray[6] + " "+ firstNameArray[4],
                lastNameArray[0] + " "+ middleNameArray[6] + " "+ firstNameArray[5],
                lastNameArray[4] + " "+ middleNameArray[3] + " "+ firstNameArray[2],
                lastNameArray[1] + " "+ middleNameArray[2] + " "+ firstNameArray[0]
        };

        /*2. Tạo ID của sinh viên:
        Tạo 10 ID của sinh viên. ID bao gồm “SV” + 7 số và ID của mỗi sinh viên là
        duy nhất.*/
        Random random = new Random();

        String[] listOfID = {
                "SV" + (random.nextInt(9000000) + 1000000),
                "SV" + (random.nextInt(9000000) + 1000000),
                "SV" + (random.nextInt(9000000) + 1000000),
                "SV" + (random.nextInt(9000000) + 1000000),
                "SV" + (random.nextInt(9000000) + 1000000),
                "SV" + (random.nextInt(9000000) + 1000000),
                "SV" + (random.nextInt(9000000) + 1000000),
                "SV" + (random.nextInt(9000000) + 1000000),
                "SV" + (random.nextInt(9000000) + 1000000),
                "SV" + (random.nextInt(9000000) + 1000000)
        };


        /*3. Tạo ngày sinh của sinh viên:
        Tạo 10 ngày sinh của sinh viên nằm trong khoảng 01/02/1991 và 31/12/1991.
        Ngày sinh của mỗi sinh viên là duy nhất.*/
        Main obj = new Main();
        LocalDate [] listLocalDate = {
                obj.randomDate(),
                obj.randomDate(),
                obj.randomDate(),
                obj.randomDate(),
                obj.randomDate(),
                obj.randomDate(),
                obj.randomDate(),
                obj.randomDate(),
                obj.randomDate(),
                obj.randomDate(),
        };


        /*4. In thông tin trên ra màn hình:
        In thông tin của tất cả các sinh viên lên màn hình, bao gồm: Id, tên đẩy đủ,
        ngày sinh.*/

        System.out.printf("%-20s | %-10s | %-12s ", "FullName", "ID", "Date");
        for (int i=0; i<10; i++){
            System.out.printf("%n%-20s | %-10s | %-12s ", fullNameArray[i], listOfID[i], listLocalDate[i]);
        }

    }

    LocalDate randomDate(){
        // Trả về
        Random random = new Random();
        int minDay = (int) LocalDate.of(1991, 2, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(1991,12,31).toEpochDay();
        long randomInt = minDay + random.nextInt(maxDay - minDay);
        return LocalDate.ofEpochDay(randomInt); //LocalDate data type
    }

}
