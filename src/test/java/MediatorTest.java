import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MediatorTest {
    float sellingPriceInDollars = 10.0f;

    Mediator mediator = null;
    AmericanSeller americanSeller = null;
    DollarConverter dollarConverter = null;

    @BeforeEach
    void setUp() {
        mediator = new Mediator();
        americanSeller = new AmericanSeller(mediator, sellingPriceInDollars);
        dollarConverter = new DollarConverter(mediator);
    }

    @Test
    void testCanadianBuyer() {
        System.out.println("Running: testCanadianBuyer");

        Buyer canadianBuyer = new CanadianBuyer(mediator);

        float canadianBidInKronor = 32.4f;
        while (!canadianBuyer.attemptToPurchase(canadianBidInKronor)) {
            canadianBidInKronor += 1.05f;
        }

        assertEquals(canadianBuyer.unitOfCurrency, "cad");
    }

    @Test
    void testFrenchBuyer() {
        System.out.println("Running: testFrenchBuyer");

        Buyer frenchBuyer = new FrenchBuyer(mediator);

        float frenchBidInEuros = 64.8f;
        while (!frenchBuyer.attemptToPurchase(frenchBidInEuros)) {
            frenchBidInEuros += 0.2f;
        }

        assertEquals(frenchBuyer.unitOfCurrency, "euro");
    }
}