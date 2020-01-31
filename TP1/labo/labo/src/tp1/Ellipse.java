package tp1;

import java.util.Set;

public class Ellipse extends BaseShape {
    // TODO creer une ellipse avec une largeur et une longueur.
    public Ellipse(Double widthRadius, Double heightRadius) {
              for(double i = -widthRadius; i <= widthRadius; i++){

                for(double j = -heightRadius; j <= heightRadius; j+=0.25){
                    double valeurEllipse = Math.pow(i/widthRadius, 2) + Math.pow(j/heightRadius, 2);

                    if(valeurEllipse <= 1 && valeurEllipse >= 0.7){
                        add(new Point2d(i ,j));
                    }
                }
            }


    }

    private Ellipse(Set<Point2d> coords) {
        super(coords);
    }

    // TODO appliquer la translation sur la forme.
    @Override
    public Ellipse translate(Point2d point) {
        return new Ellipse(translateAll(point));
    }

    // TODO appliquer la rotation sur la forme.
    @Override
    public Ellipse rotate(Double angle) {
        return new Ellipse(rotateAll(angle));
    }

    // TODO retourner une nouvelle forme.
    @Override
    public Ellipse clone() { return new Ellipse(getCoords()); }
}
