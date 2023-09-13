package org.example.backend;

import org.example.entity.*;

public class Exercise_3 {
    public static void question1(){
        CPU cpu = new CPU();
        CPU.Processor newP  = cpu. new Processor();
        CPU.Ram newR = cpu. new Ram();
        System.out.println(newP.getCache());
        System.out.println(newR.getClockSpeed());

    }

    public static void question2(){
        Car newCar = new Car("Mazda", "8WD");
        System.out.println(newCar.getName());
        System.out.println(newCar.getType());
        Car.Engine engine = newCar. new Engine( "Crysler");
        System.out.println(engine.getEngineType());
    }

    public static void question3(){
        OuterClass out = new OuterClass();
        out.show();
        OuterClass.InnerClass in = out.new InnerClass();
        in.show();
    }

    public static void question4(){
        NgayThangNam date = new NgayThangNam();
        date.ngay = 31;
        date.thang = 10;
        date.nam = 2017;

        NgayThangNam.GioPhutGiay time = date. new GioPhutGiay();
        time.gio = 10;
        time.phut = 15;
        time.giay = 30;

        time.xuatthongtin();
    }
}
