public class Rectangle extends Shape{
    //We can define a rectangle by two opposite points.
    private Point2D cornerA,cornerB;
    //For rotation we will rotate the shape around it's center but save the rotation done for containsPoint calculation
    private double rotation=0d;
    private Point2D cornerC,cornerD;

    /**
     * @param pointA One corner of the rectangle
     * @param pointB Opposite corner of the rectangle
     */
    Rectangle(Point2D pointA, Point2D pointB) {
        super(ShapeType.RECTANGLE);
        cornerA=pointA;
        cornerB=pointB;
        this.setCenter(calculateCenter());

    }
    private Point2D calculateCenter(){
        return new Point2D((cornerA.getX()+cornerB.getX())/2,(cornerA.getY()+cornerB.getY())/2);
    }
    double getArea(){
        return Math.abs(cornerA.getX()-cornerB.getX())*Math.abs(cornerA.getY()-cornerB.getY());
    }
    double getPerimeter(){
        return Math.abs(cornerA.getX()-cornerB.getX())*2+Math.abs(cornerA.getY()-cornerB.getY())*2;
    }

    @Override
    boolean containsPoint(Point2D p) {
        Point2D tempPoint=p;
        if (rotation!=0){//Rotate point around center
            tempPoint=tempPoint.getRotatedPoint(-rotation,this.getCenter());
        }
        return tempPoint.getX() >= this.getMinX() && tempPoint.getX() <= this.getMaxX() && tempPoint.getY() >= this.getMinY() && tempPoint.getY() <= this.getMaxY();
    }

    private void generateOtherCorners(){
        if(cornerC==null || cornerD==null){
            //Corner C is beneath corner A
            cornerC=new Point2D(cornerA.getX(),cornerB.getY());
            //Corner D is above corner B
            cornerD=new Point2D(cornerB.getX(),cornerA.getY());
        }
    }

    /**
     * @param radRotation amount of radians to rotate the square around it's center
     */
    @Override
    void rotate(double radRotation){
        generateOtherCorners();
        /*
        cornerA.rotate(radRotation,this.getCenter());
        cornerB.rotate(radRotation,this.getCenter());
        cornerC.rotate(radRotation,this.getCenter());
        cornerD.rotate(radRotation,this.getCenter());

         */
        rotation+=radRotation;
    }

    void translate(double deltaX, double deltaY){
        this.cornerA.translate(deltaX,deltaY);
        this.cornerB.translate(deltaX,deltaY);
        this.getCenter().translate(deltaX,deltaY);
    }
    private boolean hasExtraCorners(){
        return cornerC!=null;
    }

    double getMinX() {
        if (hasExtraCorners()){
            return Math.min(Math.min(cornerA.getX(),cornerB.getX()),Math.min(cornerC.getX(),cornerD.getX()));
        }
        return Math.min(cornerA.getX(),cornerB.getX());
    }

    double getMaxX() {
        if (hasExtraCorners()){
            return Math.max(Math.max(cornerA.getX(),cornerB.getX()),Math.max(cornerC.getX(),cornerD.getX()));
        }
        return Math.max(cornerA.getX(),cornerB.getX());
    }

    double getMinY() {
        if (hasExtraCorners()){
            return Math.min(Math.min(cornerA.getY(),cornerB.getY()),Math.min(cornerC.getY(),cornerD.getY()));
        }
        return Math.min(cornerA.getY(),cornerB.getY());
    }

    double getMaxY() {
        if (hasExtraCorners()){
            return Math.max(Math.max(cornerA.getY(),cornerB.getY()),Math.max(cornerC.getY(),cornerD.getY()));
        }
        return Math.max(cornerA.getY(),cornerB.getY());
    }


    @Override
    public String toString() {
        return "Rectangle{" +
                "cornerA=" + cornerA +
                ", cornerB=" + cornerB +
                ", rotation=" + rotation +
                ", cornerC=" + cornerC +
                ", cornerD=" + cornerD +
                '}';
    }
}
