package tp1;

import org.w3c.dom.css.Rect;

import java.util.Set;

public class Rectangle extends BaseShape {
    // TODO creer un rectangle avec une largeur et une longueur.
    public Rectangle(Double width, Double height) {
        super();
       Double halfWidth = width/2;
       Double halfHeight= height/2;
       //created a rectangle with the center as origin
        for (double i=-halfWidth; i<=halfWidth; i++){
            for (double j=-halfHeight; j<= halfHeight; j++){
                this.add(new Point2d(i,j));
            }
        }
    }

    // TODO creer un rectangle avec un point contenant la largeur et longueur.
    public Rectangle(Point2d dimensions) {
        this.add(dimensions);
    }

    private Rectangle(Set<Point2d> coords) {
        super(coords);
    }

    // TODO appliquer la translation sur la forme.
    @Override
    public Rectangle translate(Point2d point) {
      return new Rectangle(translateAll(point));
        }

    // TODO appliquer la rotation sur la forme.
    @Override
    public Rectangle rotate(Double angle) { return new Rectangle (rotateAll(angle));
    }

    // TODO retourner une nouvelle forme.
    @Override
    public Rectangle clone() {
        Rectangle rectangle=new Rectangle(this.getCoords());
        return rectangle;
    }
}
