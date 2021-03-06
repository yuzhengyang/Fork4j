package pers.yuzhyn.azylee.study.designpattern.creational.absfactory;

import pers.yuzhyn.azylee.study.designpattern.basedata.colors.Color;
import pers.yuzhyn.azylee.study.designpattern.basedata.shapres.Circle;
import pers.yuzhyn.azylee.study.designpattern.basedata.shapres.Rectangle;
import pers.yuzhyn.azylee.study.designpattern.basedata.shapres.Shape;
import pers.yuzhyn.azylee.study.designpattern.basedata.shapres.Square;

public class ShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}