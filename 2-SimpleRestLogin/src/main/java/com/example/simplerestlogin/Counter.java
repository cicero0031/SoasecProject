package com.example.simplerestlogin;

public class Counter {

    private final String name;
    private final int id;
    private int count;

    public Counter(int id, String name, int counter){
        this.id = id;
        this.name = name;
        this.count = counter;
    }

    public Counter(int id, String name){
        this.id = id;
        this.name = name;
        this.count = 0;
    }
    //NB: getter are necessary for better work of serializzation/deserializzation process and private attribute

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getCount() {
        return count;
    }

    public void increment(){
        count =+ 1;
    }

    public void decrement(){
        count =- 1;
    }

    public void resetCounter(){
        count = 0;
    }

    public void setCounter(int n){
        count = n;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", count=" + count +
                '}';
    }
}
