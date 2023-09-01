package org.example;

public class Student {
    String name, id, date;
    double RA, SD, CP, CUT, FMT;
    public Student(String name, String id, String date, double RA, double SD, double CP, double CUT, double FMT){
        this.name = name;
        this.id = id;
        this.date = date;
        this.RA = RA;
        this.SD = SD;
        this.CP = CP;
        this.CUT = CUT;
        this.FMT = FMT;
    }
    public double avg(){
        return (RA + SD + CP + CUT + FMT) / 5;
    }
    public void display(){
        System.out.printf("%-20s %-10s %-20s %-5.1f %-5.1f %-5.1f %-5.1f %-5.1f %-5.1f %n", this.name, this.id, this.date, this.RA, this.SD, this.CP, this.CUT, this.FMT, avg() );
    }
}
