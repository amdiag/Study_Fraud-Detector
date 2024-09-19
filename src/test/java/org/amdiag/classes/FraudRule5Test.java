package org.amdiag.classes;

import org.amdiag.classes.fraudRule.FraudRule5;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FraudRule5Test {
    private FraudRule5 fraudRule = new FraudRule5();

    @Test
    public void shouldNotBeFraudTransactionFromOtherCountryAndAmountLessThan1000() {
        Trader trader = new Trader("Candy", "city", "otherCountry");
        Transaction transaction = new Transaction(trader, 999);
        assertEquals(fraudRule.isFraud(transaction), new FraudDetectionResult(false));
    }

    @Test
    public void shouldNotBeFraudTransactionFromGermanyAndAmountLessThan1000() {
        Trader trader = new Trader("Candy", "city", "Germany");
        Transaction transaction = new Transaction(trader, 999);
        assertEquals(fraudRule.isFraud(transaction), new FraudDetectionResult(false));
    }

    @Test
    public void shouldNotBeFraudTransactionFromOtherCountryAndAmountMoreThan1000() {
        Trader trader = new Trader("Candy", "city", "otherCountry");
        Transaction transaction = new Transaction(trader, 1001);
        assertEquals(fraudRule.isFraud(transaction), new FraudDetectionResult(false));
    }
    @Test
    public void shouldBeFraudTransactionFromGermanyAndAmountMoreThan1000() {
        Trader trader = new Trader("Candy", "city", "Germany");
        Transaction transaction = new Transaction(trader, 1001);
        assertEquals(fraudRule.isFraud(transaction), new FraudDetectionResult(true, "FraudRule5"));
    }
}
