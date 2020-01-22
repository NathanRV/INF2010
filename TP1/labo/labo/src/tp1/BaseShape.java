package tp1;

import java.util.*;
import java.util.stream.Collectors;

public class BaseShape {
    // Vous aller apprendre plus en details le fonctionnement d'un Set lors
    // du cours sur les fonctions de hashage, vous pouvez considerez ceci comme une liste normale.
    private Set<Point2d> coords;

    // TODO Initialiser les points.
    public BaseShape() {
        coords=new HashSet<>();
    }

    // TODO prendre une liste de points et creer une nouvelle forme.
    public BaseShape(Collection<Point2d> coords) {
        this.coords=new HashSet<>();
        this.coords.addAll(coords);
    }

    // TODO ajouter ou retirer des coordonnees a la liste de points.
    public void add(Point2d coord) {
        coords.add(coord);
    }
    public void add(BaseShape shape) {
        /*for (Point2d point:shape.getCoords()) {
            coords.add(point);
        }*/
        coords.addAll(shape.getCoords());
    }
    public void addAll(Collection<Point2d> coords) {
        this.coords.addAll(coords);
    }
    public void remove(Point2d coord) {
        coords.remove(coord);
    }
    public void remove(BaseShape shape) {
        /*for (Point2d point :
                shape.getCoords()) {
            coords.remove(point);
        }*/
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
        for (Point2d pt:coords) {
            pt.translate(point);
        }
        return this;
    }

    // TODO appliquer la translation sur la liste.
    public Set<Point2d> translateAll(Point2d point) {
        for (Point2d pt:coords) {
            pt.translate(point);
        }
        return coords;
    }

    // TODO appliquer la rotation sur la forme.
    public BaseShape rotate(Double angle) {
        for (Point2d pt:coords) {
            pt.rotate(angle);
        }
        return this;
    }

    // TODO appliquer la rotation sur la liste.
    public Set<Point2d> rotateAll(Double angle) {
        for (Point2d pt:coords) {
            pt.rotate(angle);
        }
        return coords;
    }

    // TODO retourner une nouvelle forme.
    public BaseShape clone() {
        BaseShape baseShape=new BaseShape(this.coords);
        return baseShape;
    }
}
