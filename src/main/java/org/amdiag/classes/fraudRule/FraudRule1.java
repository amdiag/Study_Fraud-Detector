package org.amdiag.classes.fraudRule;

import org.amdiag.classes.Trader;
import org.amdiag.classes.Transaction;
import org.amdiag.intarfaces.FraudRule;

public class FraudRule1 implements FraudRule {
    @Override
    public boolean isFraud(Transaction transaction) {
        //Rule1
        // Trader Pokemon is frauder
        Trader trader = transaction.getTrader();
        return trader.getFullName().equals("Pokemon");
    }
}
