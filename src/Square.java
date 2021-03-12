public class Square extends Shape{
    //We can define a square by two opposite points.
    Point2D cornerA,cornerB;
    Square(Point2D pointA,Point2D pointB) {
        super(new Point2D((pointA.getX()+pointB.getX())/2,(pointA.getY()+pointB.getY())/2), ShapeType.SQUARE);
        cornerA=pointA;
        cornerB=pointB;
    }
    double getArea(){
        return Math.abs(cornerA.getX()-cornerB.getX())*Math.abs(cornerA.getY()-cornerB.getY());
    }
    double getPerimeter(){
        return Math.abs(cornerA.getX()-cornerB.getX())*2+Math.abs(cornerA.getY()-cornerB.getY())*2;
    }


}
