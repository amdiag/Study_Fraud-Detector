package org.amdiag.classes;

import org.amdiag.classes.fraudRule.FraudRule3;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FraudRule3Test {
    private FraudRule3 fraudRule = new FraudRule3();

    @Test
    public void shouldNotBeFraudTransactionFromOtherCity() {
        Trader trader = new Trader("Candy", "otherCity", "otherCountry");
        Transaction transaction = new Transaction(trader, 100);
        assertFalse(fraudRule.isFraud(transaction));
    }

    @Test
    public void shouldBeFraudTransactionFromSydney() {
        Trader trader = new Trader("Candy", "Sydney", "Australia");
        Transaction transaction = new Transaction(trader, 100);
        assertTrue(fraudRule.isFraud(transaction));
    }
}
