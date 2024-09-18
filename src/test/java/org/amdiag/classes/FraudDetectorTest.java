package org.amdiag.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FraudDetectorTest {
    private FraudDetector fraudDetector = new FraudDetector();

    @Test
    public void shouldBeFraudTransactionFromTraderPokemon() {
        Trader trader = new Trader("Pokemon", "city");
        Transaction transaction = new Transaction(trader, 100);
        assertTrue(fraudDetector.isFraud(transaction));
    }

    @Test
    public void shouldNotBeFraudTransactionFromOtherTraderNotPokemon() {
        Trader trader = new Trader("Other", "city");
        Transaction transaction = new Transaction(trader, 100);
        assertFalse(fraudDetector.isFraud(transaction));
    }

    @Test
    public void shouldNotBeFraudTransactionAmountLessThanThreshold() {
        Trader trader = new Trader("Candy", "city");
        Transaction transaction = new Transaction(trader, fraudDetector.getMaxThreshold() - 1);
        assertFalse(fraudDetector.isFraud(transaction));
    }

    @Test
    public void shouldBeFraudTransactionAmountMoreThanThreshold() {
        Trader trader = new Trader("Candy", "city");
        Transaction transaction = new Transaction(trader, fraudDetector.getMaxThreshold() + 1);
        assertTrue(fraudDetector.isFraud(transaction));
    }
}
