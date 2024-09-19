package org.amdiag.classes;

import org.amdiag.classes.fraudRule.FraudRule2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FraudRule2Test {
    private FraudRule2 fraudRule = new FraudRule2();

    @Test
    public void shouldNotBeFraudTransactionAmountLessThanThreshold() {
        Trader trader = new Trader("Candy", "city", "otherCountry");
        Transaction transaction = new Transaction(trader, FraudConst.getMaxThreshold() - 1);
        assertEquals(fraudRule.isFraud(transaction), new FraudDetectionResult(false));
    }

    @Test
    public void shouldBeFraudTransactionAmountMoreThanThreshold() {
        Trader trader = new Trader("Candy", "city", "otherCountry");
        Transaction transaction = new Transaction(trader, FraudConst.getMaxThreshold() + 1);
        assertEquals(fraudRule.isFraud(transaction), new FraudDetectionResult(true, "FraudRule2"));
    }
}
