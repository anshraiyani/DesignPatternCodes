package com.ansh;

import java.util.ArrayList;
import java.util.List;

// concrete class for mementos
class FineMemento{
    private String type;
    private String date;
    private int amount;

    public FineMemento(String type, String date, int amount) {
        this.type = type;
        this.date = date;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }
}

//concrete class for all the info regarding fines
class Fine{
    private String type;
    private String date;
    private int amount;

    private List<FineMemento> hisory = new ArrayList<>();

    public Fine(String type, String date, int amount) {
        this.type = type;
        this.date = date;
        this.amount = amount;
        saveState();
    }

    void saveState(){
        FineMemento memento = new FineMemento(type,date,amount);
        hisory.add(memento);
    }

    public void setType(String type) {
        this.type = type;
        saveState();
    }

    public void setDate(String date) {
        this.date = date;
        saveState();
    }

    public void setAmount(int amount) {
        this.amount = amount;
        saveState();
    }

    void undo(){
        if(hisory.size()>1){
            FineMemento memento = hisory.get(hisory.size()-2);
            type=memento.getType();
            date=memento.getDate();
            amount=memento.getAmount();
            hisory.remove(hisory.size()-1);
        }
    }

    void printDetails(){
        System.out.println("Fined for: "+type+" | Date: "+date+" | Amount: "+amount);
    }
}

public class MementoDesignPatternClient {
    public static void main(String[] args) {
        Fine f = new Fine("speeding","12-09-23",1200);
        System.out.println("Before:");
        f.printDetails();
        System.out.println("");

        f.setType("Wrong side driving");
        f.setDate("13-09-23");
        f.setAmount(500);
        System.out.println("After Updating:");
        f.printDetails();
        System.out.println("");

        System.out.println("Undo 1");
        f.undo();
        f.printDetails();
        System.out.println("Undo 2");
        f.undo();
        f.printDetails();
        System.out.println("Undo 3");
        f.undo();
        f.printDetails();
    }
}