package tp1;

public final class LetterFactory {
    final static Double maxHeight = 200.0;
    final static Double maxWidth = maxHeight / 2;
    final static Double halfMaxHeight = maxHeight / 2;
    final static Double halfMaxWidth = maxWidth / 2;
    final static Double stripeThickness = maxHeight / 10;

    // TODO
    public static BaseShape create_H() {

        /*Double spacing = halfMaxWidth;
        BaseShape mainStripe = new Rectangle(stripeThickness, maxHeight);
        BaseShape leftStripe = mainStripe.translate(new Point2d(-spacing,0.0));
        BaseShape rightStripe = mainStripe.translate( new Point2d(-spacing,0.0));
        BaseShape middleStripe = new Rectangle(maxWidth, stripeThickness);
        leftStripe.add(middleStripe);
        leftStripe.add(rightStripe);
        return leftStripe;*/
        Double spacing = maxWidth/2 - stripeThickness/2;
        BaseShape mainStripe = new Rectangle(stripeThickness, maxHeight);
        BaseShape leftStripe = mainStripe.translate(new Point2d(-(spacing),0.0));
        BaseShape rightStripe = mainStripe.translate(new Point2d(spacing, 0.0));
        BaseShape middleStripe = new Rectangle(maxWidth - (2*stripeThickness), stripeThickness);
        leftStripe.add(middleStripe);
        leftStripe.add(rightStripe);
        return leftStripe;


    }

    // TODO
    public static BaseShape create_e() {
        //E
        Double spacing = halfMaxWidth - stripeThickness/2;
        BaseShape middleStripe = new Rectangle(maxWidth, stripeThickness);
        BaseShape mainEllipse = new Ellipse(maxWidth, maxHeight);
        for(int i = 0; i < 2*stripeThickness; i++) {
            middleStripe.add(new Ellipse(maxWidth-i,maxHeight-i));
        }
        BaseShape modifier = new Rectangle(100.0, stripeThickness).translate(new Point2d(spacing,stripeThickness));
        mainEllipse.add(middleStripe);
        mainEllipse.remove(modifier);
        return mainEllipse;


    }

    // TODO
    public static BaseShape create_l() {
        //L
        BaseShape mainStripe = new Rectangle(stripeThickness, maxHeight);
        return mainStripe;
    }

    // TODO
    public static BaseShape create_o() {
        //O
        BaseShape ellipse = new Ellipse(halfMaxWidth,halfMaxHeight);
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
        //R
       /* Double degrees90 = Math.toRadians(90);
        Double spacing = stripeThickness * 2;
        BaseShape mainStripe = new Rectangle(stripeThickness, maxHeight);
        BaseShape leftStripe = mainStripe.translate(new Point2d(-spacing, 0.0));
        BaseShape halfStripe = new Rectangle(stripeThickness, maxWidth);
        BaseShape downStripe = halfStripe.rotate(degrees90).translate(new Point2d(0.0, -spacing));
        leftStripe.add(downStripe);
        return leftStripe;*/
BaseShape mainStripe = new Rectangle(stripeThickness,maxHeight);
        BaseShape leftStripe = mainStripe.translate(new Point2d(-halfMaxWidth, 0.0));
        BaseShape topRound = new Ellipse(halfMaxWidth, halfMaxHeight);
        BaseShape lowerStripe = new Rectangle(maxWidth, maxHeight).translate(new Point2d(stripeThickness/2,
                halfMaxHeight/2 +stripeThickness));
        topRound.remove(lowerStripe);
        leftStripe.add(topRound);
        return leftStripe;
    }

    // TODO
    public static BaseShape create_d() {
        //D
       /* Double degrees90 = Math.toRadians(90);
        Double spacing = stripeThickness * 2;
        BaseShape mainStripe = new Rectangle(stripeThickness, maxHeight);
        BaseShape leftStripe = mainStripe.translate(new Point2d(-spacing, 0.0));
        BaseShape ellipse = new Ellipse(maxWidth,maxHeight);
        BaseShape halfEllipse=ellipse.translate(new Point2d(0.0,0.0));
        leftStripe.add(halfEllipse);
        return leftStripe;*/

        Double spacing = maxWidth/2 - stripeThickness/2;
        BaseShape mainStripe = new Rectangle(stripeThickness, maxHeight);
        BaseShape rightStripe= mainStripe.translate(new Point2d(spacing+5.0,0.0));
        for(int i = 0; i < 2*stripeThickness; i++) {
            mainStripe.add(new Ellipse(maxWidth-i,maxWidth-i).translate(new Point2d(0.0,spacing)));
        }
        return mainStripe;
    }
}
