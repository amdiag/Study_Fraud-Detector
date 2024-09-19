package org.amdiag.intarfaces;

import org.amdiag.classes.FraudDetectionResult;
import org.amdiag.classes.Transaction;

public interface FraudRule {
    FraudDetectionResult isFraud(Transaction transaction);
}
