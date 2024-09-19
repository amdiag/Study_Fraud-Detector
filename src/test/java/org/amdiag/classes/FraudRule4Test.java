package org.amdiag.classes;

import org.amdiag.classes.fraudRule.FraudRule4;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FraudRule4Test {
    private FraudRule4 fraudRule = new FraudRule4();

    @Test
    public void shouldNotBeFraudTransactionFromOtherCountry() {
        Trader trader = new Trader("Candy", "city", "otherCountry");
        Transaction transaction = new Transaction(trader, 100);
        assertEquals(fraudRule.isFraud(transaction), new FraudDetectionResult(false));
    }

    @Test
    public void shouldBeFraudTransactionFromJamaica() {
        Trader trader = new Trader("Candy", "cityInJamaica", "Jamaica");
        Transaction transaction = new Transaction(trader, 100);
        assertEquals(fraudRule.isFraud(transaction), new FraudDetectionResult(true, "FraudRule4"));
    }
}
