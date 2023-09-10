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
    public static void createNewFile(String path, String fileName){
        try {
            if (isFileExists(path + "\\" + fileName))
                throw new Exception("Error! File Exist.");
            File file = new File(path + "\\" + fileName); // ->> Chú ý vào OS: Mac và Linux, và '+' (Dễ xảy ra lỗi trong trường hợp dùng ký tự đặc biệt ^^
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
        /*
        File file = new File(pathFile);
        return file.isDirectory();
         */
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
            System.out.println("Copy file thành công");

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

            Path oldPath = Paths.get(sourceFile);
            Path newpath = Paths.get(newPath + "\\" + oldPath.getFileName());

            if ( Exercise_3.isFileExists( newpath.toString() ) )
                throw new Exception("Error! newPath has File same name.");

            Files.copy( oldPath, newpath);
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
            Path oldPath = Paths.get(pathFile);
            Path newPath = Paths.get(oldPath.getParent() + "\\" + newName);
            File file = new File(oldPath.toString());



            if (Exercise_3.isFileExists(oldPath.getParent() + "\\" + newName))
                throw new Exception("Error! Name is Exist.");

            File newFile = new File(oldPath.getParent() + "\\" + newName);

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
