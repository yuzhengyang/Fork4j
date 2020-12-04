package pers.yuzhyn.azylee.study.designpattern.basedata.shapres;

public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}