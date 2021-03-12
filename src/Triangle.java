public class Triangle extends Shape{
    private Point2D A;
    private Point2D B;
    private Point2D C;

    //A triangle can be defined multiple ways, let's start with 3 points in 2 dimensions
    Triangle(Point2D A, Point2D B, Point2D C){
        //Since our shape class needs a center we calculate the centroid and constructs from the super.
        super(ShapeType.TRIANGLE);
        this.A=A;
        this.B=B;
        this.C=C;
        this.setCenter(generateCentroid());




    }
    private Point2D generateCentroid(){
        return new Point2D((A.getX()+B.getX()+C.getX())/3,(A.getY()+B.getY()+C.getY())/3);
    }

    /**
     * @return Area of the triangle
     */
    double getArea(){
        return getAreaFromPoints(A,B,C);
    }

    /**
     * @param A Point A
     * @param B Point B
     * @param C Point C
     * @return Area from a triangle defined by 3 points
     */
    //alternative method for calculating area from points
    //https://en.wikipedia.org/wiki/Triangle#Using_coordinates
    //Also known as Shoelace formula https://en.wikipedia.org/wiki/Shoelace_formula#Proof_for_a_triangle
    private double getAreaFromPoints(Point2D A, Point2D B, Point2D C){
        return Math.abs(
                (A.getX()*(B.getY()-C.getY())   // (Ax*(By-Cy)+
                +B.getX()*(C.getY()-A.getY())   //  Bx*(Cy-Ay)+
                +C.getX()*(A.getY()-B.getY()))  //  Cx*(Ay-By))
                /2);                          // /2
    }
    boolean containsPoint(Point2D P){
        //Area of our triangle
        double ABC=getAreaFromPoints(A,B,C);
        //3 triangles area, made of the point and two other points of our triangle
        double PBC=getAreaFromPoints(P,B,C);
        double PAC=getAreaFromPoints(P,A,C);
        double PAB=getAreaFromPoints(P,A,B);

        //Compare the values
        return (ABC==PBC+PAC+PAB);

    }
    double getPerimeter() {
        return A.distanceToPoint(B) + A.distanceToPoint(C)+B.distanceToPoint(C);
    }

    @Override
    void rotate(double radians){
        //Rotate each point around our center
        A=rotateAroundPoint(radians,this.getCenter(),A);
        B=rotateAroundPoint(radians,this.getCenter(),B);
        C=rotateAroundPoint(radians,this.getCenter(),C);
        this.setCenter(generateCentroid());

    }

    void translate(double deltaX, double deltaY){
        //Move each point by dX and dY
        A.translate(deltaX,deltaY);
        B.translate(deltaX,deltaY);
        C.translate(deltaX,deltaY);
    }
}
