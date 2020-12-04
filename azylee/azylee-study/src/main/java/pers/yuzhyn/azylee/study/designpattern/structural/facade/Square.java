package pers.yuzhyn.azylee.study.designpattern.structural.facade;

public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Square::draw()");
    }
}