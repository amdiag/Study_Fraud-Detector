package org.amdiag.classes;

import org.amdiag.classes.fraudRule.*;
import org.amdiag.intarfaces.FraudRule;

public class FraudDetector {
    private FraudRule rule1 = new FraudRule1();
    private FraudRule rule2 = new FraudRule2();
    private FraudRule rule3 = new FraudRule3();
    private FraudRule rule4 = new FraudRule4();
    private FraudRule rule5 = new FraudRule5();

    FraudDetectionResult isFraud(Transaction transaction) {
        var result = rule1.isFraud(transaction);
        if (result.isFraudResult()) return result;
        result = rule2.isFraud(transaction);
        if (result.isFraudResult()) return result;
        result = rule3.isFraud(transaction);
        if (result.isFraudResult()) return result;
        result = rule4.isFraud(transaction);
        if (result.isFraudResult()) return result;
        result = rule5.isFraud(transaction);
        if (result.isFraudResult()) return result;

        return result;
    }
}
