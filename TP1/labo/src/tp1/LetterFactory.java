package tp1;

public final class LetterFactory {
    final static Double maxHeight = 200.0;
    final static Double maxWidth = maxHeight / 2;
    final static Double halfMaxHeight = maxHeight / 2;
    final static Double halfMaxWidth = maxWidth / 2;
    final static Double stripeThickness = maxHeight / 10;

    // Lettre H
    public static BaseShape create_H() {
        Double spacing = stripeThickness*2;
        BaseShape mainStripe = new Rectangle(stripeThickness, maxHeight);
        BaseShape leftStripe = mainStripe.translate(new Point2d(-(spacing),0.0));
        BaseShape rightStripe = mainStripe.translate(new Point2d(spacing, 0.0));
        BaseShape middleStripe = new Rectangle(maxWidth, stripeThickness);
        leftStripe.add(middleStripe);
        leftStripe.add(rightStripe);
        return leftStripe;
    }

    // Lettre e
    public static BaseShape create_e() {
        Double spacing = 2*stripeThickness;
        BaseShape middleStripe = new Rectangle(maxWidth, stripeThickness);
        BaseShape mainEllipse = new Ellipse(maxWidth, maxHeight);
        for(int i = 0; i < spacing; i++) {
            middleStripe.add(new Ellipse(maxWidth-i,maxHeight-i));
        }
        BaseShape modifier = new Rectangle(100.0, stripeThickness).translate(new Point2d(spacing,stripeThickness));
        mainEllipse.add(middleStripe);
        mainEllipse.remove(modifier);
        return mainEllipse;
    }

    // Lettre l
    public static BaseShape create_l() {
        BaseShape mainStripe = new Rectangle(stripeThickness, maxHeight);
        return mainStripe;
    }

    // Lettre O
    public static BaseShape create_o() {
        Double spacing=2*stripeThickness;
        BaseShape ellipse = new Ellipse(maxWidth,maxHeight);
        for(int i = 0; i < spacing; i++) {
            ellipse.add(new Ellipse(maxWidth-i,maxHeight-i));
        }
        return ellipse;
    }

    // Lettre W
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

    // Lettre R
    public static BaseShape create_r() {
        Double spacing = stripeThickness * 2;
        BaseShape mainStripe = new Rectangle(stripeThickness,maxHeight);
        BaseShape leftStripe = mainStripe.translate(new Point2d(-spacing, 0.0));
        BaseShape topRound=new Ellipse(maxWidth,maxHeight);
        for(int i = 0; i < 2*stripeThickness; i++) {
            topRound.add(new Ellipse(maxWidth-i,maxHeight-i));
        }
        BaseShape lowerStripe = new Rectangle(maxWidth, maxHeight).translate(new Point2d(0.0,
                spacing));
        topRound.remove(lowerStripe);
        leftStripe.add(topRound);
        return leftStripe;
    }

    // Lettre D
    public static BaseShape create_d() {
        Double spacing = stripeThickness * 2;
        BaseShape mainStripe = new Ellipse(maxWidth,maxWidth).translate(new Point2d(0.0,spacing));
        for(int i=0; i<spacing; i++){
            mainStripe.add(new Ellipse(maxWidth-i,maxWidth-i)
                    .translate(new Point2d(0.0,spacing)));
        }
        mainStripe.add(new Rectangle(stripeThickness, maxHeight).translate(new Point2d(spacing,0.0)));
        return mainStripe;
    }
}