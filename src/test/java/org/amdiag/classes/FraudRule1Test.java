package org.amdiag.classes;

import org.amdiag.classes.fraudRule.FraudRule1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FraudRule1Test {
    private FraudRule1 fraudRule = new FraudRule1();

    @Test
    public void shouldBeFraudTransactionFromTraderPokemon() {
        Trader trader = new Trader("Pokemon", "city", "otherCountry");
        Transaction transaction = new Transaction(trader, 100);
        assertTrue(fraudRule.isFraud(transaction).equals(new FraudDetectionResult(true, "FraudRule1")));
    }

    @Test
    public void shouldNotBeFraudTransactionFromOtherTraderNotPokemon() {
        Trader trader = new Trader("Other", "city", "otherCountry");
        Transaction transaction = new Transaction(trader, 100);
        assertEquals(fraudRule.isFraud(transaction), new FraudDetectionResult(false));
    }
}
