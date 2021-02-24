public abstract class Shape {
    ShapeType type;
    Point2D center;

    Shape(int x, int y){
        center=new Point2D(x,y);
    }
    Shape(Point2D centerPoint){
        this.center=centerPoint;
    }
    ShapeType getType(){
        return this.type;
    }
    double getArea(){
        return 0;
    }
}
