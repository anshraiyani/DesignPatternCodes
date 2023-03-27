package com.ansh;

import java.util.ArrayList;
import java.util.List;

class Data {
    private int person_id;
    private String name;

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Data{" +
                "person_id=" + person_id +
                ", name='" + name + '\'' +
                '}';
    }
}

class RtoData implements Cloneable{
    private String date;
    List<Data> data = new ArrayList<>();

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public void loadData(){
        for (int i = 1; i <= 2; i++) {
            Data d = new Data();
            d.setPerson_id(i);
            d.setName("Person "+i);
            getData().add(d);
        }
    }

    @Override
    public String toString() {
        return "RtoData{" +
                "date='" + date + '\'' +
                ", data=" + data +
                '}';
    }

    @Override
    protected RtoData clone() throws CloneNotSupportedException {
        RtoData r = new RtoData();
        for (Data d: getData()) {
            r.getData().add(d);
        }
        return r;
    }
}

public class Assignment3 {
    public static void main(String[] args) throws CloneNotSupportedException{
        RtoData r1 = new RtoData();
        r1.setDate("12-09-2022");
        r1.loadData();

        RtoData r2 = (RtoData)r1.clone();
        r1.getData().remove(1);
        r2.setDate("13-09-2022");
        System.out.println(r1);
        System.out.println(r2);
    }
}
