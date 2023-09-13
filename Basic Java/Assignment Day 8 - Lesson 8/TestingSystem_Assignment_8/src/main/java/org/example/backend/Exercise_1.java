package org.example.backend;

import org.example.entity.Student;

import java.util.*;

public class Exercise_1 {
    public static ArrayList<Student> question1_createList(){
        ArrayList<Student> students = new ArrayList<>();
        String[] name = {
                "Tên 1",
                "Tên 2",
                "Tên 2",
                "Tên 2",
                "Tên 5",
                "Tên 5",
                "Tên 7",
                "Tên 8",
                "Tên 9",
                "Tên 10"
        };

        for (int i=0; i< 10; i++){
            students.add(new Student(i, name[i]));
        }
        return students;
    }

    public static void question1_display(ArrayList<Student> listStudent){
        System.out.println("a) " + listStudent.size());
        System.out.println("b) " + listStudent.get(3));
        System.out.println("c) " + listStudent.get(0) + " " + listStudent.get( listStudent.size() - 1 ));
        listStudent.add(0, new Student(0, "Thêm đầu nè"));
        listStudent.add( new Student(0, "Thêm cuối nè") );
        Collections.reverse(listStudent);
        System.out.println("g) " + Exercise_1.question1_findID(listStudent, 2));
        System.out.println("h) " + Exercise_1.question1_findName(listStudent, "Tên2"));
        System.out.println("i) " + Exercise_1.question1_sameName(listStudent));
        Exercise_1.question1_findID(listStudent, 2).setName("");
        listStudent.remove(Exercise_1.question1_findID(listStudent, 5));
        ArrayList<Student> studentsCopies = new ArrayList<>(listStudent);
        System.out.println("Origin: " + listStudent);
        System.out.println("Copy: " + studentsCopies);
    }

    private static Student question1_findID(ArrayList<Student> listStudent, int id){
        Student target = null;
        for (Student i: listStudent)
            if (id == i.getId())
                target = i;
        return target;
    }

    private static Student question1_findName(ArrayList<Student> listStudent, String name){
        Student target = null;
        for (Student i: listStudent)
            if (name.equals( i.getName() ))
                target = i;
        return target;
    }

    private static HashSet<Student> question1_sameName(ArrayList<Student> listStudent){
        HashSet<Student> target = new HashSet<>();
        for (int i=0; i < listStudent.size() -1; i++)
            for (int j= i+1; j < listStudent.size(); j++)
                if (listStudent.get(i).getName().equals(listStudent.get(j).getName()))
                    target.add(listStudent.get(i));
        return target;
    }

    public static void question2(){
        Stack<Student> testStack = new Stack<>();
        testStack.add(new Student(1, "Nguyễn Văn Nam"));
        testStack.add(new Student(2, "Nguyễn Văn Huyên"));
        testStack.add(new Student(3, " Trần Văn Nam"));
        testStack.add(new Student(4, "Nguyễn Văn A"));

        Queue<Student> testQueue = new LinkedList<>();
        testQueue.add(new Student(1, "Nguyễn Văn Nam"));
        testQueue.add(new Student(2, "Nguyễn Văn Huyên"));
        testQueue.add(new Student(3, " Trần Văn Nam"));
        testQueue.add(new Student(4, "Nguyễn Văn A"));


        System.out.println("Danh sách tới trễ nhất tới sớm nhất");
        Exercise_1.question2_latest(testStack);

        System.out.println("Danh sách tới sớm nhất tới trễ nhất");
        Exercise_1.question2_earliest(testQueue);

        System.out.println(testStack);
        System.out.println(testQueue);
    }

    private static void question2_latest(Stack<Student> testStack){
        while ( !testStack.empty() )
            System.out.println(testStack.pop());
    }


    private static void question2_earliest(Queue<Student> testQueue){
        while ( !testQueue.isEmpty() )
            System.out.println(testQueue.poll() );
    }

    public static LinkedHashSet<String> question4(ArrayList<Student> students){
        LinkedHashSet<String> result = new LinkedHashSet<>();
        for (Student i: students) {
            result.add(i.getName());
        }
        return result;
    }



    public static LinkedHashSet<String> question5(ArrayList<Student> students){
        Collections.sort(students,new SortAccondingName());
        LinkedHashSet<String> result = new LinkedHashSet<>();
        for (Student i: students) {
            result.add(i.getName());
        }
        return result;
    }

    public static LinkedHashMap<Integer, String> question6(ArrayList<Student> listStudent){
        LinkedHashMap<Integer, String> students = new LinkedHashMap<>();
        for (int i=0; i < listStudent.size(); i++)
            students.put(listStudent.get(i).getId(), listStudent.get(i).getName());
        return students;
    }

    public static void question7(LinkedHashMap<Integer, String> students){
        ArrayList <Integer> listKey = new ArrayList<>();
        ArrayList <String> listValue = new ArrayList<>();

        for (Map.Entry<Integer, String> i: students.entrySet()){
            listKey.add(i.getKey());
            listValue.add(i.getValue());
        }

        System.out.println("Key: " + listKey);
        System.out.println("Value: " + listValue);


        Collections.sort(listValue);
        System.out.println("After sort:" + listValue);

        LinkedHashSet testSet = new LinkedHashSet();
        for (Map.Entry<Integer, String> i: students.entrySet()){
            testSet.add(i.getValue());
        }
    }

}

class SortAccondingName implements Comparator<Student>{
    @Override
    public int compare(Student a, Student b){
        return a.getName().compareTo(b.getName());
    }
}

