package tp1;

import java.util.*;

public final class PointOperator {
    // TODO appliquer la translation sur le vecteur d'entree.
    public static Double[] translate(Double[] vector, Double[] translateVector) {
        Double[] secondVector=vector.clone();
        for(int i=0;i<secondVector.length;i++){
            secondVector[i]+=translateVector[i];
        }
        return secondVector;
    }

    // TODO appliquer la rotation sur le vecteur d'entree.
    public static Double[] rotate(Double[] vector, Double[][] rotationMatrix) {
        Double[] secondVector=vector.clone();
        for(int i=0;i<secondVector.length;i++){
            double val=0;
            for(int j=0;j<secondVector.length;j++){
                val+=rotationMatrix[i][j]*vector[j];
            }
            secondVector[i]=val;
        }
        return secondVector;
    }

    // TODO appliquer le facteur de division sur le vecteur d'entree.
    public static Double[] divide(Double[] vector, Double divider) {
        Double[] secondVector=vector.clone();
        for(int i=0;i<secondVector.length;i++){
            secondVector[i]/=divider;
        }
        return secondVector;
    }

    // TODO appliquer le facteur de multiplication sur le vecteur d'entree.
    public static Double[] multiply(Double[] vector, Double multiplier) {
        Double[] secondVector=vector.clone();
        for(int i=0;i<secondVector.length;i++){
            secondVector[i]*=multiplier;
        }
        return secondVector;
    }

    // TODO appliquer le facteur d'addition sur le vecteur d'entree.
    public static Double[] add(Double[] vector, Double adder) {
        Double[] secondVector=vector.clone();
        for(int i=0;i<secondVector.length;i++){
            secondVector[i]+=adder;
        }
        return secondVector;
    }

    // TODO retourne la coordonnee avec les plus grandes valeurs en X et en Y.
    public static Point2d getMaxCoord(Collection<Point2d> coords) {
        ArrayList<Double> x = new ArrayList<>();
        ArrayList<Double> y= new ArrayList<>();

        Iterator<Point2d> itr = coords.iterator();
        Point2d point;

        while (itr.hasNext()){
            point= itr.next();
            x.add(point.X());
            y.add(point.Y());
        }
        return new Point2d(Collections.max(x), Collections.max(y));
    }

    // TODO retourne la coordonnee avec les plus petites valeurs en X et en Y.
    public static Point2d getMinCoord(Collection<Point2d> coords) {
        ArrayList<Double> x = new ArrayList<>();
        ArrayList<Double> y= new ArrayList<>();

        Iterator<Point2d> itr = coords.iterator();
        Point2d point;

        while (itr.hasNext()){
            point= itr.next();
            x.add(point.X());
            y.add(point.Y());
        }
        return new Point2d(Collections.min(x), Collections.min(y));
}
}
