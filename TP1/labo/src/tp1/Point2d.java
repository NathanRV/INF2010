package tp1;

import java.util.Vector;

public class Point2d extends AbstractPoint {
    private final Integer X = 0;
    private final Integer Y = 1;

    // creer un point en 2d avec 2 donnees
    public Point2d(Double x, Double y) {
        super(new Double[]{x, y});
    }

    // creer un point a partir d'un vecteur de donnees
    public Point2d(Double[] vector) {
        super(vector.clone());
    }

    public Double X() { return vector[X];}
    public Double Y() { return vector[Y];}

    // prendre un vecteur de donnees et appliquer la translation.
    @Override
    public Point2d translate(Double[] translateVector) {
        Point2d point2d=new Point2d(this.vector);
        point2d.vector=PointOperator.translate(this.vector,translateVector);
        return point2d;
    }

    // prendre un point et appliquer la translation.
    public Point2d translate(Point2d translateVector) {
        Point2d point2d=new Point2d(this.vector);
        point2d.vector=PointOperator.translate(this.vector,translateVector.vector);
        return point2d;
    }

    // prendre un vecteur de donnees et appliquer la rotation.
    @Override
    public Point2d rotate(Double[][] rotationMatrix) {
        Point2d point2d=new Point2d(this.vector);
        point2d.vector=PointOperator.rotate(this.vector,rotationMatrix);
        return point2d;
    }

    // prendre un angle de rotation, creer une matrice et appliquer la rotation.
    public Point2d rotate(Double angle) {
        Double[][] rotationMatrix={{Math.cos(angle),-Math.sin(angle)},
                                    {Math.sin(angle),Math.cos(angle)}};
        Point2d point2d=new Point2d(this.vector);
        point2d.vector=PointOperator.rotate(this.vector,rotationMatrix);
        return point2d;
    }

    // prendre un facteur de division et l'appliquer.
    @Override
    public Point2d divide(Double divider) {
        Point2d point2d=new Point2d(this.vector);
        point2d.vector=PointOperator.divide(this.vector,divider);
        return point2d;
    }

    // prendre un facteur de multiplication et l'appliquer.
    @Override
    public Point2d multiply(Double multiplier) {
        Point2d point2d=new Point2d(this.vector);
        point2d.vector=PointOperator.multiply(this.vector,multiplier);
        return point2d;
    }

    // prendre un facteur d'addition et l'appliquer.
    @Override
    public Point2d add(Double adder) {
        Point2d point2d=new Point2d(this.vector);
        point2d.vector=PointOperator.add(this.vector,adder);
        return point2d;
    }

    // creer un nouveau point.
    @Override
    public Point2d clone() {
        Point2d point=new Point2d(this.vector);
        return point;
    }
}
