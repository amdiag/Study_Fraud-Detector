package org.amdiag.classes.fraudRule;

import org.amdiag.classes.FraudConst;
import org.amdiag.classes.FraudDetectionResult;
import org.amdiag.classes.Transaction;
import org.amdiag.intarfaces.FraudRule;

public class FraudRule2 implements FraudRule {
    @Override
    public FraudDetectionResult isFraud(Transaction transaction) {
        FraudDetectionResult result = new FraudDetectionResult(false);
        //Rule2
        //If the transaction amount is greater than the threshold, then transaxtion is fraud
        if(transaction.getAmount() > FraudConst.getMaxThreshold()){
            result.setFraud(true);
            result.setRuleName(this.getClass().getSimpleName());
        }
        return result;
    }
}
