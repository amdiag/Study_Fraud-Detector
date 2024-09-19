package org.amdiag.classes.fraudRule;

import org.amdiag.classes.FraudDetectionResult;
import org.amdiag.classes.Trader;
import org.amdiag.classes.Transaction;
import org.amdiag.interfaces.FraudRule;

public class FraudRule4 implements FraudRule {
    @Override
    public FraudDetectionResult isFraud(Transaction transaction) {
        FraudDetectionResult result = new FraudDetectionResult(false);
        Trader trader = transaction.getTrader();
        //Rule4
        //If the trader is from Jamaica, then the transaction is fraud
        if(trader.getCountry().equals("Jamaica")){
            result.setFraud(true);
            result.setRuleName(this.getRuleName());
        }
        return result;
    }
}
