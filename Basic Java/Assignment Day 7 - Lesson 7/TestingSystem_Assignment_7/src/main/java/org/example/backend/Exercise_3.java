package org.example.backend;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Exercise_3 {
    public static boolean isFileExists(String pathFile){
        File file = new File(pathFile);
        return file.exists();
    }

    public static void createNewFile(String pathFile){
        try {
            if (isFileExists(pathFile))
                throw new Exception("Error! File Exist.");
            File file = new File(pathFile);
            if ( file.createNewFile() )
                System.out.println("Tạo file thành công");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void createNewFile(String pathFile, String fileName){
        try {
            if (isFileExists(pathFile + "//" + fileName))
                throw new Exception("Error! File Exist.");
            File file = new File(pathFile + "//" + fileName);
            if ( file.createNewFile() )
                    System.out.println("Tạo file thành công");

        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Tạo file thất bại");
        }
    }

    public static void deleteFile(String pathFile){
        if ( new File(pathFile).delete() )
                System.out.println("Xóa file thành công ^^");
        else    System.out.println("Xóa file thất bại ^^");
    }

    public static boolean isFolder(String pathFile){
        return new File(pathFile).isDirectory();
    }

    public static ArrayList<String> getAllFileName(String path){
        ArrayList<String> list = new ArrayList<>();

        try {
            if ( !Exercise_3.isFolder(path) )
                throw new Exception("Error! Path is not folder");
            File file = new File(path);
            for (String i: file.list()){
                list.add(i);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    public static void copyFile(String sourceFile, String distinationPath, String newName){
        try {
            if ( !Exercise_3.isFileExists(sourceFile) )
                throw new Exception("Error! Source File Not Exist.");
            if ( Exercise_3.isFileExists(distinationPath + "//" + newName))
                throw new Exception("Error! newPath has File same name.");

            Exercise_3.createNewFile(distinationPath, newName);
            System.out.println("Cpoy file thành công");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Cpoy file thất bại");
        }
    }

    public static void copyFile(String sourceFile, String newPath){
        try {
            if ( !Exercise_3.isFileExists(sourceFile) )
                throw new Exception("Error! Source File Not Exist.");

            String [] list = sourceFile.split("\\\\");
            if ( Exercise_3.isFileExists( newPath + list[list.length -1]))
                throw new Exception("Error! newPath has File same name.");

            Exercise_3.createNewFile(newPath + "\\" +list[list.length -1]);
            System.out.println("Cpoy file thành công");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Cpoy file thất bại");
        }
    }

    public static void moveFile(String sourceFile, String destinationPath){
        try {
            if (!Exercise_3.isFileExists(sourceFile))
                throw new Exception("Error! File Not Exist");
            if (Exercise_3.isFileExists(destinationPath))
                throw new Exception("Error! destinationPath is already exists");

            File file = new File(sourceFile);
            File newFile = new File(destinationPath);

            file.renameTo(newFile);
            System.out.println("Di chuyển thành công ^^");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public static void renameFile(String pathFile, String newName){
        try {

            if (!Exercise_3.isFileExists(pathFile))
                throw new Exception("Error! File Not Exist");
            File file = new File(pathFile);
            String [] list = pathFile.split("\\\\");
            String result = "";
            for (int i=0; i< list.length-1; i++){
                result += ( list[i] + "\\") ;
            }
            if (Exercise_3.isFileExists(result + "\\" + newName))
                throw new Exception("Error! Name is Exist.");
            File newFile = new File(result + "\\" + newName);
            System.out.println(result + "\\" + newName);

            file.renameTo(newFile);
            System.out.println("Đổi tên thành công ^^");
        }

        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void createNewFolder(String newPath){
        try {
            if (!isFileExists(newPath))
                throw new Exception("Error! Foldere Exist.");


            Path folder = Paths.get(newPath);
            Files.createDirectories(folder);
            System.out.println("Thư mục đã được tạo thành công!");

        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Tạo folder thất bại");
        }
    }

    //Câu 11 đáp án tham khảo trong đề

}
