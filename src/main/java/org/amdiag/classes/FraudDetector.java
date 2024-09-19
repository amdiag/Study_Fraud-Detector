package org.amdiag.classes;

import org.amdiag.classes.fraudRule.*;
import org.amdiag.interfaces.FraudRule;

import java.util.List;

public class FraudDetector {
    private List<FraudRule> fraudRulesList = List.of(
            new FraudRule1(),
            new FraudRule2(),
            new FraudRule3(),
            new FraudRule4(),
            new FraudRule5()
    );

    FraudDetectionResult isFraud(Transaction transaction) {
        for (FraudRule rule : fraudRulesList) {
            if (rule.isFraud(transaction).isFraudResult()) {
                return new FraudDetectionResult(true, rule.getRuleName());
            }
        }

        return new FraudDetectionResult(false);

    }
}
