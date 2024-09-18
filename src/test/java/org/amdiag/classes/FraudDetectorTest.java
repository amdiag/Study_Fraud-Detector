package org.amdiag.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FraudDetectorTest {
    private FraudDetector fraudDetector = new FraudDetector();

    @Test
    public void shouldBeFraudTransactionFromTraderPokemon() {
        Trader trader = new Trader("Pokemon", "city", "otherCountry");
        Transaction transaction = new Transaction(trader, 100);
        assertTrue(fraudDetector.isFraud(transaction));
    }

    @Test
    public void shouldNotBeFraudTransactionFromOtherTraderNotPokemon() {
        Trader trader = new Trader("Other", "city", "otherCountry");
        Transaction transaction = new Transaction(trader, 100);
        assertFalse(fraudDetector.isFraud(transaction));
    }

    @Test
    public void shouldNotBeFraudTransactionAmountLessThanThreshold() {
        Trader trader = new Trader("Candy", "city", "otherCountry");
        Transaction transaction = new Transaction(trader, fraudDetector.getMaxThreshold() - 1);
        assertFalse(fraudDetector.isFraud(transaction));
    }

    @Test
    public void shouldBeFraudTransactionAmountMoreThanThreshold() {
        Trader trader = new Trader("Candy", "city", "otherCountry");
        Transaction transaction = new Transaction(trader, fraudDetector.getMaxThreshold() + 1);
        assertTrue(fraudDetector.isFraud(transaction));
    }

    @Test
    public void shouldNotBeFraudTransactionFromOtherCity() {
        Trader trader = new Trader("Candy", "otherCity", "otherCountry");
        Transaction transaction = new Transaction(trader, 100);
        assertFalse(fraudDetector.isFraud(transaction));
    }

    @Test
    public void shouldBeFraudTransactionFromSydney() {
        Trader trader = new Trader("Candy", "Sydney", "Australia");
        Transaction transaction = new Transaction(trader, 100);
        assertTrue(fraudDetector.isFraud(transaction));
    }

    @Test
    public void shouldNotBeFraudTransactionFromOtherCountry() {
        Trader trader = new Trader("Candy", "city", "otherCountry");
        Transaction transaction = new Transaction(trader, 100);
        assertFalse(fraudDetector.isFraud(transaction));
    }

    @Test
    public void shouldBeFraudTransactionFromJamaica() {
        Trader trader = new Trader("Candy", "cityInJamaica", "Jamaica");
        Transaction transaction = new Transaction(trader, 100);
        assertTrue(fraudDetector.isFraud(transaction));
    }
}
