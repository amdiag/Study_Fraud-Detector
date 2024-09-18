package org.amdiag.classes;

import org.amdiag.classes.fraudRule.FraudRule4;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FraudRule4Test {
    private FraudRule4 fraudRule = new FraudRule4();

    @Test
    public void shouldNotBeFraudTransactionFromOtherCountry() {
        Trader trader = new Trader("Candy", "city", "otherCountry");
        Transaction transaction = new Transaction(trader, 100);
        assertFalse(fraudRule.isFraud(transaction));
    }

    @Test
    public void shouldBeFraudTransactionFromJamaica() {
        Trader trader = new Trader("Candy", "cityInJamaica", "Jamaica");
        Transaction transaction = new Transaction(trader, 100);
        assertTrue(fraudRule.isFraud(transaction));
    }
}
