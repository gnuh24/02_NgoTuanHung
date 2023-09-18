package org.example.backend;
import java.io.*;
import java.util.ArrayList;

public class IOManager {
    public static String readFile(String pathFile){
        try{
            if (!new File(pathFile).exists())
                throw new Exception("Error! File Not Exist.");

            FileInputStream input = new FileInputStream(pathFile);
            byte [] b = new byte[1024];
            int length = input.read(b);
            int count = 0;
            String result = "";
            while (length > -1){
                count++;
                System.out.println(length);
                result += new String(b, 0, length);
                length = input.read(b);
            }
            System.out.println(count);
            return result;

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return "";
    }
    public static void writeFile(String pathFile,boolean isContinuing ,String content){

        try {
            if (!new File(pathFile).exists()){
                throw new Exception("Error! File Not Exist.");
            }
            FileOutputStream output = new FileOutputStream(pathFile, isContinuing);
            output.write(content.getBytes());
            System.out.println("Viết thành công");
            output.close();
        }

        catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void writeObject(Object object, String path, String fileName) {
        FileOutputStream output = null;
        ObjectOutputStream outputStream = null;
        try {
            if (object == null)
                throw new Exception("Error! Object is Null.");

            if (!new File(path).exists()){
                Exercise_3.createNewFolder(path);
                output = new FileOutputStream(path + "\\" + fileName);
                outputStream = new ObjectOutputStream(output);
                outputStream.writeObject(object);
            }
            else {
                output = new FileOutputStream(path + "\\" + fileName);
                outputStream = new ObjectOutputStream(output);
                outputStream.writeObject(object);
            }

            // Tạo luồng ghi

            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public  static ArrayList<Object> readObject(String pathName) throws IOException, ClassNotFoundException {
        FileInputStream input = null;
        ObjectInputStream outputStream = null;
        Object obj = null;
        ArrayList<Object> list = new ArrayList<>();
        try{
            if (!new File(pathName).exists())
                Exercise_3.createNewFolder(pathName);

            input = new FileInputStream(pathName);
            outputStream = new ObjectInputStream(input);



            while (true) {
                try {
                    obj = outputStream.readObject();
                    list.add(obj);
                } catch (EOFException e) {
                    // Khi kết thúc luồng, ngoại lệ EOFException sẽ được ném. Điều này đánh dấu kết thúc của tệp.
                    break;
                }
            }
            outputStream.close();
        }

        catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }


}
