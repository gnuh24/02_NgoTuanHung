package org.example.com.vti.entity;

public class NewAccount {
    private String id;
    private String name;
    private int balance ;

    public NewAccount(String id, String name, int balance){
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getID(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public int getBalance(){
        return this.balance;
    }

    public void credit(int amount){
        this.balance += amount;
    }

    public void debit(int amount){
        this.balance -= amount;
    }

    public void transferTo(NewAccount account, int amount){
        account.credit(amount);
        this.debit(amount);
    }

}
