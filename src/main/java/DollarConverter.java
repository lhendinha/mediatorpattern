public class DollarConverter {

    Mediator mediator;

    public static final float DOLLAR_UNIT = 1.0f;
    public static final float CAD_UNIT = 0.79f;
    public static final float EURO_UNIT = 1.12f;

    public DollarConverter(Mediator mediator) {
        this.mediator = mediator;
        mediator.registerDollarConverter(this);
    }

    private float convertEurosToDollars(float euros) {
        float dollars = euros * (DOLLAR_UNIT / EURO_UNIT);
        System.out.println("Converting " + euros + " euros to " + dollars + " dollars");
        return dollars;
    }

    private float convertCadToDollars(float cad) {
        float dollars = cad * (DOLLAR_UNIT / CAD_UNIT);
        System.out.println("Converting " + cad + " cad to " + dollars + " dollars");
        return dollars;
    }

    public float convertCurrencyToDollars(float amount, String unitOfCurrency) {
        if ("cad".equalsIgnoreCase(unitOfCurrency)) {
            return convertCadToDollars(amount);
        } else {
            return convertEurosToDollars(amount);
        }
    }
}