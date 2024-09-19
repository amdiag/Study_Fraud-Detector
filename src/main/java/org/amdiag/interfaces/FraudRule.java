package org.amdiag.interfaces;

import org.amdiag.classes.FraudDetectionResult;
import org.amdiag.classes.Transaction;

public interface FraudRule {
    FraudDetectionResult isFraud(Transaction transaction);

    default String getRuleName(){
        return this.getClass().getSimpleName();
    }
}
