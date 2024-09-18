package org.amdiag.classes;

import org.amdiag.classes.fraudRule.FraudRule1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FraudRule1Test {
    private FraudRule1 fraudRule = new FraudRule1();

    @Test
    public void shouldBeFraudTransactionFromTraderPokemon() {
        Trader trader = new Trader("Pokemon", "city", "otherCountry");
        Transaction transaction = new Transaction(trader, 100);
        assertTrue(fraudRule.isFraud(transaction));
    }

    @Test
    public void shouldNotBeFraudTransactionFromOtherTraderNotPokemon() {
        Trader trader = new Trader("Other", "city", "otherCountry");
        Transaction transaction = new Transaction(trader, 100);
        assertFalse(fraudRule.isFraud(transaction));
    }
}
