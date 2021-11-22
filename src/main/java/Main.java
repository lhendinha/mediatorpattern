public class Main {
    public static void main(String[] args) {
        float sellingPriceInDollars = 10.0f;

        Mediator mediator = new Mediator();
        Buyer canadianBuyer = new CanadianBuyer(mediator);
        Buyer frenchBuyer = new FrenchBuyer(mediator);
        AmericanSeller americanSeller = new AmericanSeller(mediator, sellingPriceInDollars);
        DollarConverter dollarConverter = new DollarConverter(mediator);

        float canadianBidInKronor = 32.4f;
        while (!canadianBuyer.attemptToPurchase(canadianBidInKronor)) {
            canadianBidInKronor += 1.05f;
        }

        float frenchBidInEuros = 64.8f;
        while (!frenchBuyer.attemptToPurchase(frenchBidInEuros)) {
            frenchBidInEuros += 0.2f;
        }
    }
}


