package org.example.listOfExercise;
import java.time.Duration;
import java.util.Arrays;
public class Exercise_1 {
    public void question1 (float input){
        System.out.printf("%2f %n", input/30.48);
    }

    public void question2(int second){
        Duration duration = Duration.ofSeconds(second);
        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();
        long seconds = duration.toSecondsPart();
        System.out.println(hours + ":" + minutes + ":" + seconds);
    }

    public void quesiion3(int a, int b, int c, int d){
        int [] list = {a, b, c, d};
        Arrays.sort(list);
        System.out.println("Số lớn nhất: " + list[3]);
        System.out.println("Số nhỏ nhất: " + list[0]);

    }

    public void question4(int a, int b){
        if (a - b > 0)
            System.out.println("Số thứ nhất lớn hơn số thứ hai");
        else System.out.println("Số thứ nhất nhỏ hơn số thứ hai");
    }

    public void question5(int a, int b){
        System.out.println(a%b == 0? "a chia hết cho b": "a không chia hết cho b");

    }
    public void question6(float math, float physics, float chemistry){
        float avg = ( (math)*2 + physics + chemistry )/4;
        if (avg >= 9.0)
            System.out.println("Loại xuất sắc");
        else if (8.0 <= avg && avg < 9.0)
            System.out.println("Loại giỏi");
        else if (7.0 <= avg && avg < 8.0)
            System.out.println("Loại khá");
        else if (6.0 <= avg && avg < 7.0)
            System.out.println("Loại trung bình khá");
        else if (5.0 <= avg && avg < 6.0)
            System.out.println("Loại trung bình");
        else if (5.0 > avg)
            System.out.println("Loại kém");
    }


}
