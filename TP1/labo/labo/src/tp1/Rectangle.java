package tp1;

import java.util.Set;

public class Rectangle extends BaseShape {
    // TODO creer un rectangle avec une largeur et une longueur.
    public Rectangle(Double width, Double height) {
        super();
        Point2d point=new Point2d(width,height);
        super.add(point);
    }

    // TODO creer un rectangle avec un point contenant la largeur et longueur.
    public Rectangle(Point2d dimensions) {
        super();
        super.add(dimensions);
    }

    private Rectangle(Set<Point2d> coords) {
        super(coords);
    }

    // TODO appliquer la translation sur la forme.
    @Override
    public Rectangle translate(Point2d point) {
        Rectangle rectangle=this.clone();
        for(Point2d point2d:rectangle.getCoords()){
            point2d.translate(point);
        }
        return rectangle;
    }

    // TODO appliquer la rotation sur la forme.
    @Override
    public Rectangle rotate(Double angle) {
        Rectangle rectangle=this.clone();
        for (Point2d point:rectangle.getCoords()) {
            point.rotate(angle);
        }
        return rectangle;
    }

    // TODO retourner une nouvelle forme.
    @Override
    public Rectangle clone() {
        Rectangle rectangle=new Rectangle(this.getCoords());
        return rectangle;
    }
}
