package pers.yuzhyn.azylee.study.designpattern.creational.factory;

import pers.yuzhyn.sugar.common.utils.designpattern.basedata.shapres.Circle;
import pers.yuzhyn.sugar.common.utils.designpattern.basedata.shapres.Rectangle;
import pers.yuzhyn.sugar.common.utils.designpattern.basedata.shapres.Shape;
import pers.yuzhyn.sugar.common.utils.designpattern.basedata.shapres.Square;

public class ShapeFactory {

    //使用 getShape 方法获取形状类型的对象
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
}