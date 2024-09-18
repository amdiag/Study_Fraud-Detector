package org.amdiag.classes.fraudRule;

import org.amdiag.classes.FraudConst;
import org.amdiag.classes.Transaction;
import org.amdiag.intarfaces.FraudRule;

public class FraudRule2 implements FraudRule {
    @Override
    public boolean isFraud(Transaction transaction) {
        //Rule2
        //If the transaction amount is greater than the threshold, then transaxtion is fraud
        return transaction.getAmount() > FraudConst.getMaxThreshold();
    }
}
