package tp1;

import java.util.Set;

public class Ellipse extends BaseShape {
    // creer une ellipse avec une largeur et une longueur.
    public Ellipse(Double widthRadius, Double heightRadius) {
        super();
        double originWidth = widthRadius/2;
        double originHeight = heightRadius/2;
        for(int i = 0; i < widthRadius.intValue(); i++) {

            //cree une ellipse a partir formule mathematique

            this.add(new Point2d(( i - originWidth), originHeight* Math.sqrt(1-(Math.pow((-widthRadius/2+i)/originWidth,2)))));
            this.add(new Point2d(( i - originWidth), originHeight*(-Math.sqrt(1-(Math.pow((-widthRadius/2+i)/originWidth,2))))));
        }
        for(int j = 0; j < heightRadius.intValue(); j++) {
            this.add(new Point2d(originWidth*Math.sqrt(1-(Math.pow((-heightRadius/2+j)/originHeight,2))),(j - originHeight)));
            this.add(new Point2d((originWidth*(-Math.sqrt(1-(Math.pow((-heightRadius/2+j)/originHeight,2))))),(j - originHeight)));
        }


    }

    private Ellipse(Set<Point2d> coords) {
        super(coords);
    }

    // appliquer la translation sur la forme.
    @Override
    public Ellipse translate(Point2d point) {
        return new Ellipse(translateAll(point));
    }

    // appliquer la rotation sur la forme.
    @Override
    public Ellipse rotate(Double angle) {
        return new Ellipse(rotateAll(angle));
    }

    // retourner une nouvelle forme.
    @Override
    public Ellipse clone() { return new Ellipse(getCoords()); }
}
