package org.amdiag.classes;

import org.amdiag.classes.fraudRule.FraudRule2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FraudRule2Test {
    private FraudRule2 fraudRule = new FraudRule2();

    @Test
    public void shouldNotBeFraudTransactionAmountLessThanThreshold() {
        Trader trader = new Trader("Candy", "city", "otherCountry");
        Transaction transaction = new Transaction(trader, FraudConst.getMaxThreshold() - 1);
        assertFalse(fraudRule.isFraud(transaction));
    }

    @Test
    public void shouldBeFraudTransactionAmountMoreThanThreshold() {
        Trader trader = new Trader("Candy", "city", "otherCountry");
        Transaction transaction = new Transaction(trader, FraudConst.getMaxThreshold() + 1);
        assertTrue(fraudRule.isFraud(transaction));
    }
}
