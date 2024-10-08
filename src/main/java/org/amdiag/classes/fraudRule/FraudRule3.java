package org.amdiag.classes.fraudRule;

import org.amdiag.classes.FraudDetectionResult;
import org.amdiag.classes.Trader;
import org.amdiag.classes.Transaction;
import org.amdiag.interfaces.FraudRule;

import java.util.List;

public class FraudRule3 implements FraudRule {
    @Override
    public FraudDetectionResult isFraud(Transaction transaction) {
        FraudDetectionResult result = new FraudDetectionResult(false);
        Trader trader = transaction.getTrader();
        //Rule3
        //If the trader is from Sydney, then the transaction is fraud
        List<String> cities = List.of("Sydney", "Wellington", "Melbourne", "Brisbane");

        for(String city : cities) {
            if (trader.getCity().equals(city)) {
                result.setFraud(true);
                result.setRuleName(this.getRuleName());
            }
        }
        return result;
    }
}
