package pers.yuzhyn.azylee.study.designpattern.creational.absfactory;

import pers.yuzhyn.sugar.common.utils.designpattern.basedata.colors.Color;
import pers.yuzhyn.sugar.common.utils.designpattern.basedata.shapres.Shape;

public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape) ;
}