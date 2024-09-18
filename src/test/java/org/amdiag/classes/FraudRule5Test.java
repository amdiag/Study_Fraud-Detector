package org.amdiag.classes;

import org.amdiag.classes.fraudRule.FraudRule5;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FraudRule5Test {
    private FraudRule5 fraudRule = new FraudRule5();

    @Test
    public void shouldNotBeFraudTransactionFromOtherCountryAndAmountLessThan1000() {
        Trader trader = new Trader("Candy", "city", "otherCountry");
        Transaction transaction = new Transaction(trader, 999);
        assertFalse(fraudRule.isFraud(transaction));
    }

    @Test
    public void shouldNotBeFraudTransactionFromGermanyAndAmountLessThan1000() {
        Trader trader = new Trader("Candy", "city", "Germany");
        Transaction transaction = new Transaction(trader, 999);
        assertFalse(fraudRule.isFraud(transaction));
    }

    @Test
    public void shouldNotBeFraudTransactionFromOtherCountryAndAmountMoreThan1000() {
        Trader trader = new Trader("Candy", "city", "otherCountry");
        Transaction transaction = new Transaction(trader, 1001);
        assertFalse(fraudRule.isFraud(transaction));
    }
    @Test
    public void shouldBeFraudTransactionFromGermanyAndAmountMoreThan1000() {
        Trader trader = new Trader("Candy", "city", "Germany");
        Transaction transaction = new Transaction(trader, 1001);
        assertTrue(fraudRule.isFraud(transaction));
    }
}
