package org.example;

import org.example.classes.*;
import org.example.classes.Position.*;
import org.example.classes.TypeQuestion.*;

import java.util.Date;


public class Program {
    public static void main(String[] args) {
        // Create objects of class Account
        Account account1 = new Account((short) 1, "email1@example.com", "user1", "User One", (byte) 1, (byte) 1, new Date());
        Account account2 = new Account((short) 2, "email2@example.com", "user2", "User Two", (byte) 2, (byte) 2, new Date());
        Account account3 = new Account((short) 3, "email3@example.com", "user3", "User Three", (byte) 3, (byte) 3, new Date());
        System.out.println(account1.fullName);

        /*
        // Create objects of class Answer
        Answer answer1 = new Answer(1, "Content 1", 1, true);
        Answer answer2 = new Answer(2, "Content 2", 2, false);
        Answer answer3 = new Answer(3, "Content 3", 3, true);

        // Create objects of class Department
        Department department1 = new Department((byte) 1, "IT");
        Department department2 = new Department((byte) 2, "HR");
        Department department3 = new Department((byte) 3, "Finance");

        // Create objects of class Exam
        Exam exam1 = new Exam(1, 101, "Java Basics", (byte) 1, (short) 120, (short) 1, new Date());
        Exam exam2 = new Exam(2, 102, "OOP Concepts", (byte) 2, (short) 90, (short) 2, new Date());
        Exam exam3 = new Exam(3, 103, "Database Fundamentals", (byte) 3, (short) 60, (short) 3, new Date());

        // Create objects of class ExamQuestion
        ExamQuestion examQuestion1 = new ExamQuestion(1, 1);
        ExamQuestion examQuestion2 = new ExamQuestion(1, 2);
        ExamQuestion examQuestion3 = new ExamQuestion(2, 3);

        // Create objects of class Group
        Group group1 = new Group((byte) 1, "Group 1", (short) 1, new Date());
        Group group2 = new Group((byte) 2, "Group 2", (short) 2, new Date());
        Group group3 = new Group((byte) 3, "Group 3", (short) 3, new Date());

        // Create objects of class GroupAccount
        GroupAccount groupAccount1 = new GroupAccount((byte) 1, (short) 1, new Date());
        GroupAccount groupAccount2 = new GroupAccount((byte) 2, (short) 2, new Date());
        GroupAccount groupAccount3 = new GroupAccount((byte) 3, (short) 3, new Date());


        // Create objects of class Position
        Position position1 = new Position((byte) 1, EnumPositionName.DEV);
        Position position2 = new Position((byte) 2, EnumPositionName.TEST);
        Position position3 = new Position((byte) 3, EnumPositionName.SCRUM_MASTER);

        // Create objects of class Question
        Question question1 = new Question(1, "Question 1 content", (byte) 1, (byte) 1, (short) 1, new Date());
        Question question2 = new Question(2, "Question 2 content", (byte) 2, (byte) 2, (short) 2, new Date());
        Question question3 = new Question(3, "Question 3 content", (byte) 3, (byte) 3, (short) 3, new Date());

        // Create objects of class TypeQuestion
        TypeQuestion typeQuestion1 = new TypeQuestion((byte) 1, EnumTypeName.Essay);
        TypeQuestion typeQuestion2 = new TypeQuestion((byte) 2, EnumTypeName.Multiple_Choice);
        */

    }
}