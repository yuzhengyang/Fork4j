package pers.yuzhyn.azylee.study.designpattern.basedata.colors;

public class Red implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}