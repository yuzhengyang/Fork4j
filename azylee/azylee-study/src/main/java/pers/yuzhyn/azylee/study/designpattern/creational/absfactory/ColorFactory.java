package pers.yuzhyn.azylee.study.designpattern.creational.absfactory;

import pers.yuzhyn.sugar.common.utils.designpattern.basedata.colors.Blue;
import pers.yuzhyn.sugar.common.utils.designpattern.basedata.colors.Color;
import pers.yuzhyn.sugar.common.utils.designpattern.basedata.colors.Green;
import pers.yuzhyn.sugar.common.utils.designpattern.basedata.colors.Red;
import pers.yuzhyn.sugar.common.utils.designpattern.basedata.shapres.Shape;

public class ColorFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType){
        return null;
    }

    @Override
    public Color getColor(String color) {
        if(color == null){
            return null;
        }
        if(color.equalsIgnoreCase("RED")){
            return new Red();
        } else if(color.equalsIgnoreCase("GREEN")){
            return new Green();
        } else if(color.equalsIgnoreCase("BLUE")){
            return new Blue();
        }
        return null;
    }
}