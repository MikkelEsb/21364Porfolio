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

    //alternative method for calculating area from points
    //https://en.wikipedia.org/wiki/Triangle#Using_coordinates
    //Also known as Shoelace formula https://en.wikipedia.org/wiki/Shoelace_formula#Proof_for_a_triangle
    double getAreaFromPoints(Point2D A, Point2D B, Point2D C){
        return Math.abs(
                (A.getX()*(B.getY()-C.getY())   // (Ax*(By-Cy)+
                +B.getX()*(C.getY()-A.getY())   //  Bx*(Cy-Ay)+
                +C.getX()*(A.getY()-B.getY()))  //  Cx*(Ay-By))
                /2.0);                          // /2
    }
    boolean isPointInTriangle(Point2D P){
        //Area of our triangle
        double ABC=getAreaFromPoints(A,B,C);
        //3 triangles area, made of the point and two other points of our triangle
        double PBC=getAreaFromPoints(P,B,C);
        double PAC=getAreaFromPoints(P,A,C);
        double PAB=getAreaFromPoints(P,A,B);

        //Compare the values
        return (ABC==PBC+PAC+PAB);

    }
    public double getPerimeter() {
        return perimeter;
    }

}
