package tp1;

public final class LetterFactory {
    final static Double maxHeight = 200.0;
    final static Double maxWidth = maxHeight / 2;
    final static Double halfMaxHeight = maxHeight / 2;
    final static Double halfMaxWidth = maxWidth / 2;
    final static Double stripeThickness = maxHeight / 10;

    // TODO
    public static BaseShape create_H() {

        //H
        Double degrees90 = Math.toRadians(90);
        Double spacing = stripeThickness * 2;
        BaseShape mainStripe = new Rectangle(stripeThickness, maxHeight);
        BaseShape leftStripe = mainStripe.translate(new Point2d(-spacing, 0.0));
        BaseShape middleStripe = mainStripe.rotate(degrees90);
        BaseShape rightStripe = mainStripe.translate(new Point2d(spacing, 0.0));
        leftStripe.add(middleStripe);
        leftStripe.add(rightStripe);
        return leftStripe;
    }

    // TODO
    public static BaseShape create_e() {
        //E
        Double degrees90 = Math.toRadians(90);
        Double spacing = stripeThickness * 2;
        BaseShape mainStripe = new Rectangle(stripeThickness, maxHeight);
        BaseShape leftStripe = mainStripe.translate(new Point2d(-spacing, 0.0));
        BaseShape halfStripe = new Rectangle(stripeThickness, maxHeight);
        BaseShape middleStripe = halfStripe.rotate(degrees90);
        BaseShape upStripe = halfStripe.rotate(degrees90).translate(new Point2d(0.0, spacing));
        BaseShape downStripe = halfStripe.rotate(degrees90).translate(new Point2d(0.0, -spacing));
        leftStripe.add(middleStripe);
        leftStripe.add(upStripe);
        leftStripe.add(downStripe);
        return leftStripe;
    }

    // TODO
    public static BaseShape create_l() {
        //L
        Double degrees90 = Math.toRadians(90);
        Double spacing = stripeThickness * 2;
        BaseShape mainStripe = new Rectangle(stripeThickness, maxHeight);
        BaseShape leftStripe = mainStripe.translate(new Point2d(-spacing, 0.0));
        BaseShape halfStripe = new Rectangle(stripeThickness, maxWidth);
        BaseShape downStripe = halfStripe.rotate(degrees90).translate(new Point2d(0.0, -spacing));
        leftStripe.add(downStripe);
        return leftStripe;
    }

    // TODO
    public static BaseShape create_o() {
        //O
        BaseShape ellipse = new Ellipse(halfMaxWidth,maxHeight/2);
        return ellipse;

    }

    // On vous donne la lettre W comme exemple.
    public static BaseShape create_W() {
        Double degrees15 = Math.toRadians(8);
        Double spacing = stripeThickness * 2;
        BaseShape mainStripe = new Rectangle(stripeThickness, maxHeight);
        BaseShape leftStripe = mainStripe.rotate(-degrees15).translate(new Point2d(-spacing, 0.0));
        BaseShape middleLeftStripe = mainStripe.rotate(degrees15).translate(new Point2d(-spacing / 3, 0.0));
        BaseShape middleRightStripe = mainStripe.rotate(-degrees15).translate(new Point2d(spacing / 3, 0.0));
        BaseShape rightStripe = mainStripe.rotate(degrees15).translate(new Point2d(spacing, 0.0));
        leftStripe.add(middleLeftStripe);
        leftStripe.add(middleRightStripe);
        leftStripe.add(rightStripe);
        return leftStripe;
    }

    // TODO
    public static BaseShape create_r() {
        /*Double degrees90 = Math.toRadians(90);
        Double spacing = stripeThickness * 2;
        BaseShape mainStripe = new Rectangle(stripeThickness, maxHeight);
        BaseShape leftStripe = mainStripe.translate(new Point2d(-spacing, 0.0));
        BaseShape halfStripe = new Rectangle(stripeThickness, maxWidth);
        BaseShape downStripe = halfStripe.rotate(degrees90).translate(new Point2d(0.0, -spacing));
        leftStripe.add(downStripe);
        return leftStripe;
                 */
        Double spacing = maxWidth/2 - stripeThickness/2;
        BaseShape mainStripe = new Rectangle(stripeThickness, maxHeight).translate(new Point2d(-spacing,0.0));
        for(int i = 0; i < 2*stripeThickness; i++) {
            mainStripe.add(new Ellipse(maxWidth-i,maxWidth-i).translate(new Point2d(0.0,-spacing)));
        }
        BaseShape modifier = new Rectangle(maxWidth-10.0,maxWidth);
        mainStripe.remove(modifier.translate(new Point2d(16.0,-spacing/12+2)));
        return mainStripe;
    }

    // TODO
    public static BaseShape create_d() {
        //D
        Double degrees90 = Math.toRadians(90);
        Double spacing = stripeThickness * 2;
        BaseShape mainStripe = new Rectangle(stripeThickness, maxHeight);
        BaseShape leftStripe = mainStripe.translate(new Point2d(-spacing, 0.0));
        BaseShape ellipse = new Ellipse(maxWidth,maxHeight);
        BaseShape halfEllipse=ellipse.translate(new Point2d(0.0,0.0));
        leftStripe.add(halfEllipse);
        return leftStripe;
    }

}
