package pers.yuzhyn.azylee.study.designpattern.creational.absfactory;

import pers.yuzhyn.azylee.study.designpattern.basedata.colors.Color;
import pers.yuzhyn.azylee.study.designpattern.basedata.shapres.Shape;

public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape) ;
}