package org.example.exercise1;
import org.example.exercise1.question1.News;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("1. Insert news");
        System.out.println("2. View list news");
        System.out.println("3. Average rate");
        System.out.println("4. Exit");
        System.out.println("Hãy nhập lựa chọn của bạn: ");
        ArrayList <News> listOfNews = new ArrayList<>();
        News article1 = new News("Cúp C1 2013: Đội A vô địch", "15/06/2013", "John Smith",
                "Đội A đã vượt qua các đối thủ mạnh để giành chiến thắng trong Cúp C1 năm 2013.", 9, 8, 7);
        News article2 = new News("Thất bại của Đội B trong Cúp C1 2013", "18/06/2013", "Jane Doe",
                "Đội B đã không thể vượt qua vòng bán kết trong Cúp C1 năm 2013.", 6, 5, 4);
        News article3 = new News("Ngôi vị á quân của Đội C tại Cúp C1 2013", "20/06/2013", "David Johnson",
                "Sau một cuộc hành trình hấp dẫn, Đội C đã đứng thứ hai tại Cúp C1 năm 2013.", 8, 7, 9);
        News article4 = new News("Những ngôi sao tỏa sáng trong Cúp C1 2013", "22/06/2013", "Emily Williams",
                "Các cầu thủ xuất sắc đã có những pha thi đấu ấn tượng, góp phần quan trọng vào thành công của Cúp C1 năm 2013.", 10, 9, 9);
        listOfNews.add(article1);
        listOfNews.add(article2);
        listOfNews.add(article3);
        listOfNews.add(article4);

        int yourChoice = input.nextInt();
        switch (yourChoice){
            case 1:
                System.out.println("Bạn đã chọn 1. Insert news");
                System.out.println("Bây giờ hãy nhập theo thứ tự Title, PublishDate, Author, Content");
                String inputTitle = input.nextLine();
                String inputPublishDate = input.nextLine();
                String inputAuthor = input.nextLine();
                String inputContent = input.nextLine();

                System.out.println("Sau đó bạn hãy nhập 3 đánh giá trên thang điểm 10 ^^");
                int a , b, c;

                do {
                    a = input.nextInt();
                    b = input.nextInt();
                    c = input.nextInt();
                } while ( (0 > a || a > 10) || (0 > b || b > 10) || (0 > c || c > 10) );
                News newObj = new News(inputTitle, inputPublishDate, inputAuthor, inputContent, a, b, c);
                listOfNews.add(newObj);
                System.out.println("Đã tạo thành công bài báo ^^");
                break;
            case 2:
                if ( listOfNews.size() == 0 )
                    System.out.println("Bạn chưa có bài báo nào để in ra cả ^^");
                else {
                    System.out.println("Hiện tại đang có " + listOfNews.size() + " bài báo. \nBạn muốn xem bài báo nào ?");
                    int count = 0;
                    for (News i : listOfNews) {
                        System.out.println(++count + ". "+ i.getTitle());
                    }
                    int subChoice = input.nextInt();
                    listOfNews.get(subChoice - 1).display();
                }
                break;
            case 3:
                if ( listOfNews.size() == 0 )
                    System.out.println("Bạn chưa có bài báo nào để in ra cả ^^");
                else {
                    System.out.println("Hiện tại đang có " + listOfNews.size() + " bài báo. \nBạn muốn tính AvgRates bài báo nào ?");
                    int count = 0;
                    for (News i : listOfNews) {
                        System.out.println(++count + ". "+ i.getTitle());
                    }
                    int subChoice = input.nextInt();
                    listOfNews.get(subChoice - 1).calculate();
                    listOfNews.get(subChoice - 1).display();
                }
                break;
            case 4:
                System.out.println("Hello");
                System.exit(0);
            default:
                System.out.println("Giá trị không hợp lệ");
                break;
        }






    }
}