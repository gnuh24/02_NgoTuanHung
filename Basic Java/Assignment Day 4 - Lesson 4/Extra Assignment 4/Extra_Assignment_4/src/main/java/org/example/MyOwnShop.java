package org.example;

public class MyOwnShop{
    public static void main(String [] args){
        Car car1 = new Car(200, 25000, "blue");
        Sedan seadan1 = new Sedan(250, 35000, "red", 12);
        Sedan seadan2 = new Sedan(260, 40000, "green", 16);
        Ford ford1 = new Ford(300, 60000, "Purple", 2023, 5000);


        System.out.println("Car1: ");
        System.out.println("Speed: " + car1.getSpeed());
        System.out.println("regularPrice: " + car1.getRegularPrice());
        System.out.println("Color: " + car1.getColor());
        System.out.println("Price: " + car1.getSalePrice());


        System.out.println("Sedan1: ");
        System.out.println("Speed: " + seadan1.getSpeed());
        System.out.println("regularPrice: " + seadan1.getRegularPrice());
        System.out.println("Color: " + seadan1.getColor());
        System.out.println("Length: " + seadan1.getLength());
        System.out.println("Price: " + seadan1.getSalePrice());

        System.out.println("Sedan2: ");
        System.out.println("Speed: " + seadan2.getSpeed());
        System.out.println("regularPrice: " + seadan2.getRegularPrice());
        System.out.println("Color: " + seadan2.getColor());
        System.out.println("Length: " + seadan2.getLength());
        System.out.println("Price: " + seadan2.getSalePrice());

        System.out.println("Ford1: ");
        System.out.println("Speed: " + ford1.getSpeed());
        System.out.println("regularPrice: " + ford1.getRegularPrice());
        System.out.println("Color: " + ford1.getColor());
        System.out.println("Year: " + ford1.getYear());
        System.out.println("manufaturerDiscout: " + ford1.getManufacturerDiscount());
        System.out.println("Price: " + ford1.getSalePrice());



    }
}
