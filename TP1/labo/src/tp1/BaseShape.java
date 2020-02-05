package tp1;

import org.apache.commons.beanutils.ResultSetIterator;

import java.util.*;
import java.util.stream.Collectors;

public class BaseShape {
      private Set<Point2d> coords;

    // TODO Initialiser les points.
    public BaseShape() {
        coords=new HashSet<>();
    } //create a new collection for the points

    // TODO prendre une liste de points et creer une nouvelle forme.
    public BaseShape(Collection<Point2d> coords) {
        this.coords=new HashSet<>(); // initialize the points
        this.coords.addAll(coords);//add all the points
    }

    // TODO ajouter ou retirer des coordonnees a la liste de points.
    public void add(Point2d coord) {
        this.coords.add(coord);
    }
    public void add(BaseShape shape) {
        coords.addAll(shape.getCoords());
    }
    public void addAll(Collection<Point2d> coords) {
        this.coords.addAll(coords);
    }
    public void remove(Point2d coord) {
        coords.remove(coord);
    }
    public void remove(BaseShape shape) {
           coords.removeAll(shape.getCoords());
    }
    public void removeAll(Collection<Point2d> coords) {
        this.coords.removeAll(coords);
    }

    // TODO retourne les coordonnees de la liste.
    public Set<Point2d> getCoords() {
        Set<Point2d> set=new HashSet<Point2d>();
        set.addAll(coords);
        return set;
    }

    // TODO appliquer la translation sur la forme.
    public BaseShape translate(Point2d point) {
        BaseShape baseShape=clone();
        baseShape.coords=baseShape.translateAll(point);// translate one point from the coordinates in BaseShape
        return baseShape;
    }

    // TODO appliquer la translation sur la liste.
    public Set<Point2d> translateAll(Point2d point) {
        Set<Point2d> set=new HashSet<Point2d>();

        for(Point2d point2d : coords) {
          set.add(point2d.translate(point));
        }

        return set;
    }

    // TODO appliquer la rotation sur la forme.
    public BaseShape rotate(Double angle) {
        BaseShape baseShape=this.clone();
        baseShape.coords=baseShape.rotateAll(angle);
        return baseShape;
    }

    // TODO appliquer la rotation sur la liste.
    public Set<Point2d> rotateAll(Double angle) {
        HashSet<Point2d> set=new HashSet<Point2d>(coords);

        for (Point2d pt: coords) {
           set.remove(pt);
           set.add(pt.rotate(angle));
        }
        return set;
    }

    // TODO retourner une nouvelle forme.
    public BaseShape clone() {
        BaseShape baseShape=new BaseShape(this.coords);
        return baseShape;
    }
}
