package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner test = new Scanner(new File("hello.txt") );
        while (test.hasNextLine()){
            System.out.println(test.nextLine());
        }
    }
}