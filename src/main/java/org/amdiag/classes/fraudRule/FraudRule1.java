package org.amdiag.classes.fraudRule;

import org.amdiag.classes.FraudDetectionResult;
import org.amdiag.classes.Trader;
import org.amdiag.classes.Transaction;
import org.amdiag.intarfaces.FraudRule;

public class FraudRule1 implements FraudRule {
    @Override
    public FraudDetectionResult isFraud(Transaction transaction) {
        FraudDetectionResult result = new FraudDetectionResult(false);
        //Rule1
        // Trader Pokemon is frauder
        Trader trader = transaction.getTrader();
        if (trader.getFullName().equals("Pokemon")) {
            result.setFraud(true);
            result.setRuleName(this.getClass().getSimpleName());
        }
        return result;
    }
}
