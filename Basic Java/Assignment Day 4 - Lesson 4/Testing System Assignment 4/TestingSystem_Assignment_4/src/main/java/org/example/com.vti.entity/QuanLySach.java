package org.example.com.vti.entity;

import java.util.ArrayList;

public class QuanLySach {
    ArrayList<Book> listOfBook = new ArrayList<>();
    ArrayList<Magazine> listOfMagazine = new ArrayList<>();
    ArrayList<Articles> listOfArticles = new ArrayList<>();

    public void addBook(Book newBook){
        listOfBook.add(newBook);
        System.out.println("Đã thêm sách mới thành công");
    }
    public void addMagazine(Magazine newMagazine){
        listOfMagazine.add(newMagazine);
        System.out.println("Đã thêm tạp chí mới thành công");
    }
    public void addArticles(Articles newArticles){
        listOfArticles.add(newArticles);
        System.out.println("Đã thêm sách mới thành công");
    }

    public void deleteDocument(int id){
        boolean hasFound = false;

        Book deleteBook = null;
        for (Book i : listOfBook)
            if (i.getDocumentID() == id) {
                deleteBook = i;
                hasFound = true;
                break;
            }

        if (deleteBook != null) {
            listOfBook.remove(deleteBook);
            System.out.println("Đã xóa thành công !!");

        }
        if (!hasFound){
            Magazine deleteMagazine = null;
            for (Magazine i: listOfMagazine)
                if (i.getDocumentID() == id){
                    deleteMagazine = i;
                    hasFound = true;
                    break;
                }

            if (deleteMagazine != null) {
                listOfMagazine.remove(deleteMagazine);
                System.out.println("Đã xóa thành công !!");

            }
        }

        if (!hasFound){
            Articles deleteArticles = null;
            for (Articles i: listOfArticles)
                if (i.getDocumentID() == id){
                    deleteArticles = i;
                    hasFound = true;
                    break;
                }

            if (deleteArticles != null) {
                listOfArticles.remove(deleteArticles);
                System.out.println("Đã xóa thành công !!");
            }
        }
        if (!hasFound)
            System.out.println("Xóa thất bại :(( Không tìm thấy tài liệu bạn muốn xóa");


    }


    public Book findBook(int id){
        Book target = null;
        for (Book i: listOfBook)
            if (i.getDocumentID() == id) {
                target = i;
                break;
            }
        return target;
    }

    public Magazine findMagazine(int id){
        Magazine target = null;
        for (Magazine i: listOfMagazine)
            if (i.getDocumentID() == id) {
                target = i;
                break;
            }
        return target;
    }

    public Articles findArticles(int id){
        Articles target = null;
        for (Articles i: listOfArticles)
            if (i.getDocumentID() == id) {
                target = i;
                break;
            }
        return target;
    }


}
