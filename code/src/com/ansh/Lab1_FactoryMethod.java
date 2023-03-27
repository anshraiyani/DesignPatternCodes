package com.ansh;

interface Shape{
    void draw();
}

class Circle implements Shape{
    public void draw(){
        System.out.println("Drawing Circle");
    }
}
class Square implements Shape{
    public void draw(){
        System.out.println("Drawing Square");
    }
}
class Rectangle implements Shape{
    public void draw(){
        System.out.println("Drawing Rectangle");
    }
}

class shapeGenerate{
    public Shape getShape(String s){
        if(s.equals("CIRCLE")){
            return new Circle();
        }
        else if(s.equals("SQUARE")){
            return new Square();
        }
        else if(s.equals("RECTANGLE")){
            return new Rectangle();
        }
        return null;
    }
}

public class Lab1_FactoryMethod {

    public static void main(String[] args) {
        shapeGenerate sg1 = new shapeGenerate();
        Shape s1 = sg1.getShape("CIRCLE");
        s1.draw();
    }
}
