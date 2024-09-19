package org.amdiag.classes;

import org.amdiag.classes.fraudRule.FraudRule3;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FraudRule3Test {
    private FraudRule3 fraudRule = new FraudRule3();

    @Test
    public void shouldNotBeFraudTransactionFromOtherCity() {
        Trader trader = new Trader("Candy", "otherCity", "otherCountry");
        Transaction transaction = new Transaction(trader, 100);
        assertEquals(fraudRule.isFraud(transaction), new FraudDetectionResult(false));
    }

    @Test
    public void shouldBeFraudTransactionFromSydney() {
        Trader trader = new Trader("Candy", "Sydney", "Australia");
        Transaction transaction = new Transaction(trader, 100);
        assertEquals(fraudRule.isFraud(transaction), new FraudDetectionResult(true, "FraudRule3"));
    }

    @Test
    public void shouldBeFraudTransactionFromMelbourne() {
        Trader trader = new Trader("Candy", "Melbourne", "Australia");
        Transaction transaction = new Transaction(trader, 100);
        assertEquals(fraudRule.isFraud(transaction), new FraudDetectionResult(true, "FraudRule3"));
    }
}
