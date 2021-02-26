public class Triangle extends Shape{
    private Point2D A,B,C;
    private double AB,AC,BC;
    private double perimeter;

    //A triangle can be defined multiple ways, let's start with 3 points in 2 dimensions
    Triangle(Point2D A, Point2D B, Point2D C){
        //Since our shape class needs a center we calculate the centroid and constructs from the super.
        super(new Point2D((A.getX()+B.getX()+C.getX())/3,(A.getY()+B.getY()+C.getY())/3),ShapeType.TRIANGLE);
        //Once constructed from the super we save each points to this triangle and calculate the distances of the lengths
        this.A=A;
        this.B=B;
        this.C=C;
        AB = A.distanceToPoint(B);
        AC = A.distanceToPoint(C);
        BC = B.distanceToPoint(C);
        perimeter=AB+AC+BC;


    }
    Point2D generateCentroidForThreePoints(Point2D A, Point2D B, Point2D C){
        return new Point2D((A.getX()+B.getX()+C.getX())/3,(A.getY()+B.getY()+C.getY())/3);
    }

    //Calculate each length of sides of the triangle.
    //Using Heron's Formula
    double getArea(){
        double semiPerim=perimeter/2;
        return Math.sqrt(semiPerim*(semiPerim-AB)*(semiPerim-AC)*(semiPerim-BC));
    }

    public double getPerimeter() {
        return perimeter;
    }

}
