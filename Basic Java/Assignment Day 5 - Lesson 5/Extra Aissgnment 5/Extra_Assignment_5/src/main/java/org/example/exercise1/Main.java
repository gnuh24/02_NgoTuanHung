package org.example.exercise1;

public class Main {
    public static void main(String[] args) {
        QuickSort list = new QuickSort(10);
        list.input();
        list.sort(0, list.getList().length -1);
        list.print();
    }
}