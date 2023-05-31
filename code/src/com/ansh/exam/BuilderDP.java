package com.ansh.exam;

class Sandwich{
    String bread;
    String meat;
    String cheese;
    String topping;

    public Sandwich(String bread, String meat, String cheese, String topping) {
        this.bread = bread;
        this.meat = meat;
        this.cheese = cheese;
        this.topping = topping;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "bread='" + bread + '\'' +
                ", meat='" + meat + '\'' +
                ", cheese='" + cheese + '\'' +
                ", topping='" + topping + '\'' +
                '}';
    }
}

class SandwichBuilder{
    String bread;
    String meat;
    String cheese;
    String topping;

    public SandwichBuilder setBread(String bread) {
        this.bread = bread;
        return this;
    }

    public SandwichBuilder setMeat(String meat) {
        this.meat = meat;
        return this;
    }

    public SandwichBuilder setCheese(String cheese) {
        this.cheese = cheese;
        return this;
    }

    public SandwichBuilder setTopping(String topping) {
        this.topping = topping;
        return this;
    }

    public Sandwich getSandwich(){
        return new Sandwich(bread,meat,cheese,topping);
    }
}

public class BuilderDP {
    public static void main(String[] args) {
        Sandwich sandwich = new SandwichBuilder().setBread("bread").setTopping("topping").setCheese("cheese").setMeat("meat").getSandwich();
        System.out.println(sandwich.toString());
    }
}
