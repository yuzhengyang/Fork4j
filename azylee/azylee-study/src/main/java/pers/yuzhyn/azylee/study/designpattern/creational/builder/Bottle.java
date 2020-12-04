package pers.yuzhyn.azylee.study.designpattern.creational.builder;

public class Bottle implements Packing {

    @Override
    public String pack() {
        return "Bottle";
    }
}