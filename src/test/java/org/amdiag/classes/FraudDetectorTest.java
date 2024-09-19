package org.amdiag.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FraudDetectorTest {

    private FraudDetector fraudDetector = new FraudDetector();

    @Test
    void testIsNotFraud() {
        Trader trader = new Trader("Trader", "city", "country");
        Transaction transaction = new Transaction(trader, 123);

        var result = fraudDetector.isFraud(transaction).isFraudResult();
        assertFalse(result);
    }

    @Test
    void testIsFraud() {
        Trader trader = new Trader("Pokemon", "city", "country");
        Transaction transaction = new Transaction(trader, 123);

        var result = fraudDetector.isFraud(transaction).isFraudResult();
        assertTrue(result);
    }

}
