package pers.yuzhyn.azylee.study.designpattern.structural.decorator;

public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}