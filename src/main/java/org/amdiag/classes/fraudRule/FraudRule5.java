package org.amdiag.classes.fraudRule;

import org.amdiag.classes.FraudDetectionResult;
import org.amdiag.classes.Trader;
import org.amdiag.classes.Transaction;
import org.amdiag.intarfaces.FraudRule;

public class FraudRule5 implements FraudRule {
    @Override
    public FraudDetectionResult isFraud(Transaction transaction) {
        FraudDetectionResult result = new FraudDetectionResult(false);
        Trader trader = transaction.getTrader();
        //Rule5
        //If the country of the trader is Germany and the transaction amount is greater than 1000, transaction is fraud
        if(trader.getCountry().equals("Germany") && transaction.getAmount() > 1000){
            result.setFraud(true);
            result.setRuleName(this.getClass().getSimpleName());
        }
        return result;
    }
}
